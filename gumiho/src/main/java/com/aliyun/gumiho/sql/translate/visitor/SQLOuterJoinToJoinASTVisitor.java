package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLOuterJoinExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLJoinTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLObjectNameTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select.OracleSQLSelectQuery;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * outer join(+) => LEFT JOIN
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLOuterJoinToJoinASTVisitor extends SQLASTTransformVisitor {

    public SQLOuterJoinToJoinASTVisitor() {
    }

    public SQLOuterJoinToJoinASTVisitor(SQLTransformConfig config) {
        super(config);
    }


    // ------------------------- Operators Start ----------------------------------------

    @Override
    public boolean visit(SQLBinaryOperatorExpr x) {

        SQLExpr left = x.getLeft();
        SQLExpr right = x.getRight();

        SQLOuterJoinExpr leftOuterExpr = null, rightOuterExpr = null;

        if (left instanceof SQLOuterJoinExpr) {
            leftOuterExpr = (SQLOuterJoinExpr) left;
        }

        if (x.getRight() instanceof SQLOuterJoinExpr) {
            rightOuterExpr = (SQLOuterJoinExpr) right;
        }

        if (leftOuterExpr == null
                && rightOuterExpr == null) {
            return true;
        }

        if (leftOuterExpr != null) {

        }
        if (rightOuterExpr != null) {

        }

        SQLSelectQuery selectQuery = null;
        for (SQLObject parent = x.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof SQLSelectQuery) {
                selectQuery = (SQLSelectQuery) parent;
                break;
            }
        }

        if (selectQuery == null) {
            return true;
        }

        ISQLTableReference tableReference = null;
        if (selectQuery.getFromClause() == null
                || selectQuery.getFromClause().getTableReference() == null) {
            return true;
        }

        tableReference = selectQuery.getFromClause().getTableReference();


        return true;
    }

    // ------------------------- Operators End ----------------------------------------


    // ------------------------- Expressions Start ----------------------------------------

    @Override
    public boolean visit(SQLOuterJoinExpr x) {
        SQLUtils.replaceInParent(x, x.getName());
        return true;
    }

    // ------------------------- Expressions End ----------------------------------------


    // (+) => LEFT JOIN
    @Override
    public boolean visit(OracleSQLSelectQuery x) {

        if (x.getFromClause() == null
                || x.getFromClause().getTableReference() == null
                || x.getWhereClause() == null
                || x.getWhereClause().getCondition() == null) {
            return true;
        }

        List<SQLBinaryOperatorExpr> outerJoinBinaryOps = new ArrayList<>();
        boolean hasOuterJoin = hasOuterJoin(x.getWhereClause().getCondition(), outerJoinBinaryOps);
        if (!hasOuterJoin) {
            return true;
        }

        ISQLTableReference tableReference = x.getFromClause().getTableReference();

        for (SQLBinaryOperatorExpr outerJoinBinaryOp : outerJoinBinaryOps) {

            SQLPropertyExpr left = null, right = null;
            SQLJoinTableReference.SQLJoinType joinType = null;

            if (outerJoinBinaryOp.getLeft() instanceof SQLOuterJoinExpr
                    && ((SQLOuterJoinExpr) outerJoinBinaryOp.getLeft()).getName() instanceof SQLPropertyExpr
                    && outerJoinBinaryOp.getRight() instanceof SQLPropertyExpr) {

                left = (SQLPropertyExpr) ((SQLOuterJoinExpr) outerJoinBinaryOp.getLeft()).getName();
                right = (SQLPropertyExpr) outerJoinBinaryOp.getRight();

                joinType = SQLJoinTableReference.SQLJoinType.RIGHT_JOIN;
            }

            if (outerJoinBinaryOp.getLeft() instanceof SQLPropertyExpr
                    && outerJoinBinaryOp.getRight() instanceof SQLOuterJoinExpr
                    && ((SQLOuterJoinExpr) outerJoinBinaryOp.getRight()).getName() instanceof SQLPropertyExpr) {
                left = (SQLPropertyExpr) outerJoinBinaryOp.getLeft();
                right = (SQLPropertyExpr) ((SQLOuterJoinExpr) outerJoinBinaryOp.getRight()).getName();

                joinType = SQLJoinTableReference.SQLJoinType.LEFT_JOIN;
            }

            if (left == null
                    || right == null) {
                continue;
            }

            SQLPropertyExpr newLeft = left.clone();
            SQLPropertyExpr newRight = right.clone();

            // A   A.aid = A.bid
            SQLName newLeftOwner = (SQLName) newLeft.getOwner();
            SQLName newRightOwner = (SQLName) newRight.getOwner();

            if (SQLUtils.nameEqualsIgnoreCase(newLeftOwner, newRightOwner, false)) {
                String alias = newLeftOwner.getName().substring(0, 1) + "2";
                SQLObjectNameTableReference addRight = SQLObjectNameTableReference.of(newLeftOwner.getName(), alias);
                tableReference = SQLJoinTableReference.addTableReference(tableReference.clone(), joinType, addRight);
                SQLUtils.replaceInParent(x.getFromClause().getTableReference(), tableReference);
                SQLUtils.replaceInParent(newRightOwner, SQLUtils.ofName(alias));
            }

            SQLBinaryOperatorExpr condition = SQLBinaryOperatorExpr.of(newLeft, outerJoinBinaryOp.getOperator(), newRight);

            if (tableReference instanceof SQLJoinTableReference) {
                boolean addOnConditionIfAbsent = ((SQLJoinTableReference) tableReference).addOnConditionIfAbsent((SQLName) newLeft.getOwner(), joinType, (SQLName) newRight.getOwner(), condition);
                if (addOnConditionIfAbsent) {
                    SQLUtils.replaceInParent(outerJoinBinaryOp, null);
                }
            }

        }

        return true;
    }


    private boolean hasOuterJoin(SQLExpr x, List<SQLBinaryOperatorExpr> outerJoinBinaryOps) {
        if (x instanceof SQLBinaryOperatorExpr) {
            return hasOuterJoin((SQLBinaryOperatorExpr) x, outerJoinBinaryOps);
        }

        return false;
    }

    private boolean hasOuterJoin(SQLBinaryOperatorExpr x, List<SQLBinaryOperatorExpr> outerJoinBinaryOps) {
        boolean hasOuterJoin = false;

        if (x.getLeft() instanceof SQLOuterJoinExpr
                || x.getRight() instanceof SQLOuterJoinExpr) {
            outerJoinBinaryOps.add(x);
            return true;
        }

        if (x.getLeft() instanceof SQLBinaryOperatorExpr) {
            hasOuterJoin |= hasOuterJoin(x.getLeft(), outerJoinBinaryOps);
        }
        if (x.getRight() instanceof SQLBinaryOperatorExpr) {
            hasOuterJoin |= hasOuterJoin(x.getRight(), outerJoinBinaryOps);
        }

        return hasOuterJoin;
    }

}
