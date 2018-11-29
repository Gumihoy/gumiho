package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARTITION BY RANGE COLUMNS(column_list)
 * [PARTITIONS num]
 * [subPartitionBy]
 * [(partition_definition [, partition_definition] ...)]
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLPartitionByRangeColumns extends AbstractSQLPartitionBy {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, partitionsNum);
            this.acceptChild(visitor, subPartitionBy);
            this.acceptChild(visitor, partitions);
        }
    }

    @Override
    public SQLPartitionByRangeColumns clone() {
        SQLPartitionByRangeColumns x = new SQLPartitionByRangeColumns();
        this.cloneTo(x);
        return x;
    }
}
