package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * https://www.postgresql.org/docs/current/static/sql-createsequence.html
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLNoneOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNoneOption clone() {
        return new SQLNoneOption();
    }
}
