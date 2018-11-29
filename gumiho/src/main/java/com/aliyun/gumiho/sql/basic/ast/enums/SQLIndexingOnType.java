package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/26.
 */
public enum SQLIndexingOnType implements ISQLEnum {

    INDEXING_ON(SQLReserved.INDEXING_ON),
    INDEXING_OFF(SQLReserved.INDEXING_OFF);

    public final SQLReserved name;

    SQLIndexingOnType(SQLReserved name) {
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
