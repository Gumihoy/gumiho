package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * integer { { DAY | DAYS } | { MONTH | MONTHS } | { YEAR | YEARS } }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLIlmTimePeriod extends AbstractOracleSQLExpr {

    protected SQLExpr value;
    protected IlmTimePeriodUnit unit;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }


    @Override
    public OracleSQLIlmTimePeriod clone() {
        OracleSQLIlmTimePeriod x = new OracleSQLIlmTimePeriod();

        SQLExpr valueClone = this.value.clone();
        x.setValue(valueClone);

        x.unit = this.unit;
        return x;
    }


    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        this.value = value;
    }

    public IlmTimePeriodUnit getUnit() {
        return unit;
    }

    public void setUnit(IlmTimePeriodUnit unit) {
        this.unit = unit;
    }

    public enum IlmTimePeriodUnit {
        DAY(SQLReserved.DAY),
        DAYS(SQLReserved.DAYS),
        MONTH(SQLReserved.MONTH),
        MONTHS(SQLReserved.MONTHS),
        YEAR(SQLReserved.YEAR),
        YEARS(SQLReserved.YEARS),;

        public final SQLReserved name;

        IlmTimePeriodUnit(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
