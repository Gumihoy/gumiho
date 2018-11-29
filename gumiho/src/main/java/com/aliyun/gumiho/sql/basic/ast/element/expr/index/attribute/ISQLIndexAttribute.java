package com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.ISQLIndexProperty;

/**
 * [ { physical_attributes_clause
 * | logging_clause
 * | ONLINE
 * | TABLESPACE { tablespace | DEFAULT }
 * | index_compression
 * | { SORT | NOSORT }
 * | REVERSE
 * | VISIBLE | INVISIBLE
 * | partial_index_clause
 * | parallel_clause
 * }...
 * ]
 * <p>
 * index_attributes
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/6/26.
 */
public interface ISQLIndexAttribute extends SQLExpr, ISQLIndexProperty {
    @Override
    ISQLIndexAttribute clone();
}
