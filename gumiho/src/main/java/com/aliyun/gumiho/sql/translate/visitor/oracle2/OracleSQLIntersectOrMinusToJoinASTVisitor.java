package com.aliyun.gumiho.sql.translate.visitor.oracle2;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.SQLIsNullCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBinaryOperator;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLUnionOperator;
import com.aliyun.gumiho.sql.translate.visitor.SQLASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Intersect To Inner Join
 * Minus To Left Join
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class OracleSQLIntersectOrMinusToJoinASTVisitor extends SQLASTTransformVisitor {

    protected ConcurrentHashMap<String, AtomicInteger> Alias_Map = new ConcurrentHashMap<>();

    public OracleSQLIntersectOrMinusToJoinASTVisitor() {
    }

    public OracleSQLIntersectOrMinusToJoinASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    // ------------------------- Expr Start ----------------------------------------

    // ------------------------- Expr End ----------------------------------------


    // ------------------------- Select Details Start ----------------------------------------

    @Override
    public boolean visit(SQLSelectUnionQuery x) {
        SQLUnionOperator op = x.getOperator();

        if (op != SQLUnionOperator.MINUS
                && op != SQLUnionOperator.INTERSECT) {
            return true;
        }

        if (x.getLeft() instanceof SQLSelectUnionQuery) {
            x.getLeft().accept(this);
        }

        SQLSelectQuery leftSubQuery = (SQLSelectQuery) x.getLeft();
        SQLSelectQuery rightSubQuery = (SQLSelectQuery) x.getRight();

        List<SQLSelectItem> leftSelectItems = leftSubQuery.getSelectItems();
        List<SQLSelectItem> rightSelectItems = rightSubQuery.getSelectItems();

        if (leftSelectItems.size() != rightSelectItems.size()) {
            return true;
        }


        List<SQLName> leftColumns = new ArrayList<>();
        List<SQLName> rightColumns = new ArrayList<>();

        for (SQLSelectItem item : leftSelectItems) {
            SQLExpr expr = item.getExpr();
            if (!(expr instanceof SQLName)) {
                return true;
            }
            leftColumns.add((SQLName) expr);
        }

        for (SQLSelectItem item : rightSelectItems) {
            SQLExpr expr = item.getExpr();
            if (!(expr instanceof SQLName)) {
                return true;
            }
            rightColumns.add((SQLName) expr);
        }

        String leftAlias = null;
        if (leftSubQuery.getFromClause().getTableReference().getAlias() != null) {
            leftAlias = leftSubQuery.getFromClause().getTableReference().getAlias().getName();
        }

        String rightAlias = null;
        if (rightSubQuery.getFromClause().getTableReference().getAlias() != null) {
            rightAlias = rightSubQuery.getFromClause().getTableReference().getAlias().getName();
        }

        if (leftAlias == null
                && leftSubQuery.getFromClause().getTableReference() instanceof SQLObjectNameTableReference) {
            String tableName = ((SQLObjectNameTableReference) rightSubQuery.getFromClause().getTableReference()).getTableName();
            String newAlias = tableName.substring(0, 1).toLowerCase();
            AtomicInteger aliasCount = Alias_Map.get(newAlias);
            if (aliasCount == null) {
                aliasCount = new AtomicInteger(1);
            }
            Alias_Map.put(newAlias, aliasCount);
            newAlias += aliasCount.getAndIncrement();
            ((SQLObjectNameTableReference) leftSubQuery.getFromClause().getTableReference()).setAlias(newAlias);
            leftAlias = newAlias;
        }

        if (rightAlias == null
                && rightSubQuery.getFromClause().getTableReference() instanceof SQLObjectNameTableReference) {
            String tableName = ((SQLObjectNameTableReference) rightSubQuery.getFromClause().getTableReference()).getTableName();
            String newAlias = tableName.substring(0, 1).toLowerCase();
            AtomicInteger aliasCount = Alias_Map.get(newAlias);
            if (aliasCount == null) {
                aliasCount = new AtomicInteger(1);
            }
            Alias_Map.put(newAlias, aliasCount);

            newAlias += aliasCount.getAndIncrement();

            ((SQLObjectNameTableReference) rightSubQuery.getFromClause().getTableReference()).setAlias(newAlias);
            rightAlias = newAlias;
        }

        SQLJoinTableReference.SQLJoinType joinType = SQLJoinTableReference.SQLJoinType.LEFT_JOIN;
        if (op == SQLUnionOperator.INTERSECT) {
            joinType = SQLJoinTableReference.SQLJoinType.INNER_JOIN;
        }

        SQLExpr condition = null;

        for (int i = 0; i < leftColumns.size(); i++) {
            SQLName leftColumn = leftColumns.get(i).clone();
            if (leftColumn instanceof SQLIdentifier) {
                leftColumn = SQLPropertyExpr.of(leftAlias, leftColumn);
            }

            SQLName rightColumn = rightColumns.get(i).clone();
            if (rightColumn instanceof SQLIdentifier) {
                rightColumn = SQLPropertyExpr.of(rightAlias, rightColumn);
            }
            condition = SQLBinaryOperatorExpr.and(condition, SQLBinaryOperatorExpr.of(leftColumn, SQLBinaryOperator.EQUALS_OP, rightColumn));
        }


        ISQLTableReference joinTableReference = SQLJoinTableReference.addTableReference(leftSubQuery.getFromClause().getTableReference(), joinType, rightSubQuery.getFromClause().getTableReference());
        if (joinTableReference instanceof SQLJoinTableReference) {
            ((SQLJoinTableReference) joinTableReference).setCondition(SQLJoinTableReference.SQLJoinOnCondition.of(condition));
        }

        SQLExpr whereCondition = null;
        if (op == SQLUnionOperator.MINUS) {
            SQLPropertyExpr expr = new SQLPropertyExpr(rightAlias, rightColumns.get(0));
            whereCondition = new SQLIsNullCondition(expr);
        }

        for (SQLSelectItem selectItem : leftSubQuery.getSelectItems()) {
            SQLExpr expr = selectItem.getExpr();
            if (expr instanceof SQLIdentifier) {
                selectItem.setExpr(SQLPropertyExpr.of(leftAlias, (SQLIdentifier) expr));
            }
        }

        leftSubQuery.getFromClause().setTableReference(joinTableReference);
        leftSubQuery.andWhereCondition(whereCondition);

        boolean replace = SQLUtils.replaceInParent(x, leftSubQuery);
        if (replace) {

        }

        return false;
    }


    // ------------------------- Select Details End ----------------------------------------


}
