package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr1 [ NOT ] BETWEEN expr2 AND expr3
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/BETWEEN-Condition.html#GUID-868A7C9D-EDF9-44E7-91B5-C3F69E503CCB
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLBetweenCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    protected SQLExpr between;

    protected SQLExpr and;


    public SQLBetweenCondition(SQLExpr expr, SQLExpr between, SQLExpr and) {
        setExpr(expr);
        setBetween(between);
        setAnd(and);
    }

    public SQLBetweenCondition(SQLExpr expr, boolean not, SQLExpr between, SQLExpr and) {
        setExpr(expr);
        setBetween(between);
        setAnd(and);
        this.not = not;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, between);
            this.acceptChild(visitor, and);
        }
    }

    @Override
    public SQLBetweenCondition clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLExpr betweenClone = this.between.clone();
        SQLExpr andClone = this.and.clone();

        SQLBetweenCondition x = new SQLBetweenCondition(exprClone, betweenClone, andClone);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLBetweenCondition x) {
        super.cloneTo(x);

        x.not = this.not;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == between) {
            setBetween(target);
            return true;
        }

        if (source == and) {
            setAnd(target);
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SQLBetweenCondition that = (SQLBetweenCondition) o;

        if (not != that.not) {
            return false;
        }
        if (expr != null ? !expr.equals(that.expr) : that.expr != null) {
            return false;
        }

        if (between != null ? !between.equals(that.between) : that.between != null) {
            return false;
        }

        return and != null ? and.equals(that.and) : that.and == null;
    }

    @Override
    public int hashCode() {
        int result = expr != null ? expr.hashCode() : 0;
        result = 31 * result + (not ? 1 : 0);
        result = 31 * result + (between != null ? between.hashCode() : 0);
        result = 31 * result + (and != null ? and.hashCode() : 0);
        return result;
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

    public SQLExpr getBetween() {
        return between;
    }

    public void setBetween(SQLExpr between) {
        this.between = between;
    }

    public SQLExpr getAnd() {
        return and;
    }

    public void setAnd(SQLExpr and) {
        this.and = and;
    }
}
