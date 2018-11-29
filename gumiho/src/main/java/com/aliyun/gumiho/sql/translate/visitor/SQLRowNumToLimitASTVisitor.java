package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLFromClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLHierarchicalQueryClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLLimitOffsetClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLAllColumnExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn.SQLRowNumExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBinaryOperator;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select.OracleSQLSelectQuery;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.List;

/**
 * ROWNUM to limit
 * ROWNUM 转换 Limit
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLRowNumToLimitASTVisitor extends SQLASTTransformVisitor {

    private Context context;
    protected boolean removeSelectItemRowNum = true;

    public SQLRowNumToLimitASTVisitor() {
    }

    public SQLRowNumToLimitASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    // ------------------------- Expr Start ----------------------------------------
    @Override
    public boolean visit(SQLRowNumExpr x) {
        if (removeSelectItemRowNum
                && x.getParent() instanceof SQLSelectItem
                && ((SQLSelectItem) x.getParent()).getExpr() == x) {
            SQLUtils.replaceInParent((SQLSelectItem) x.getParent(), null);
            return false;
        }
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLBinaryOperatorExpr x) {
        if (context == null
                || context.query == null) {
            return true;
        }

        SQLExpr left = x.getLeft();
        SQLBinaryOperator op = x.getOperator();
        SQLExpr right = x.getRight();

        boolean isRowNum = SQLUtils.isRowNum(left, context.query);

        if (isRowNum) {
            boolean replace = false;
            if (op == SQLBinaryOperator.LESS_THAN_OP) {
                replace = SQLUtils.replaceInParent(x, null);
                if (replace) {
                    context.setLimit(SQLIntegerLiteral.decrement(right));
                    // 如果存在 offset, 重新计算 rowCount
                    context.recalculateLimit();
                }
            } else if (op == SQLBinaryOperator.LESS_THAN_OR_EQUALS_OP) {
                if (SQLUtils.replaceInParent(x, null)) {
                    context.setLimit(right);
                    // 如果存在 offset, 重新计算 rowCount
                    context.recalculateLimit();
                }
            } else if (op == SQLBinaryOperator.EQUALS_OP) {
                if (SQLUtils.replaceInParent(x, null)) {
                    context.setLimit(right);
                    // 如果存在 offset, 重新计算 rowCount
                    context.recalculateLimit();
                }
            } else if (op == SQLBinaryOperator.GREATER_THAN_OP) {
                if (SQLUtils.replaceInParent(x, null)) {
                    context.setOffset(right);
                    // 如果存在 offset, 重新计算 rowCount
                    context.recalculateLimit();
                }
            } else if (op == SQLBinaryOperator.GREATER_THAN_OR_EQUALS_OP) {
                if (SQLUtils.replaceInParent(x, null)) {
                    context.setOffset(SQLIntegerLiteral.decrement(right));
                    // 如果存在 offset, 重新计算 rowCount
                    context.recalculateLimit();
                }
            }

            if (replace) {
                return false;
            }

        }


        return super.visit(x);
    }
    // ------------------------- Expr End ----------------------------------------


    // ------------------------- Select Details Start ----------------------------------------
    @Override
    public boolean visit(SQLSelectQuery x) {
        context = new Context(context, x);

        return false;
    }

    @Override
    public boolean visit(OracleSQLSelectQuery x) {
        context = new Context(context, x);

        ISQLWithClause withClause = x.getWithClause();
        if (withClause != null) {
            withClause.accept(this);
        }

        SQLWhereClause whereClause = x.getWhereClause();
        if (whereClause != null) {
            whereClause.accept(this);
        }

        SQLFromClause fromClause = x.getFromClause();
        if (fromClause != null) {
            fromClause.accept(this);
        }

        SQLHierarchicalQueryClause hierarchicalQueryClause = x.getHierarchicalQueryClause();
        if (hierarchicalQueryClause != null) {
            hierarchicalQueryClause.accept(this);
        }

        // 移除 ROWNUM
        List<SQLSelectItem> selectItems = x.getSelectItems();
        for (int i = 0; i < selectItems.size(); i++) {
            selectItems.get(i).accept(this);
        }

        // 子查询 合并
        boolean allColumn = false;
        if (selectItems.size() == 1) {
            SQLExpr expr = selectItems.get(0).getExpr();
            if (expr instanceof SQLAllColumnExpr) {
                allColumn = true;
            } else if (expr instanceof SQLPropertyExpr
                    && ((SQLPropertyExpr) expr).getNameExpr() instanceof SQLAllColumnExpr) {
                allColumn = true;
            }
        }


        return false;
    }

    // ------------------------- Select Details End ----------------------------------------


    private static class Context {
        public final Context parent;
        public final SQLSelectQuery query;

        public Context(Context parent, SQLSelectQuery query) {
            this.parent = parent;
            this.query = query;
        }

        public void setLimit(SQLExpr x) {
            if (query == null) {
                return;
            }

            // 最小值为: 0
            if (x instanceof SQLIntegerLiteral) {
                long val = ((SQLIntegerLiteral) x).getLongValue();
                if (val < 0) {
                    x = SQLIntegerLiteral.of(0);
                }
            }

            ISQLLimitClause limit = query.getLimitClause();
            if (limit == null) {
                limit = new SQLLimitOffsetClause();
            }

            if (limit instanceof SQLLimitOffsetClause) {
                query.setLimitClause(limit);
                ((SQLLimitOffsetClause) limit).setRowCountExpr(x);
            }
        }

        public void setOffset(SQLExpr x) {
            if (query == null) {
                return;
            }

            if (x instanceof SQLIntegerLiteral) {
                long val = ((SQLIntegerLiteral) x).getLongValue();
                if (val < 0) {
                    x = SQLIntegerLiteral.of(0);
                }
            }

            ISQLLimitClause limit = query.getLimitClause();
            if (limit == null) {
                limit = new SQLLimitOffsetClause();
            }
            if (limit instanceof SQLLimitOffsetClause) {
                query.setLimitClause(limit);
                ((SQLLimitOffsetClause) limit).setOffsetExpr(x);
            }
        }

        public void recalculateLimit() {

            if (query.getLimitClause() == null
                    || !(query.getLimitClause() instanceof SQLLimitOffsetClause)) {
                return;
            }

            SQLLimitOffsetClause limit = (SQLLimitOffsetClause) query.getLimitClause();

            if (limit.getRowCountExpr() != null
                    && limit.getOffsetExpr() != null) {

                SQLExpr rowCountExpr = SQLIntegerLiteral.subtract(limit.getRowCountExpr(), limit.getOffsetExpr());
                limit.setRowCountExpr(rowCountExpr);

            }
        }

    }


}
