package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * CASCADE | RESTRICT
 *
 * @author kongtong.ouyang on 2018/6/12.
 */
public enum SQLCascadeType implements ISQLEnum {

    CASCADE(SQLReserved.CASCADE),
    CASCADE_CONSTRAINTS(SQLReserved.CASCADE_CONSTRAINTS),
    RESTRICT(SQLReserved.RESTRICT),;

    public final SQLReserved name;

    SQLCascadeType(SQLReserved name) {
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
