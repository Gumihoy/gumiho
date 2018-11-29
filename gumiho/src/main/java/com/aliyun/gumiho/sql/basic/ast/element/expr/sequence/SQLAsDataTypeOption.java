package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20data%20type%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLAsDataTypeOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {

    protected SQLDataType dataType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, dataType);
        }
    }

    @Override
    public SQLAsDataTypeOption clone() {
        SQLAsDataTypeOption x = new SQLAsDataTypeOption();
        SQLDataType cloneDataType = this.dataType.clone();
        x.setDataType(cloneDataType);

        return x;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        this.dataType = dataType;
    }
}
