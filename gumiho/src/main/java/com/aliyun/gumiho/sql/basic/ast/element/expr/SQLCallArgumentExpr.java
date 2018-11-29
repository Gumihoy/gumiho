package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * arg1 => 3
 * <p>
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_4008.htm#SQLRF01108
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CALL.html#GUID-6CD7B9C4-E5DC-4F3C-9B6A-876AD2C63545
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLCallArgumentExpr extends AbstractSQLExpr {

    protected SQLExpr name;
    protected SQLExpr value;


    public SQLCallArgumentExpr() {
    }

    public SQLCallArgumentExpr(SQLExpr name, SQLExpr value) {
        setName(name);
        setValue(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLCallArgumentExpr clone() {
        SQLCallArgumentExpr x = new SQLCallArgumentExpr();

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        SQLExpr valueClone = this.value.clone();
        x.setValue(valueClone);
        return x;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
