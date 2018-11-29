package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * table_partitioning_clauses
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public interface SQLTablePartitioning extends SQLExpr {
    @Override
    SQLTablePartitioning clone();
}
