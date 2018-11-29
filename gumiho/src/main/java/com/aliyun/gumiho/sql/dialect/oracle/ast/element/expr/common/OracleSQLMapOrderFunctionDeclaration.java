package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 *
 * { MAP | ORDER } MEMBER function_spec
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
 *
 * @author kongtong.ouyang on 2018/6/18.
 */
public class OracleSQLMapOrderFunctionDeclaration extends AbstractOracleSQLExpr {

    protected SQLType type;
    protected SQLExpr expr;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }


    public SQLType getType() {
        return type;
    }

    public void setType(SQLType type) {
        this.type = type;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public enum SQLType {
        MAP("MAP"),
        ORDER("ORDER"),;

        public final String name;

        SQLType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
