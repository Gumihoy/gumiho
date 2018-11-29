package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#non-second%20primary%20datetime%20field
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/date-and-time-functions.html#function_date-add
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Literals.html#GUID-4C258D8F-3DF2-4D45-BE3E-14864DD77100
 *
 * @author kongtong.ouyang on 2018/5/14.
 */
public enum SQLIntervalUnit implements ISQLEnum {

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
    YEAR_MONTH(SQLReserved.YEAR_MONTH);;

    public final SQLReserved name;

    SQLIntervalUnit(SQLReserved name) {
        this.name = name;
    }

    public static SQLIntervalUnit of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        return SQLIntervalUnitHolder.MAP.get(lowerHashCode64);
    }

    @Override
    public SQLReserved getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.upper;
    }

    static class SQLIntervalUnitHolder {
        public final static ConcurrentHashMap<Long, SQLIntervalUnit> MAP = new ConcurrentHashMap<>();

        static {
            for (SQLIntervalUnit intervalUnit : SQLIntervalUnit.values()) {
                MAP.put(intervalUnit.name.lowerHashCode64, intervalUnit);
            }
        }
    }
}
