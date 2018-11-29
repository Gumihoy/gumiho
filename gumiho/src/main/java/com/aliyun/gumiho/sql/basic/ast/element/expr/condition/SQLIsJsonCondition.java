package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr IS [ NOT ] JSON [ FORMAT JSON ] [ STRICT | LAX ] [ { WITH | WITHOUT } UNIQUE KEYS ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SQL-JSON-Conditions.html#GUID-99B9493D-2929-4A09-BA39-A56F8E7319DA
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsJsonCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    protected boolean formatJson;

    protected SQLReserved option;

    protected SQLReserved uniqueKeys;

    public SQLIsJsonCondition() {
    }

    public SQLIsJsonCondition(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLIsJsonCondition clone() {
        SQLIsJsonCondition x = new SQLIsJsonCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIsJsonCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        x.not = this.not;

        x.formatJson = this.formatJson;

        x.option = this.option;

        x.uniqueKeys = this.uniqueKeys;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
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

    public boolean isFormatJson() {
        return formatJson;
    }

    public void setFormatJson(boolean formatJson) {
        this.formatJson = formatJson;
    }

    public SQLReserved getOption() {
        return option;
    }

    public void setOption(SQLReserved option) {
        this.option = option;
    }

    public SQLReserved getUniqueKeys() {
        return uniqueKeys;
    }

    public void setUniqueKeys(SQLReserved uniqueKeys) {
        this.uniqueKeys = uniqueKeys;
    }
}
