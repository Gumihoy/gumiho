package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20minvalue%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceMinValueOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {

    protected SQLIntegerLiteral minValue;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, minValue);
        }
    }

    @Override
    public SQLSequenceMinValueOption clone() {
        SQLSequenceMinValueOption x = new SQLSequenceMinValueOption();

        SQLIntegerLiteral cloneMaxValue = this.minValue.clone();
        x.setMinValue(cloneMaxValue);
        return x;
    }

    public SQLIntegerLiteral getMinValue() {
        return minValue;
    }

    public void setMinValue(SQLIntegerLiteral minValue) {
        this.minValue = minValue;
    }
}
