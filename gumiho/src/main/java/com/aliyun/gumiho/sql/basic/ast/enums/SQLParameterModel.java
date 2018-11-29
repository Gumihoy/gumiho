package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public enum SQLParameterModel {

    IN(SQLReserved.IN),
    OUT(SQLReserved.OUT),
    INOUT(SQLReserved.INOUT),
    IN_OUT(SQLReserved.IN_OUT),;

    public final SQLReserved name;

    SQLParameterModel(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }
}
