package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/8/2.
 */
public enum SQLYesType implements ISQLEnum {
    YES(SQLReserved.YES),
    NO(SQLReserved.NO);

    public final SQLReserved name;

    SQLYesType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }
}
