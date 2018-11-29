package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * select statement
 *
 * (select statement)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Creating-Simple-Queries.html#GUID-DB044D5C-A960-4813-84DA-A1880C913339
 *
 * @author kongtong.ouyang on 2018/5/3.
 */
public class SQLSelectQueryExpr extends AbstractSQLExpr {

    protected boolean paren;
    protected ISQLSelectQuery subQuery;

    public SQLSelectQueryExpr() {
    }

    public SQLSelectQueryExpr(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
        }
    }

    @Override
    public SQLSelectQueryExpr clone() {
        SQLSelectQueryExpr x = new SQLSelectQueryExpr();

        ISQLSelectQuery subQueryClone = subQuery.clone();
        x.setSubQuery(subQueryClone);

        return x;
    }

    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }
}
