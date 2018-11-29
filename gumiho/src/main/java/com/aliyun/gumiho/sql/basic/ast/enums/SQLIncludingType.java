package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * INCLUDING | EXCLUDING
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public enum SQLIncludingType implements ISQLEnum {

    INCLUDING(SQLReserved.INCLUDING),
    EXCLUDING(SQLReserved.EXCLUDING),;

    public final SQLReserved name;

    SQLIncludingType(SQLReserved name) {
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
