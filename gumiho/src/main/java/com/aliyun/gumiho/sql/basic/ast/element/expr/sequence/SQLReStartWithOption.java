package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20start%20with%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLReStartWithOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption{

    protected SQLIntegerLiteral restartWith;

    protected boolean with = true;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, restartWith);
        }
    }

    @Override
    public SQLReStartWithOption clone() {
        SQLReStartWithOption x = new SQLReStartWithOption();

        SQLIntegerLiteral restartWithClone = this.restartWith.clone();
        x.setRestartWith(restartWithClone);

        x.setWith(this.with);

        return x;
    }

    public SQLIntegerLiteral getRestartWith() {
        return restartWith;
    }

    public void setRestartWith(SQLIntegerLiteral restartWith) {
        this.restartWith = restartWith;
    }

    public boolean isWith() {
        return with;
    }

    public void setWith(boolean with) {
        this.with = with;
    }
}
