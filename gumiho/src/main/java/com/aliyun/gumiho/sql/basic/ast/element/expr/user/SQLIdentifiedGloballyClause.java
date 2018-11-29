package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IDENTIFIED GLOBALLY [AS asExpr]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-USER.html#GUID-F0246961-558F-480B-AC0F-14B50134621C
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLIdentifiedGloballyClause extends AbstractSQLExpr {

    protected SQLExpr asExpr;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, asExpr);
        }
    }

    public SQLExpr getAsExpr() {
        return asExpr;
    }

    public void setAsExpr(SQLExpr asExpr) {
        this.asExpr = asExpr;
    }
}
