package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/16.
 */
public enum SQLSubPartitionType implements ISQLEnum {

    SUBPARTITION(SQLReserved.SUBPARTITION),
    SUBPARTITIONS(SQLReserved.SUBPARTITIONS);

    public final SQLReserved name;

    SQLSubPartitionType(SQLReserved name) {
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
