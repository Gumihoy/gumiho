package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/6.
 */
public enum SQLUsableType implements ISQLEnum {

    USABLE(SQLReserved.USABLE),
    UNUSABLE(SQLReserved.UNUSABLE);

    public final SQLReserved name;

    SQLUsableType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }
}
