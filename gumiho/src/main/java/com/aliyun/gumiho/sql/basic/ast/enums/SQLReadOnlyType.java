package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/26.
 */
public enum SQLReadOnlyType implements ISQLEnum {

    READ_ONLY(SQLReserved.READ_ONLY),
    READ_WRITE(SQLReserved.READ_WRITE);

    public final SQLReserved name;

    SQLReadOnlyType(SQLReserved name) {
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
