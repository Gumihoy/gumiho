package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.ISQLPartitionBy;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.ISQLSubPartitionBy;

import java.util.ArrayList;
import java.util.List;

/**
 * PARTITIONSET BY RANGE (column [, column]...)
 * PARTITION BY CONSISTENT HASH (column [, column]...)
 * [ SUBPARTITION BY { { RANGE | HASH } (column [, column]...)
 * | LIST (column)
 * }
 * [ subpartition_template ]
 * ]
 * PARTITIONS AUTO ( range_partitionset_desc [, range_partitionset_desc]... )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public abstract class AbstractSQLPartitionsetBy extends AbstractSQLExpr implements ISQLPartitionsetBy {

    protected final List<SQLExpr> columns = new ArrayList<>();

    protected ISQLPartitionBy partitionBy;

    protected ISQLSubPartitionBy subPartitionBy;

    protected final List<SQLPartitionsetDefinition> partitionsets = new ArrayList<>();

    @Override
    public AbstractSQLPartitionsetBy clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLPartitionsetBy x) {
        super.cloneTo(x);

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        if (this.partitionBy != null) {
            ISQLPartitionBy partitionByClone =this.partitionBy.clone() ;
            x.setPartitionBy(partitionByClone);
        }

        if (this.subPartitionBy != null) {
            ISQLSubPartitionBy subPartitionByClone =this.subPartitionBy.clone() ;
            x.setSubPartitionBy(subPartitionByClone);
        }

        for (SQLPartitionsetDefinition partitionset : partitionsets) {
            SQLPartitionsetDefinition partitionsetClone = partitionset.clone();
            x.addPartitionset(partitionsetClone);
        }
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

    public ISQLPartitionBy getPartitionBy() {
        return partitionBy;
    }

    public void setPartitionBy(ISQLPartitionBy partitionBy) {
        setChildParent(partitionBy);
        this.partitionBy = partitionBy;
    }

    public ISQLSubPartitionBy getSubPartitionBy() {
        return subPartitionBy;
    }

    public void setSubPartitionBy(ISQLSubPartitionBy subPartitionBy) {
        setChildParent(subPartitionBy);
        this.subPartitionBy = subPartitionBy;
    }

    public List<SQLPartitionsetDefinition> getPartitionsets() {
        return partitionsets;
    }

    public void addPartitionset(SQLPartitionsetDefinition partitionset) {
        if (partitionset == null) {
            return;
        }
        setChildParent(partitionset);
        this.partitionsets.add(partitionset);
    }
}
