package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLFilterCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLDependentTablesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLAllowDisallowClusteringType;

import java.util.ArrayList;
import java.util.List;

/**
 * MERGE SUBPARTITIONS
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLAlterTableMergeSubPartitionsAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected SQLSubPartitionDefinition subPartition;
    protected SQLFilterCondition filterCondition;
    protected SQLDependentTablesClause dependentTables;
    protected ISQLUpdateIndexClause updateIndex;
    protected ISQLParallelClause parallel;
    protected boolean online;
    protected SQLAllowDisallowClusteringType allowDisallowClustering;


    @Override
    public AbstractSQLAlterTableMergeSubPartitionsAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableMergeSubPartitionsAction x) {
        super.cloneTo(x);

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return false;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLSubPartitionDefinition getSubPartition() {
        return subPartition;
    }

    public void setSubPartition(SQLSubPartitionDefinition subPartition) {
        setChildParent(subPartition);
        this.subPartition = subPartition;
    }

    public SQLFilterCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(SQLFilterCondition filterCondition) {
        setChildParent(filterCondition);
        this.filterCondition = filterCondition;
    }

    public SQLDependentTablesClause getDependentTables() {
        return dependentTables;
    }

    public void setDependentTables(SQLDependentTablesClause dependentTables) {
        setChildParent(dependentTables);
        this.dependentTables = dependentTables;
    }

    public ISQLUpdateIndexClause getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(ISQLUpdateIndexClause updateIndex) {
        setChildParent(updateIndex);
        this.updateIndex = updateIndex;
    }

    public ISQLParallelClause getParallel() {
        return parallel;
    }

    public void setParallel(ISQLParallelClause parallel) {
        setChildParent(parallel);
        this.parallel = parallel;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public SQLAllowDisallowClusteringType getAllowDisallowClustering() {
        return allowDisallowClustering;
    }

    public void setAllowDisallowClustering(SQLAllowDisallowClusteringType allowDisallowClustering) {
        this.allowDisallowClustering = allowDisallowClustering;
    }
}
