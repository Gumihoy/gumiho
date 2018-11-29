package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * function type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/functions.html
 * <p>
 * https://www.postgresql.org/docs/devel/static/functions.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Functions.html#GUID-D079EFD3-C683-441F-977E-2C9503089982
 *
 * @author kongtong.ouyang on 2018/5/21.
 */
public enum SQLFunctionType {

    Numeric,
    String,
    String_Set,
    Collation,
    Datetime,
    Comparison,
    Conversion,
    Large_Object,
    Collection,
    Hierarchical,
    Data_Mining,
    XML,
    JSON,
    Encoding_And_Decoding,
    NULL_Related,
    Environment_And_Identifier,
    Aggregate,
    Window,
    Object_Reference,
    Model,
    OLAP,
    Data_Cartridge,;

}
