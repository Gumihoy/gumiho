package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr AT LOCAL
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Datetime-Expressions.html#GUID-F72A753A-98A4-4EBD-84E9-C014CE058384
 *
 * @author kongtong.ouyang on 2018/5/12.
 */
public class SQLDateTimeAtLocalExpr extends AbstractSQLDateTimeExpr implements SQLDateTimeExpr {

    public SQLDateTimeAtLocalExpr() {
    }

    public SQLDateTimeAtLocalExpr(SQLExpr expr) {
        super(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLDateTimeAtLocalExpr clone() {
        SQLDateTimeAtLocalExpr x = new SQLDateTimeAtLocalExpr();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLDateTimeAtLocalExpr x) {
        super.cloneTo(x);
    }

}
