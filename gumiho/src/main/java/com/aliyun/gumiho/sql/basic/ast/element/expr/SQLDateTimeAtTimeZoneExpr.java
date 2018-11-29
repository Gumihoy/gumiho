package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr AT TIME ZONE { ' [ + | - ] hh:mi' | DBTIMEZONE | 'time_zone_name' | expr}
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Datetime-Expressions.html#GUID-F72A753A-98A4-4EBD-84E9-C014CE058384
 *
 * @author kongtong.ouyang on 2018/5/12.
 */
public class SQLDateTimeAtTimeZoneExpr extends AbstractSQLDateTimeExpr implements SQLDateTimeExpr {

    protected SQLExpr timeZone;

    public SQLDateTimeAtTimeZoneExpr() {
    }

    public SQLDateTimeAtTimeZoneExpr(SQLExpr expr, SQLExpr timeZone) {
        super(expr);
        setTimeZone(timeZone);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, timeZone);
        }
    }

    @Override
    public SQLDateTimeAtTimeZoneExpr clone() {
        SQLDateTimeAtTimeZoneExpr x = new SQLDateTimeAtTimeZoneExpr();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLDateTimeAtTimeZoneExpr x) {
        super.cloneTo(x);

        SQLExpr timeZoneClone = this.timeZone.clone();
        x.setTimeZone(timeZoneClone);
    }

    public SQLExpr getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(SQLExpr timeZone) {
        setChildParent(timeZone);
        this.timeZone = timeZone;
    }
}
