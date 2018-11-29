package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/6.
 */
public enum SQLNullOrderingType implements ISQLEnum {

    NULLS_FIRST(SQLReserved.NULLS_FIRST),
    NULLS_LAST(SQLReserved.NULLS_LAST);

    public final SQLReserved name;

    SQLNullOrderingType(SQLReserved name) {
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
