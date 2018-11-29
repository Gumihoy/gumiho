package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSubQueryTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLLimitOffsetClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLAllColumnExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select.OracleSQLSelectQuery;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.List;

/**
 * 优化
 * 1、子查询 和 父查询 合并（父是*、子查询是*、父子selectItem相同） && (只有limit or 没有limit)
 * 2、
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLOptimizationASTVisitor extends SQLASTTransformVisitor {

    public SQLOptimizationASTVisitor() {
    }

    public SQLOptimizationASTVisitor(SQLTransformConfig config) {
        super(config);
    }


    // ------------------------- Expr Start ----------------------------------------

    // ------------------------- Expr End ----------------------------------------


    // ------------------------- Select Details Start ----------------------------------------
    @Override
    public boolean visit(SQLSelectQuery x) {
        optimizationQuery(x);
        return true;
    }

    @Override
    public boolean visit(OracleSQLSelectQuery x) {
        optimizationQuery(x);
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery x) {
        optimizationQuery(x);
        return true;
    }

    /**
     * 子查询 和 父查询 合并（父是*、子查询是*、父子selectItem相同） && (只有limit or 没有limit)
     */
    public void optimizationQuery(SQLSelectQuery x) {
        List<SQLSelectItem> selectItems = x.getSelectItems();

        // * / x.*
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

        boolean subQueryTableReference = x.getFromClause() != null
                && x.getFromClause().getTableReference() instanceof SQLSubQueryTableReference;

        if (!subQueryTableReference) {
            return;
        }

        ISQLSelectQuery subQuery = ((SQLSubQueryTableReference) x.getFromClause().getTableReference()).getSubQuery();

        boolean subSelectQueryQuery = subQuery instanceof SQLSelectQuery;

        boolean subAllColumn = false;
        if (!allColumn
                && subSelectQueryQuery) {

            List<SQLSelectItem> subSelectItems = ((SQLSelectQuery) subQuery).getSelectItems();

            if (subSelectItems.size() == 1) {
                SQLExpr expr = subSelectItems.get(0).getExpr();
                if (expr instanceof SQLAllColumnExpr) {
                    subAllColumn = true;
                } else if (expr instanceof SQLPropertyExpr
                        && ((SQLPropertyExpr) expr).getNameExpr() instanceof SQLAllColumnExpr) {
                    subAllColumn = true;
                }
            }

            if (!allColumn
                    && !subAllColumn) {

            }

        }


        if (allColumn
                && subSelectQueryQuery
                && x.getGroupByClause() == null
                && x.getOrderByClause() == null) {

            ISQLLimitClause limitClause = x.getLimitClause();

            if (limitClause instanceof SQLLimitOffsetClause) {
                ISQLLimitClause subQueryLimitClause = subQuery.getLimitClause();

                if (subQueryLimitClause == null) {
                    subQuery.setLimitClause(limitClause);

                } else if (subQueryLimitClause instanceof SQLLimitOffsetClause) {
                    if (((SQLLimitOffsetClause) limitClause).getRowCountExpr() != null) {

                        if (((SQLLimitOffsetClause) subQueryLimitClause).getRowCountExpr() != null) {

                        } else {
                            ((SQLLimitOffsetClause) subQueryLimitClause).setRowCountExpr(((SQLLimitOffsetClause) limitClause).getRowCountExpr());
                        }

                    }

                    if (((SQLLimitOffsetClause) limitClause).getOffsetExpr() != null) {

                        if (((SQLLimitOffsetClause) subQueryLimitClause).getOffsetExpr() != null) {

                        } else {
                            ((SQLLimitOffsetClause) subQueryLimitClause).setOffsetExpr(((SQLLimitOffsetClause) limitClause).getOffsetExpr());
                        }
                    }

                }
            }

            SQLUtils.replaceInParent(x, subQuery);
        }


    }

    // ------------------------- Select Details End ----------------------------------------


}
