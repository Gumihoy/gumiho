package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * LOCAL | GLOBAL
 * @author kongtong.ouyang on 2018/6/27.
 */
public enum SQLLocalType {

    LOCAL(SQLReserved.LOCAL),
    GLOBAL(SQLReserved.GLOBAL);
    public final SQLReserved name;

    SQLLocalType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }
}
