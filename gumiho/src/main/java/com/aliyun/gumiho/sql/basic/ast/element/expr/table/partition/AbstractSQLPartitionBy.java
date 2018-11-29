package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLStoreInClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.ISQLSubPartitionBy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://dev.mysql.com/doc/refman/8.0/en/create-table.html
 * <p>
 * PARTITION BY
 * { [LINEAR] HASH(expr)
 * | [LINEAR] KEY [ALGORITHM={1|2}] (column_list)
 * | RANGE{(expr) | COLUMNS(column_list)}
 * | LIST{(expr) | COLUMNS(column_list)} }
 * [PARTITIONS num]
 * [SUBPARTITION BY
 * { [LINEAR] HASH(expr)
 * | [LINEAR] KEY [ALGORITHM={1|2}] (column_list) }
 * [SUBPARTITIONS num]
 * ]
 * [(partition_definition [, partition_definition] ...)]
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public abstract class AbstractSQLPartitionBy extends AbstractSQLExpr implements ISQLPartitionBy {

    protected boolean linear = false;

    protected final List<SQLExpr> columns = new ArrayList<>();


    protected SQLExpr partitionsNum;

    protected SQLStoreInClause storeInClause;


    protected ISQLSubPartitionBy subPartitionBy;

    protected final List<SQLPartitionDefinition> partitions = new ArrayList<>();


    @Override
    public AbstractSQLPartitionBy clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLPartitionBy x) {
        super.cloneTo(x);

        x.linear = this.linear;

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(columns, source, target, this);
        if (replace) {
            return true;
        }

        if (source == partitionsNum) {
            setPartitionsNum(target);
            return true;
        }
        return false;
    }

    public boolean isLinear() {
        return linear;
    }

    public void setLinear(boolean linear) {
        this.linear = linear;
    }

    public List<SQLExpr> getColumns() {
        return columns;
    }

    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }


    public SQLStoreInClause getStoreInClause() {
        return storeInClause;
    }

    public void setStoreInClause(SQLStoreInClause storeInClause) {
        setChildParent(storeInClause);
        this.storeInClause = storeInClause;
    }

    public SQLExpr getPartitionsNum() {
        return partitionsNum;
    }

    public void setPartitionsNum(SQLExpr partitionsNum) {
        setChildParent(partitionsNum);
        this.partitionsNum = partitionsNum;
    }

    public ISQLSubPartitionBy getSubPartitionBy() {
        return subPartitionBy;
    }

    public void setSubPartitionBy(ISQLSubPartitionBy subPartitionBy) {
        setChildParent(subPartitionBy);
        this.subPartitionBy = subPartitionBy;
    }

    public List<SQLPartitionDefinition> getPartitions() {
        return partitions;
    }

    public void addPartition(SQLPartitionDefinition partition) {
        if (partition == null) {
            return;
        }
        setChildParent(partition);
        this.partitions.add(partition);
    }
}
