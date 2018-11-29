package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20start%20with%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceStartWithOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {

    protected SQLIntegerLiteral startWith;

    protected boolean with = true;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, startWith);
        }
    }

    @Override
    public SQLSequenceStartWithOption clone() {

        SQLSequenceStartWithOption x = new SQLSequenceStartWithOption();
        SQLIntegerLiteral startWithClone = this.startWith.clone();
        x.setStartWith(startWithClone);

        x.setWith(this.with);

        return x;
    }

    public SQLIntegerLiteral getStartWith() {
        return startWith;
    }

    public void setStartWith(SQLIntegerLiteral startWith) {
        setChildParent(startWith);
        this.startWith = startWith;
    }

    public boolean isWith() {
        return with;
    }

    public void setWith(boolean with) {
        this.with = with;
    }
}
