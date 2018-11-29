package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLOverflowStoreInClause;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLCompression;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * <p>
 * PARTITION BY HASH (column [, column ] ...)
 * { subpartition_by_range
 * | subpartition_by_list
 * | subpartition_by_hash
 * }
 * { individual_hash_partitions
 * | hash_partitions_by_quantity
 * }
 * hash_partitions_by_quantity :
 * PARTITIONS hash_partition_quantity
 * [ STORE IN (tablespace [, tablespace ]...) ]
 * [ table_compression | index_compression ]
 * [ OVERFLOW STORE IN (tablespace [, tablespace ]...) ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLPartitionByHash extends AbstractSQLPartitionBy {

    protected ISQLCompression compression;

    protected SQLOverflowStoreInClause overflowStoreInClause;

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
    public SQLPartitionByHash clone() {
        SQLPartitionByHash x = new SQLPartitionByHash();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionByHash x) {
        super.cloneTo(x);

        if (this.compression != null) {
            ISQLCompression compressionClone = this.compression.clone();
            x.setCompression(compressionClone);
        }

        if (this.overflowStoreInClause != null) {
            SQLOverflowStoreInClause overflowStoreInClauseClone = this.overflowStoreInClause.clone();
            x.setOverflowStoreInClause(overflowStoreInClauseClone);
        }
    }

    public ISQLCompression getCompression() {
        return compression;
    }

    public void setCompression(ISQLCompression compression) {
        setChildParent(compression);
        this.compression = compression;
    }

    public SQLOverflowStoreInClause getOverflowStoreInClause() {
        return overflowStoreInClause;
    }

    public void setOverflowStoreInClause(SQLOverflowStoreInClause overflowStoreInClause) {
        setChildParent(overflowStoreInClause);
        this.overflowStoreInClause = overflowStoreInClause;
    }
}
