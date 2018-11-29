package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column.SQLAlterTableAlterColumnAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME CONSTRAINT constraint_name TO new_constraint_name
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 *
 * RENAME CONSTRAINT old_name TO new_name
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableRenameTableConstraintAction extends AbstractSQLExpr implements ISQLAlterTableAction {

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
    public SQLAlterTableAlterColumnAction clone() {
        return null;
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
