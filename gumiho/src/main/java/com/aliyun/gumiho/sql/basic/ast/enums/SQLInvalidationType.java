package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/9.
 */
public enum  SQLInvalidationType implements ISQLEnum{

    DEFERRED_INVALIDATION(SQLReserved.DEFERRED_INVALIDATION),
    IMMEDIATE_INVALIDATION(SQLReserved.IMMEDIATE_INVALIDATION);

    public final SQLReserved name;

    SQLInvalidationType(SQLReserved name) {
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
