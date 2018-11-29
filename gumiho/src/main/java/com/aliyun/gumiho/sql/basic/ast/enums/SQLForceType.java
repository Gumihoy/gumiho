package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/13.
 */
public enum SQLForceType implements ISQLEnum {

    NOFORCE(SQLReserved.NOFORCE),
    FORCE(SQLReserved.FORCE);

    public final SQLReserved name;

    SQLForceType(SQLReserved name) {
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
