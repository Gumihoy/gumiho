package com.aliyun.gumiho.sql.basic.ast.enums;

/**
 * ALLOW ANYSCHEMA | ALLOW NONSCHEMA | DISALLOW NONSCHEMA
 * <p>
 * alter_XMLSchema_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/17.
 */
public enum SQLAlterXmlSchemaType implements ISQLEnum {

    ALLOW_ANYSCHEMA(SQLReserved.ALLOW_ANYSCHEMA),
    ALLOW_NONSCHEMA(SQLReserved.ALLOW_NONSCHEMA),
    DISALLOW_NONSCHEMA(SQLReserved.DISALLOW_NONSCHEMA),
    ;


    public final SQLReserved name;

    SQLAlterXmlSchemaType(SQLReserved name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.upper;
    }

    @Override
    public SQLReserved getName() {
        return null;
    }
}
