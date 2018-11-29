package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/5/1.
 */
public enum SQLRowType {

    ROW(SQLReserved.ROW),
    ROWS(SQLReserved.ROWS);

    public final SQLReserved name;

    SQLRowType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }
}
