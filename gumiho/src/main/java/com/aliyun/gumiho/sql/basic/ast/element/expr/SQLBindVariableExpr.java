package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * :xx
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Placeholder-Expressions.html#GUID-B98B5394-A573-4BF8-9EC3-7B1BB1130553
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLBindVariableExpr extends AbstractSQLExpr {

    protected String name;

    public SQLBindVariableExpr(String name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {

        }
    }

    @Override
    public SQLBindVariableExpr clone() {
        SQLBindVariableExpr x = new SQLBindVariableExpr(this.name);
        return x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = removeColon(name);
        this.name = name;
    }

    String removeColon(String name) {
        if (name.length() > 0
                && name.charAt(0) == ':') {
            name = name.substring(1);
        }
        return name;
    }
}
