package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * rename_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public abstract class AbstractSQLAlterTableRenamePartitionAction extends AbstractSQLExpr implements ISQLAlterTableRenamePartitionAction {

    protected SQLExpr newName;

    @Override
    public AbstractSQLAlterTableRenamePartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == newName) {
            setNewName(target);
            return true;
        }
        return false;
    }

    public SQLExpr getNewName() {
        return newName;
    }

    public void setNewName(SQLExpr newName) {
        setChildParent(newName);
        this.newName = newName;
    }
}
