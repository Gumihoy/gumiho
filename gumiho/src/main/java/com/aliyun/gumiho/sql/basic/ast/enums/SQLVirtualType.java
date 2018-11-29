package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/6.
 */
public enum SQLVirtualType implements ISQLEnum {

    VIRTUAL(SQLReserved.VIRTUAL),
    STORED(SQLReserved.STORED);

    public final SQLReserved name;

    SQLVirtualType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }
}
