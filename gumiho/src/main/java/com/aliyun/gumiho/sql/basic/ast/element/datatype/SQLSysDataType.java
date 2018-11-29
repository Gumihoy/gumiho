package com.aliyun.gumiho.sql.basic.ast.element.datatype;

/**
 * SYS.XXX
 * "SYS"."xxx"
 * 系统数据类型
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/8/2.
 */
public interface SQLSysDataType extends SQLDataType {

    @Override
    SQLSysDataType clone();
}
