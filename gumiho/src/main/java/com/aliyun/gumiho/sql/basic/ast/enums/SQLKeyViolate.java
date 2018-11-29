package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/27.
 */
public enum  SQLKeyViolate implements ISQLEnum {

    IGNORE(SQLReserved.IGNORE),
    REPLACE(SQLReserved.REPLACE),
    ;
    public final SQLReserved name;

    SQLKeyViolate(SQLReserved name) {
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
