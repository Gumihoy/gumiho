package com.aliyun.gumiho.sql.dialect.drds.ast.enums;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.3adf785cQNhh2B
 * @author kongtong.ouyang on 2018/9/3.
 */
public enum DRDSSQLDBPartitionType implements ISQLEnum {

    HASH(SQLReserved.HASH),
    RANGE_HASH(SQLReserved.RANGE_HASH);

    public final SQLReserved name;

    DRDSSQLDBPartitionType(SQLReserved name) {
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
