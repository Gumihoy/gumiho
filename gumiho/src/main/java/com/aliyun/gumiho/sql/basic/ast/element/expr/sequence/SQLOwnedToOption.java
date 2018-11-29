package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * https://www.postgresql.org/docs/current/static/sql-createsequence.html
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLOwnedToOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {

    protected SQLExpr newName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLOwnedToOption clone() {
        SQLOwnedToOption x = new SQLOwnedToOption();

        SQLExpr newNameClone = this.newName.clone();
        x.setNewName(newNameClone);

        return x;
    }


    public SQLExpr getNewName() {
        return newName;
    }

    public void setNewName(SQLExpr newName) {
        setChildParent(newName);
        this.newName = newName;
    }
}
