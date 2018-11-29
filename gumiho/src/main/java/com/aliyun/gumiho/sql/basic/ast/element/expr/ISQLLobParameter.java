package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * { { ENABLE | DISABLE } STORAGE IN ROW
 * | CHUNK integer
 * | PCTVERSION integer
 * | FREEPOOLS integer
 * | LOB_retention_clause
 * | LOB_deduplicate_clause
 * | LOB_compression_clause
 * | { ENCRYPT encryption_spec | DECRYPT }
 * | { CACHE | NOCACHE | CACHE READS } [ logging_clause ]
 * }...
 * <p>
 * <p>
 * LOB_parameters
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public interface ISQLLobParameter extends SQLExpr, ISQLLobStorageParameter {
    @Override
    ISQLLobParameter clone();
}
