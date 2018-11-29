package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr [ NOT ] MEMBER [ OF ] nested_table
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Multiset-Conditions.html#GUID-E8164A15-715A-40A0-944D-26DF4C84DE3F
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLMemberCondition extends AbstractSQLExpr implements ISQLCondition{

    protected SQLExpr expr;

    protected boolean not;

    protected boolean of;

    protected SQLName nestedTable;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, nestedTable);
        }
    }

    @Override
    public SQLMemberCondition clone() {
        SQLMemberCondition x = new SQLMemberCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLMemberCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        x.not = this.not;
        x.of = this.of;

        SQLName nestedTableClone = this.nestedTable.clone();
        x.setNestedTable(nestedTableClone);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == nestedTable
                && target instanceof SQLName) {
            setNestedTable((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
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

    public SQLName getNestedTable() {
        return nestedTable;
    }

    public void setNestedTable(SQLName nestedTable) {
        setChildParent(nestedTable);
        this.nestedTable = nestedTable;
    }
}
