package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLStoreInClause;

import java.util.ArrayList;
import java.util.List;

/**
 * [SUBPARTITION BY
 * { [LINEAR] HASH(expr)
 * | [LINEAR] KEY [ALGORITHM={1|2}] (column_list) }
 * [SUBPARTITIONS num]
 * ]
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public abstract class AbstractSQLSubPartitionBy extends AbstractSQLExpr implements ISQLSubPartitionBy {

    protected boolean linear;
    protected final List<SQLExpr> columns = new ArrayList<>();

    protected SQLExpr subpartitionsNum;
    protected SQLStoreInClause storeInClause;

    protected SQLSubpartitionTemplate subpartitionTemplate;

    @Override
    public AbstractSQLSubPartitionBy clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLSubPartitionBy x) {
        super.cloneTo(x);

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

        if (source == subpartitionsNum) {
            setSubpartitionsNum(target);
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

    public SQLExpr getSubpartitionsNum() {
        return subpartitionsNum;
    }

    public void setSubpartitionsNum(SQLExpr subpartitionsNum) {
        setChildParent(subpartitionsNum);
        this.subpartitionsNum = subpartitionsNum;
    }

    public SQLStoreInClause getStoreInClause() {
        return storeInClause;
    }

    public void setStoreInClause(SQLStoreInClause storeInClause) {
        setChildParent(storeInClause);
        this.storeInClause = storeInClause;
    }

    public SQLSubpartitionTemplate getSubpartitionTemplate() {
        return subpartitionTemplate;
    }

    public void setSubpartitionTemplate(SQLSubpartitionTemplate subpartitionTemplate) {
        setChildParent(subpartitionTemplate);
        this.subpartitionTemplate = subpartitionTemplate;
    }
}
