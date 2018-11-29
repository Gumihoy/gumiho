package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IDENTIFIED BY password
 * https://dev.mysql.com/doc/refman/5.7/en/create-user.html
 * <p>
 * IDENTIFIED BY password [ [HTTP] DIGEST { ENABLE | DISABLE } ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-USER.html#GUID-F0246961-558F-480B-AC0F-14B50134621C
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLIdentifiedByClause extends AbstractSQLExpr {

    protected SQLExpr password;

    protected SQLIdentifiedByOptionType optionType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, password);
        }
    }

    public SQLExpr getPassword() {
        return password;
    }

    public void setPassword(SQLExpr password) {
        setChildParent(password);
        this.password = password;
    }

    public SQLIdentifiedByOptionType getOptionType() {
        return optionType;
    }

    public void setOptionType(SQLIdentifiedByOptionType optionType) {
        this.optionType = optionType;
    }

    public enum SQLIdentifiedByOptionType {

        DIGEST_ENABLE("DIGEST ENABLE"),
        DIGEST_DISABLE("DIGEST DISABLE"),
        HTTP_DIGEST_ENABLE("HTTP DIGEST ENABLE"),
        HTTP_DIGEST_DISABLE("HTTP DIGEST DISABLE"),;

        public final String name;

        SQLIdentifiedByOptionType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
