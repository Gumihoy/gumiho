package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Datetime-Expressions.html#GUID-F72A753A-98A4-4EBD-84E9-C014CE058384
 *
 * @author kongtong.ouyang on 2018/5/12.
 */
public abstract class AbstractSQLDateTimeExpr extends AbstractSQLExpr implements SQLDateTimeExpr {

    protected SQLExpr expr;

    public AbstractSQLDateTimeExpr() {
    }

    public AbstractSQLDateTimeExpr(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    public AbstractSQLDateTimeExpr clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLDateTimeExpr x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
