package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ( expr1 - expr2 ) { DAY [ (leading_field_precision) ] TO SECOND [ (fractional_second_precision) ] | YEAR [ (leading_field_precision) ] TO MONTH}
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Interval-Expressions.html#GUID-EB9B5B5D-357B-494C-A237-153A2CF8425C
 *
 * @author kongtong.ouyang on 2018/9/13.
 */
public class SQLIntervalExpr extends AbstractSQLExpr {

    protected SQLExpr value1;
    protected SQLExpr value2;

    protected SQLUnit unit;
    protected SQLExpr precision;

    protected SQLToUnit toUnit;
    protected SQLExpr toPrecision;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value1);
            this.acceptChild(visitor, value2);
            this.acceptChild(visitor, precision);
            this.acceptChild(visitor, toPrecision);
        }
    }


    public SQLExpr getValue1() {
        return value1;
    }

    public void setValue1(SQLExpr value1) {
        setChildParent(value1);
        this.value1 = value1;
    }

    public SQLExpr getValue2() {
        return value2;
    }

    public void setValue2(SQLExpr value2) {
        setChildParent(value2);
        this.value2 = value2;
    }

    public SQLUnit getUnit() {
        return unit;
    }

    public void setUnit(SQLUnit unit) {
        this.unit = unit;
    }

    public SQLExpr getPrecision() {
        return precision;
    }

    public void setPrecision(SQLExpr precision) {
        setChildParent(precision);
        this.precision = precision;
    }

    public SQLToUnit getToUnit() {
        return toUnit;
    }

    public void setToUnit(SQLToUnit toUnit) {
        this.toUnit = toUnit;
    }

    public SQLExpr getToPrecision() {
        return toPrecision;
    }

    public void setToPrecision(SQLExpr toPrecision) {
        setChildParent(toPrecision);
        this.toPrecision = toPrecision;
    }

    public enum SQLUnit implements ISQLEnum {
        DAY(SQLReserved.DAY),
        YEAR(SQLReserved.YEAR);

        public final SQLReserved name;

        SQLUnit(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum SQLToUnit implements ISQLEnum {
        SECOND(SQLReserved.SECOND),
        MONTH(SQLReserved.MONTH);
        public final SQLReserved name;

        SQLToUnit(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
