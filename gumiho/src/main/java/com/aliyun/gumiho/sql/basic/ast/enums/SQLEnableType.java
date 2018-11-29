package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public enum SQLEnableType implements ISQLEnum {

    ENABLE(SQLReserved.ENABLE),
    DISABLE(SQLReserved.DISABLE),;

    public final SQLReserved name;

    SQLEnableType(SQLReserved name) {
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
