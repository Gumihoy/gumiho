package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20increment%20by%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceIncrementByOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {

    protected SQLIntegerLiteral incrementBy;

    protected boolean by = true;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, incrementBy);
        }
    }

    @Override
    public SQLSequenceIncrementByOption clone() {

        SQLSequenceIncrementByOption x = new SQLSequenceIncrementByOption();
        SQLIntegerLiteral cloneIncrementBy = this.incrementBy.clone();

        x.setIncrementBy(cloneIncrementBy);

        x.setBy(this.by);

        return x;
    }


    public SQLIntegerLiteral getIncrementBy() {
        return incrementBy;
    }

    public void setIncrementBy(SQLIntegerLiteral incrementBy) {
        if (incrementBy != null) {
            incrementBy.setParent(this);
        }
        this.incrementBy = incrementBy;
    }

    public boolean isBy() {
        return by;
    }

    public void setBy(boolean by) {
        this.by = by;
    }
}
