package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/named-cursor-attribute.html#GUID-CD8D8415-FF19-4D81-99BA-7825FD40CC96
 * @author kongtong.ouyang on 2018/7/2.
 */
public interface IOracleSQLNameCursorExpr extends OracleSQLExpr {
    @Override
    IOracleSQLNameCursorExpr clone();
}
