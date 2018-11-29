package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * USING {BTREE | HASH}
 *
 * @author kongtong.ouyang on 2018/7/27.
 */
public enum SQLIndexType implements ISQLEnum {

    USING_BTREE(SQLReserved.USING_BTREE),
    USING_HASH(SQLReserved.USING_HASH),;

    public final SQLReserved name;

    SQLIndexType(SQLReserved name) {
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
