package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/24.
 */
public enum  SQLCharsetNameType implements ISQLEnum {
    ;
    public final SQLReserved name;

    SQLCharsetNameType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public SQLReserved getName() {
        return null;
    }
}
