package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr IS [ NOT ] INFINITE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Floating-Point-Conditions.html#GUID-D7707649-2C93-4553-BF78-F461F17A634E
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsInfiniteCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    public SQLIsInfiniteCondition() {
    }

    public SQLIsInfiniteCondition(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLIsInfiniteCondition clone() {
        SQLIsInfiniteCondition x = new SQLIsInfiniteCondition();

        this.cloneTo(x);


        return x;
    }

    public void cloneTo(SQLIsInfiniteCondition x) {
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
        this.expr = expr;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }
}
