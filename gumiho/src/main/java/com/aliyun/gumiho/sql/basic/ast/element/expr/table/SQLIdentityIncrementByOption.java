package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * Increment By value
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLIdentityIncrementByOption extends AbstractSQLExpr implements SQLIdentityOption {

    protected SQLExpr value;

//    protected boolean by = true;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLIdentityIncrementByOption clone() {

        SQLIdentityIncrementByOption x = new SQLIdentityIncrementByOption();
        SQLExpr valueClone = this.value.clone();
        x.setValue(valueClone);

        return x;
    }


    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
