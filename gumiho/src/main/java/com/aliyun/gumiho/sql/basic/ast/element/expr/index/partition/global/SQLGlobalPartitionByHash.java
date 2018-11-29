package com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLCompression;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLOverflowStoreInClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionByHash;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * GLOBAL PARTITION BY HASH (column [, column ] ...)
 * { individual_hash_partitions
 * | hash_partitions_by_quantity
 * }
 * hash_partitions_by_quantity :
 * PARTITIONS hash_partition_quantity
 * [ STORE IN (tablespace [, tablespace ]...) ]
 * [ table_compression | index_compression ]
 * [ OVERFLOW STORE IN (tablespace [, tablespace ]...) ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLGlobalPartitionByHash extends SQLPartitionByHash implements ISQLGlobalPartitionBy {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, partitionsNum);
            this.acceptChild(visitor, storeInClause);
            this.acceptChild(visitor, compression);
            this.acceptChild(visitor, overflowStoreInClause);
            this.acceptChild(visitor, subPartitionBy);
            this.acceptChild(visitor, partitions);
        }
    }

    @Override
    public SQLGlobalPartitionByHash clone() {
        SQLGlobalPartitionByHash x = new SQLGlobalPartitionByHash();
        this.cloneTo(x);
        return x;
    }


    public ISQLCompression getCompression() {
        return compression;
    }

    public void setCompression(ISQLCompression compression) {
        this.compression = compression;
    }

    public SQLOverflowStoreInClause getOverflowStoreInClause() {
        return overflowStoreInClause;
    }

    public void setOverflowStoreInClause(SQLOverflowStoreInClause overflowStoreInClause) {
        this.overflowStoreInClause = overflowStoreInClause;
    }
}
