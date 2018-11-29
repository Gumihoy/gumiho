package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME PARTITION name TO new_name
 * <p>
 * rename_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableRenamePartitionAction extends AbstractSQLAlterTableRenamePartitionAction {

    protected SQLExpr name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLAlterTableRenamePartitionAction clone() {
        SQLAlterTableRenamePartitionAction x = new SQLAlterTableRenamePartitionAction();
        this.cloneTo(x);
        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = super.replace(source, target);
        if (replace) {
            return true;
        }

        if (source == name) {
            setName(target);
            return true;
        }

        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
