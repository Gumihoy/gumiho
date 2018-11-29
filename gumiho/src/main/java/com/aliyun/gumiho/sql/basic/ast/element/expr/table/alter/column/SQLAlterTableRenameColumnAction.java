package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME COLUMN old_col_name TO new_col_name
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 * <p>
 * RENAME [ COLUMN ] column_name TO new_column_name
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 * <p>
 * <p>
 * RENAME COLUMN old_name TO new_name
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableRenameColumnAction extends AbstractSQLExpr implements ISQLAlterTableColumnAction {

    protected boolean column = true;
    protected SQLName name;
    protected SQLName newName;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLAlterTableRenameColumnAction clone() {
        SQLAlterTableRenameColumnAction x = new SQLAlterTableRenameColumnAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableRenameColumnAction x) {
        super.cloneTo(x);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == newName
                && target instanceof SQLName) {
            this.setNewName((SQLName) target);
            return true;
        }
        return false;
    }


    public boolean isColumn() {
        return column;
    }

    public void setColumn(boolean column) {
        this.column = column;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLName getNewName() {
        return newName;
    }

    public void setNewName(SQLName newName) {
        setChildParent(newName);
        this.newName = newName;
    }
}
