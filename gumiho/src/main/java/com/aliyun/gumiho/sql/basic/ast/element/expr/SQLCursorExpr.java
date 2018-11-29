package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CURSOR (subquery)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CURSOR-Expressions.html#GUID-B28362BE-8831-4687-89CF-9F77DB3698D2
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLCursorExpr extends AbstractSQLExpr {

    protected ISQLSelectQuery subQuery;

    public SQLCursorExpr() {
    }

    public SQLCursorExpr(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
        }
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }
}
