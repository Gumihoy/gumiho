package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr as EVALNAME expr
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLXmlEvalNameExprArgument extends AbstractSQLExpr {

    protected SQLExpr value;

    protected SQLExpr alias;

    public SQLXmlEvalNameExprArgument(SQLExpr value, SQLExpr alias) {
        setValue(value);
        setAlias(alias);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
            this.acceptChild(visitor, alias);
        }
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        this.value = value;
    }

    public SQLExpr getAlias() {
        return alias;
    }

    public void setAlias(SQLExpr alias) {
        this.alias = alias;
    }
}
