package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * INITIALLY DEFERRED | INITIALLY IMMEDIATE
 *
 * @author kongtong.ouyang on 2018/7/14.
 */
public enum SQLInitiallyType implements ISQLEnum {

    INITIALLY_DEFERRED(SQLReserved.INITIALLY_DEFERRED),
    INITIALLY_IMMEDIATE(SQLReserved.INITIALLY_IMMEDIATE);

    public final SQLReserved name;

    SQLInitiallyType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }

    @Override
    public SQLReserved getName() {
        return null;
    }
}
