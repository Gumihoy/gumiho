package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * WITH
 * WITHOUT
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public enum SQLWithType implements ISQLEnum {

    WITH(SQLReserved.WITH),
    WITHOUT(SQLReserved.WITHOUT),;

    public final SQLReserved name;

    SQLWithType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.upper;
    }


}
