package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

import java.util.List;

/**
 * partition_definition 中的 VALUES
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * range_values_clause、list_values_clause
 *
 * VALUES LESS THAN ( expr (COMMA expr)* )
 * VALUES ( expr (COMMA expr)* )
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public interface ISQLPartitionValues extends SQLExpr {

    List<SQLExpr> getValues();

    @Override
    ISQLPartitionValues clone();
}
