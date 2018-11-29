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
public class SQLSetSchemaOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {

    protected SQLExpr setSchema;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, setSchema);
        }
    }

    @Override
    public SQLSetSchemaOption clone() {
        SQLSetSchemaOption x = new SQLSetSchemaOption();
        SQLExpr setSchemaClone = this.setSchema.clone();
        x.setSetSchema(setSchemaClone);
        return x;
    }


    public SQLExpr getSetSchema() {
        return setSchema;
    }

    public void setSetSchema(SQLExpr setSchema) {
        this.setSchema = setSchema;
    }
}
