package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPhysicalProperty;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * INMEMORY [ inmemory_memcompress ] | NO INMEMORY } ( column [, column ]... )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public interface IOracleSQLInMemoryColumnClause extends OracleSQLExpr, ISQLPhysicalProperty {
    @Override
    IOracleSQLInMemoryColumnClause clone();
}