package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.AbstractDRDSSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * TBPARTITION BY { HASH(column) | {MM|DD|WEEK|MMDD}(column)}
 * [TBPARTITIONS num]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public abstract class AbstractDRDSSQLTBPartitionBy extends AbstractDRDSSQLExpr implements IDRDSSQLTBPartitionBy {

    protected final List<SQLExpr> columns = new ArrayList<>();

    protected SQLExpr tbPartitionsNum;

    @Override
    public AbstractDRDSSQLTBPartitionBy clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(AbstractDRDSSQLTBPartitionBy x) {
        super.cloneTo(x);

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        if (this.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNumClone = this.tbPartitionsNum.clone();
            x.setTbPartitionsNum(tbPartitionsNumClone);
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

    @Override
    public List<SQLExpr> getColumns() {
        return columns;
    }

    @Override
    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

    @Override
    public void addAllColumn(List<SQLExpr> columns) {
        if (columns == null
                || columns.size() == 0) {
            return;
        }

        for (int i = columns.size() - 1; i >= 0; i--) {
            SQLExpr column = columns.get(i);
            if (column == null) {
                columns.remove(i);
            }
            setChildParent(column);
        }

        this.columns.addAll(columns);
    }

    @Override
    public SQLExpr getTbPartitionsNum() {
        return tbPartitionsNum;
    }

    @Override
    public void setTbPartitionsNum(SQLExpr tbPartitionsNum) {
        setChildParent(tbPartitionsNum);
        this.tbPartitionsNum = tbPartitionsNum;
    }
}
