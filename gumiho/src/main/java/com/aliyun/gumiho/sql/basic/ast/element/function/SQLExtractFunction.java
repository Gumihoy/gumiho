package com.aliyun.gumiho.sql.basic.ast.element.function;

import static com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved.EXTRACT;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLFunctionType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * EXTRACT( { YEAR | MONTH | DAY | HOUR | MINUTE | SECOND | TIMEZONE_HOUR | TIMEZONE_MINUTE | TIMEZONE_REGION | TIMEZONE_ABBR } FROM { expr })
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#extract%20expression
 * <p>
 * EXTRACT(unit FROM date)
 * https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_extract
 * <p>
 * https://www.postgresql.org/docs/devel/static/functions-datetime.html#FUNCTIONS-DATETIME-EXTRACT
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/EXTRACT-datetime.html#GUID-36E52BF8-945D-437D-9A3C-6860CABD210E
 *
 * @author kongtong.ouyang on 2018/4/30.
 */
public class SQLExtractFunction extends AbstractSQLFunction {

    protected SQLUnit unit;

    public SQLExtractFunction() {
        super(EXTRACT.ofExpr());
    }

    public SQLExtractFunction(SQLUnit unit, SQLExpr argument) {
        super(EXTRACT.ofExpr());
        this.unit = unit;
        this.addArgument(argument);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLUnit getUnit() {
        return unit;
    }

    public void setUnit(SQLUnit unit) {
        this.unit = unit;
    }

    {
        this.addFunctionType(SQLFunctionType.Datetime);
    }

    /**
     * https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-add
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/EXTRACT-datetime.html#GUID-36E52BF8-945D-437D-9A3C-6860CABD210E
     */
    public enum SQLUnit {

        MICROSECOND(SQLReserved.MICROSECOND),
        SECOND(SQLReserved.SECOND),
        MINUTE(SQLReserved.MINUTE),
        HOUR(SQLReserved.HOUR),
        DAY(SQLReserved.DAY),
        WEEK(SQLReserved.WEEK),
        MONTH(SQLReserved.MONTH),
        QUARTER(SQLReserved.QUARTER),
        YEAR(SQLReserved.YEAR),
        SECOND_MICROSECOND(SQLReserved.SECOND_MICROSECOND),
        MINUTE_MICROSECOND(SQLReserved.MINUTE_MICROSECOND),
        MINUTE_SECOND(SQLReserved.MINUTE_SECOND),
        HOUR_MICROSECOND(SQLReserved.HOUR_MICROSECOND),
        HOUR_SECOND(SQLReserved.HOUR_SECOND),
        HOUR_MINUTE(SQLReserved.HOUR_MINUTE),
        DAY_MICROSECOND(SQLReserved.DAY_MICROSECOND),
        DAY_SECOND(SQLReserved.DAY_SECOND),
        DAY_MINUTE(SQLReserved.DAY_MINUTE),
        DAY_HOUR(SQLReserved.DAY_HOUR),
        YEAR_MONTH(SQLReserved.YEAR_MONTH),

        TIMEZONE_HOUR(SQLReserved.TIMEZONE_HOUR),
        TIMEZONE_MINUTE(SQLReserved.TIMEZONE_MINUTE),
        TIMEZONE_REGION(SQLReserved.TIMEZONE_REGION),
        TIMEZONE_ABBR(SQLReserved.TIMEZONE_ABBR),;

        public final SQLReserved name;

        SQLUnit(SQLReserved name) {
            this.name = name;
        }

        public static SQLUnit of(String name) {
            long hash = FNVHash.fnv1a_64_lower(name);
            for (SQLUnit unit : SQLUnit.values()) {
                if (unit.name.lowerHashCode64 == hash) {
                    return unit;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return name.upper;
        }


    }

}
