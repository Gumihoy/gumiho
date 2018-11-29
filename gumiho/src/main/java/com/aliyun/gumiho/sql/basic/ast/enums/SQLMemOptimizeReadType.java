package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/11.
 */
public enum SQLMemOptimizeReadType implements ISQLEnum {

    MEMOPTIMIZE_FOR_READ(SQLReserved.MEMOPTIMIZE_FOR_READ),
    NO_MEMOPTIMIZE_FOR_READ(SQLReserved.NO_MEMOPTIMIZE_FOR_READ);

    public final SQLReserved name;

    SQLMemOptimizeReadType(SQLReserved name) {
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
