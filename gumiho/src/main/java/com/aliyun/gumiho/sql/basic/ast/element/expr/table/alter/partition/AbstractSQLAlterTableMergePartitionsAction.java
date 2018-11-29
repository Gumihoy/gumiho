package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLFilterCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLDependentTablesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLUpdateIndexesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.SQExceptionsClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLAllowDisallowClusteringType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIncludingType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLWithType;

import java.util.ArrayList;
import java.util.List;

/**
 * MERGE PARTITIONS
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLAlterTableMergePartitionsAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected SQLPartitionDefinition partition;
    protected SQLFilterCondition filterCondition;
    protected SQLDependentTablesClause dependentTables;
    protected ISQLUpdateIndexClause updateIndex;
    protected ISQLParallelClause parallel;
    protected boolean online;
    protected SQLAllowDisallowClusteringType allowDisallowClustering;


    @Override
    public AbstractSQLAlterTableMergePartitionsAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableMergePartitionsAction x) {
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

    public SQLPartitionDefinition getPartition() {
        return partition;
    }

    public void setPartition(SQLPartitionDefinition partition) {
        this.partition = partition;
    }

    public SQLFilterCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(SQLFilterCondition filterCondition) {
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
