package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr IS [ NOT ] NULL
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Null-Conditions.html#GUID-657F2BA6-5687-4A00-8C2F-57515FD2DAEB
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsNullCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    public SQLIsNullCondition() {
    }

    public SQLIsNullCondition(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLIsNanCondition clone() {
        SQLIsNanCondition x = new SQLIsNanCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIsNanCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        x.not = this.not;
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
}
