package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.ISQLIndexAttribute;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * prefix_compression | advanced_index_compression
 * <p>
 * index_compression
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/26.
 */
public interface IOracleSQLIndexCompression extends OracleSQLExpr, ISQLIndexAttribute {
    @Override
    IOracleSQLIndexCompression clone();
}
