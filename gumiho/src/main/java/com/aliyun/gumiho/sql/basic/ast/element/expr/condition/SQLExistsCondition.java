package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * EXISTS (subquery)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/EXISTS-Condition.html#GUID-20259A83-C42B-4E0D-8DF4-9A2A66ACA8E7
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLExistsCondition extends AbstractSQLExpr implements ISQLCondition {

    protected ISQLSelectQuery subQuery;

    public SQLExistsCondition(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
        }
    }

    @Override
    public SQLExistsCondition clone() {
        ISQLSelectQuery subQueryClone = this.subQuery.clone();
        SQLExistsCondition x = new SQLExistsCondition(subQueryClone);

        this.cloneTo(x);
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }


    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }
}
