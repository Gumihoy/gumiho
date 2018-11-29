package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.ISQLAlterTableIotAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * { MAPPING TABLE | NOMAPPING }
 * <p>
 * mapping_table_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/27.
 */
public interface IOracleSQLMappingTableClause extends OracleSQLExpr, ISQLAlterTableIotAction {
    @Override
    IOracleSQLMappingTableClause clone();
}