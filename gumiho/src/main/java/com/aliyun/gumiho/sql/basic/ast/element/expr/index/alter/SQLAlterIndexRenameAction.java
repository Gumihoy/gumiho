package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME TO newname
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLAlterIndexRenameAction extends AbstractSQLExpr implements ISQLAlterIndexAction {

    protected SQLName newName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLAlterIndexRenameAction clone() {
        return new SQLAlterIndexRenameAction();
    }

    public SQLName getNewName() {
        return newName;
    }

    public void setNewName(SQLName newName) {
        setChildParent(newName);
        this.newName = newName;
    }
}
