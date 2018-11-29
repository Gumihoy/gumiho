package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * INDEX|KEY
 *
 * @author kongtong.ouyang on 2018/7/27.
 */
public enum SQLIndexFormat implements ISQLEnum {

    INDEX(SQLReserved.INDEX),
    KEY(SQLReserved.KEY),;

    public final SQLReserved name;

    SQLIndexFormat(SQLReserved name) {
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
