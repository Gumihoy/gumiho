package com.aliyun.gumiho.sql.dialect.oracle.ast.enums;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/plsql-error-handling.html#GUID-8C327B4A-71FA-4CFB-8BC9-4550A23734D6
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public enum OracleSQLPredefinedException {

    ACCESS_INTO_NULL(SQLReserved.ACCESS_INTO_NULL, -6530),
    CASE_NOT_FOUND(SQLReserved.CASE_NOT_FOUND, -6592),
    COLLECTION_IS_NULL(SQLReserved.COLLECTION_IS_NULL, -6531),
    CURSOR_ALREADY_OPEN(SQLReserved.CURSOR_ALREADY_OPEN, -6511),

    DUP_VAL_ON_INDEX(SQLReserved.DUP_VAL_ON_INDEX, -1),

    INVALID_CURSOR(SQLReserved.INVALID_CURSOR, -1001),

    INVALID_NUMBER(SQLReserved.INVALID_NUMBER, -1722),

    LOGIN_DENIED(SQLReserved.LOGIN_DENIED, -1017),

    NO_DATA_FOUND(SQLReserved.NO_DATA_FOUND, +100),

    NO_DATA_NEEDED(SQLReserved.NO_DATA_NEEDED, -6548),

    NOT_LOGGED_ON(SQLReserved.NOT_LOGGED_ON, -1012),

    PROGRAM_ERROR(SQLReserved.PROGRAM_ERROR, -6501),

    ROWTYPE_MISMATCH(SQLReserved.ROWTYPE_MISMATCH, -6504),

    SELF_IS_NULL(SQLReserved.SELF_IS_NULL, -30625),

    STORAGE_ERROR(SQLReserved.STORAGE_ERROR, -6500),

    SUBSCRIPT_BEYOND_COUNT(SQLReserved.SUBSCRIPT_BEYOND_COUNT, -6533),

    SUBSCRIPT_OUTSIDE_LIMIT(SQLReserved.SUBSCRIPT_OUTSIDE_LIMIT, -6532),

    SYS_INVALID_ROWID(SQLReserved.SYS_INVALID_ROWID, -1410),

    TIMEOUT_ON_RESOURCE(SQLReserved.TIMEOUT_ON_RESOURCE, -51),

    TOO_MANY_ROWS(SQLReserved.TOO_MANY_ROWS, -1422),

    VALUE_ERROR(SQLReserved.VALUE_ERROR, -6502),

    ZERO_DIVIDE(SQLReserved.ZERO_DIVIDE, -1476),;

    public final SQLReserved name;
    public final int code;

    OracleSQLPredefinedException(SQLReserved name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return name.upper;
    }
}
