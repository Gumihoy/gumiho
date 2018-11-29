package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/16.
 */
public enum SQLPartitionType implements ISQLEnum {

    PARTITION(SQLReserved.PARTITION),
    PARTITIONS(SQLReserved.PARTITIONS);

    public final SQLReserved name;

    SQLPartitionType(SQLReserved name) {
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
