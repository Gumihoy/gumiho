package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * @author kongtong.ouyang on 2018/6/26.
 */
public enum SQLAllowDisallowClusteringType implements ISQLEnum {

    ALLOW_CLUSTERING(SQLReserved.ALLOW_CLUSTERING),
    DISALLOW_CLUSTERING(SQLReserved.DISALLOW_CLUSTERING);

    public final SQLReserved name;

    SQLAllowDisallowClusteringType(SQLReserved name) {
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
