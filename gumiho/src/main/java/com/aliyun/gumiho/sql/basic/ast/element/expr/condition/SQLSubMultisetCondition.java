package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * nested_table1 [ NOT ] SUBMULTISET [ OF ] nested_table2
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Multiset-Conditions.html#GUID-E8164A15-715A-40A0-944D-26DF4C84DE3F
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLSubMultisetCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLName nestedTable1;

    protected boolean not;

    protected boolean of;

    protected SQLName nestedTable2;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nestedTable1);
            this.acceptChild(visitor, nestedTable2);
        }
    }


    @Override
    public SQLSubMultisetCondition clone() {
        SQLSubMultisetCondition x = new SQLSubMultisetCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLSubMultisetCondition x) {
        super.cloneTo(x);

        SQLName nestedTable1Clone = this.nestedTable1.clone();
        x.setNestedTable1(nestedTable1Clone);

        x.not = this.not;
        x.of = this.of;

        SQLName nestedTable2Clone = this.nestedTable2.clone();
        x.setNestedTable2(nestedTable2Clone);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == nestedTable1
                && target instanceof SQLName) {
            setNestedTable1((SQLName) target);
            return true;
        }
        if (source == nestedTable2
                && target instanceof SQLName) {
            setNestedTable2((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLName getNestedTable1() {
        return nestedTable1;
    }

    public void setNestedTable1(SQLName nestedTable1) {
        setChildParent(nestedTable1);
        this.nestedTable1 = nestedTable1;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public boolean isOf() {
        return of;
    }

    public void setOf(boolean of) {
        this.of = of;
    }

    public SQLName getNestedTable2() {
        return nestedTable2;
    }

    public void setNestedTable2(SQLName nestedTable2) {
        setChildParent(nestedTable2);
        this.nestedTable2 = nestedTable2;
    }
}
