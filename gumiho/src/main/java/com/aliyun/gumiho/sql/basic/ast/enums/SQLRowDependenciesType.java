package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/7/19.
 */
public enum SQLRowDependenciesType implements ISQLEnum {
    ROWDEPENDENCIES(SQLReserved.ROWDEPENDENCIES),
    NOROWDEPENDENCIES(SQLReserved.NOROWDEPENDENCIES) ;

    public final SQLReserved name;

    SQLRowDependenciesType(SQLReserved name) {
        this.name = name;
    }



    @Override
    public SQLReserved getName() {
        return name;
    }
}
