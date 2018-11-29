package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * nested_table IS [ NOT ] EMPTY
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Multiset-Conditions.html#GUID-E8164A15-715A-40A0-944D-26DF4C84DE3F
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsEmptyCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLName nestedTable;

    protected boolean not;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nestedTable);
        }
    }

    @Override
    public SQLIsEmptyCondition clone() {
        SQLIsEmptyCondition x = new SQLIsEmptyCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIsEmptyCondition x) {
        super.cloneTo(x);

        SQLName nestedTableClone = this.nestedTable.clone();
        x.setNestedTable(nestedTableClone);

        x.not = this.not;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == nestedTable
                && target instanceof SQLName) {
            setNestedTable((SQLName)target);
            return true;
        }
        return false;
    }

    public SQLName getNestedTable() {
        return nestedTable;
    }

    public void setNestedTable(SQLName nestedTable) {
        setChildParent(nestedTable);
        this.nestedTable = nestedTable;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }
}
