package com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionByRange;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * GLOBAL PARTITION BY RANGE ( column [, column]... )
 * [ STORE IN ( tablespace [, tablespace]... ) ]]
 * ( range_partition_desc [, range_partition_desc ]... )
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLGlobalPartitionByRange extends SQLPartitionByRange implements ISQLGlobalPartitionBy {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, partitionsNum);
            this.acceptChild(visitor, storeInClause);
            this.acceptChild(visitor, subPartitionBy);
            this.acceptChild(visitor, partitions);
        }
    }

    @Override
    public SQLGlobalPartitionByRange clone() {
        SQLGlobalPartitionByRange x = new SQLGlobalPartitionByRange();
        this.cloneTo(x);
        return x;
    }

}
