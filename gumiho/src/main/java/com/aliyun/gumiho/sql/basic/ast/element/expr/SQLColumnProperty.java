package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * { object_type_col_properties
 * | nested_table_col_properties
 * | { varray_col_properties | LOB_storage_clause }
 * [ (LOB_partition_storage [, LOB_partition_storage ]...) ]
 * | XMLType_column_properties
 * }...
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/28.
 */
public interface SQLColumnProperty extends SQLExpr {

    @Override
    SQLColumnProperty clone();
}
