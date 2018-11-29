package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * COMPRESS [HIGH | MEDIUM | LOW ] | NOCOMPRESS
 *
 * LOB_compression_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public interface IOracleSQLLobCompressionClause extends OracleSQLExpr, ISQLLobParameter {
    @Override
    IOracleSQLLobCompressionClause clone();
}
