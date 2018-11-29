package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */
public enum SQLWaitType implements ISQLEnum {

    WAIT(SQLReserved.WAIT),
    NOWAIT(SQLReserved.NOWAIT),;
    public final SQLReserved name;

    SQLWaitType(SQLReserved name) {
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
