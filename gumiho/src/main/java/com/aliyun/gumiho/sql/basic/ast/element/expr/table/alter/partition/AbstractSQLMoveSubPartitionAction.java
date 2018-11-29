package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPartitioningStorageClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLFilterCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLAllowDisallowClusteringType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIndexingOnType;

/**
 * MOVE <SUBPARTITION nameIdentifier | SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN>
 * indexingClause? partitioningStorageClause? updateIndexClause? filterCondition? parallelClause? allowDisallowClustering? ONLINE?
 * <p>
 * move_table_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLMoveSubPartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected SQLIndexingOnType indexing;
    protected ISQLPartitioningStorageClause partitioningStorage;
    protected ISQLUpdateIndexClause updateIndex;
    protected SQLFilterCondition filterCondition;
    protected ISQLParallelClause parallel;
    protected SQLAllowDisallowClusteringType allowDisallowClustering;
    protected boolean online;

    @Override
    public AbstractSQLMoveSubPartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLMoveSubPartitionAction x) {
        super.cloneTo(x);
    }


    public SQLIndexingOnType getIndexing() {
        return indexing;
    }

    public void setIndexing(SQLIndexingOnType indexing) {
        this.indexing = indexing;
    }

    public ISQLPartitioningStorageClause getPartitioningStorage() {
        return partitioningStorage;
    }

    public void setPartitioningStorage(ISQLPartitioningStorageClause partitioningStorage) {
        this.partitioningStorage = partitioningStorage;
    }

    public ISQLUpdateIndexClause getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(ISQLUpdateIndexClause updateIndex) {
        this.updateIndex = updateIndex;
    }

    public SQLFilterCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(SQLFilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    public ISQLParallelClause getParallel() {
        return parallel;
    }

    public void setParallel(ISQLParallelClause parallel) {
        this.parallel = parallel;
    }

    public SQLAllowDisallowClusteringType getAllowDisallowClustering() {
        return allowDisallowClustering;
    }

    public void setAllowDisallowClustering(SQLAllowDisallowClusteringType allowDisallowClustering) {
        this.allowDisallowClustering = allowDisallowClustering;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
