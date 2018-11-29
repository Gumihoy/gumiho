package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/22.
 */
public enum SQLVisibleType implements ISQLEnum {

    VISIBLE(SQLReserved.VISIBLE),
    INVISIBLE(SQLReserved.INVISIBLE),;

    public final SQLReserved name;

    SQLVisibleType(SQLReserved name) {
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
