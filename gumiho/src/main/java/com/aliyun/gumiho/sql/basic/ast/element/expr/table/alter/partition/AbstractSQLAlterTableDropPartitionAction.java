package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLPartitionType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP PARTITION
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLAlterTableDropPartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected SQLPartitionType type = SQLPartitionType.PARTITION;
    protected final List<SQLExpr> items = new ArrayList<>();
    protected ISQLUpdateIndexClause updateIndex;
    protected ISQLParallelClause parallel;

    @Override
    public AbstractSQLAlterTableDropPartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableDropPartitionAction x) {
        super.cloneTo(x);

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return false;
    }


    public SQLPartitionType getType() {
        return type;
    }

    public void setType(SQLPartitionType type) {
        this.type = type;
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

}
