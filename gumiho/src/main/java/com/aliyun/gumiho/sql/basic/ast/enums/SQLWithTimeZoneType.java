package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/4/19.
 */
public enum SQLWithTimeZoneType implements ISQLEnum {

    WITH_TIME_ZONE(SQLReserved.WITH_TIME_ZONE),
    WITHOUT_TIME_ZONE(SQLReserved.WITHOUT_TIME_ZONE),
    WITH_LOCAL_TIME_ZONE(SQLReserved.WITH_LOCAL_TIME_ZONE),;

    public final SQLReserved name;

    SQLWithTimeZoneType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }


    @Override
    public SQLReserved getName() {
        return name;
    }
}
