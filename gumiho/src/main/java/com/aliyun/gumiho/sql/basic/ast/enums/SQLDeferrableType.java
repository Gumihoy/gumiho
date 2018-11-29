package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * DEFERRABLE | NOT DEFERRABLE
 *
 * @author kongtong.ouyang on 2018/7/14.
 */
public enum SQLDeferrableType implements ISQLEnum {

    DEFERRABLE(SQLReserved.DEFERRABLE),
    NOT_DEFERRABLE(SQLReserved.NOT_DEFERRABLE);

    public final SQLReserved name;

    SQLDeferrableType(SQLReserved name) {
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
