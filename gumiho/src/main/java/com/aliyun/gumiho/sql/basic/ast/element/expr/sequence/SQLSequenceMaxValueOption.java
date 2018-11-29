package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20maxvalue%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceMaxValueOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {

    protected SQLIntegerLiteral maxValue;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, maxValue);
        }
    }

    @Override
    public SQLSequenceMaxValueOption clone() {
        SQLSequenceMaxValueOption x = new SQLSequenceMaxValueOption();

        SQLIntegerLiteral cloneMaxValue = this.maxValue.clone();
        x.setMaxValue(cloneMaxValue);
        return x;
    }

    public SQLIntegerLiteral getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(SQLIntegerLiteral maxValue) {
        this.maxValue = maxValue;
    }
}
