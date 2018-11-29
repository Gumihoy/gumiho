package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME PARTITION partition TO new_name
 * <p>
 * rename_index_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexRenamePartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr name;
    protected SQLExpr newName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLAlterIndexRenamePartitionAction clone() {
        SQLAlterIndexRenamePartitionAction x = new SQLAlterIndexRenamePartitionAction();

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        SQLExpr newNameClone = this.newName.clone();
        x.setNewName(newNameClone);

        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }

        if (source == newName) {
            setNewName(newName);
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

    public SQLExpr getNewName() {
        return newName;
    }

    public void setNewName(SQLExpr newName) {
        setChildParent(newName);
        this.newName = newName;
    }
}
