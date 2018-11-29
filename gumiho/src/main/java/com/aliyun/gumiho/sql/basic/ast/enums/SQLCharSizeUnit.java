package com.aliyun.gumiho.sql.basic.ast.enums;


/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public enum SQLCharSizeUnit implements ISQLEnum {

    BYTE(SQLReserved.BYTE),
    CHAR(SQLReserved.CHAR),;

    public final SQLReserved name;

    SQLCharSizeUnit(SQLReserved name) {
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
