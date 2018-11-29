package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * RENAME TO newName
 * <p>
 * https://www.postgresql.org/docs/current/static/sql-createsequence.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TRIGGER-statement.html#GUID-BC319647-2D94-46D1-BF69-16CDFB507725
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLRenameToClause extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {

    protected SQLExpr newName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLRenameToClause clone() {
        SQLRenameToClause x = new SQLRenameToClause();

        SQLExpr newNameClone = this.newName.clone();
        x.setNewName(newNameClone);

        return x;
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
