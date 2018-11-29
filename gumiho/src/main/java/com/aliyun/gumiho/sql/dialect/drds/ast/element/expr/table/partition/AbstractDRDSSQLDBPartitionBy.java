package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.AbstractDRDSSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * DBPARTITION BY HASH([column])
 * [
 * TBPARTITION BY { HASH(column) | {MM|DD|WEEK|MMDD}(column)}
 * [TBPARTITIONS num]
 * ]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public abstract class AbstractDRDSSQLDBPartitionBy extends AbstractDRDSSQLExpr implements IDRDSSQLDBPartitionBy {

    protected final List<SQLExpr> columns = new ArrayList<>();

    protected IDRDSSQLTBPartitionBy tbPartitionBy;

    @Override
    public AbstractDRDSSQLDBPartitionBy clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(AbstractDRDSSQLDBPartitionBy x) {
        super.cloneTo(x);

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        if (this.tbPartitionBy != null) {
            IDRDSSQLTBPartitionBy tbPartitionByClone = this.tbPartitionBy.clone();
            x.setTbPartitionBy(tbPartitionByClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(columns, source, target, this);
        if (replace) {
            return true;
        }
        return false;
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

    @Override
    public IDRDSSQLTBPartitionBy getTbPartitionBy() {
        return tbPartitionBy;
    }

    @Override
    public void setTbPartitionBy(IDRDSSQLTBPartitionBy tbPartitionBy) {
        setChildParent(tbPartitionBy);
        this.tbPartitionBy = tbPartitionBy;
    }
}
