package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NO AUTHENTICATION
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-USER.html#GUID-F0246961-558F-480B-AC0F-14B50134621C
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLNoAuthenticationClause extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNoAuthenticationClause clone() {
        return new SQLNoAuthenticationClause();
    }
}
