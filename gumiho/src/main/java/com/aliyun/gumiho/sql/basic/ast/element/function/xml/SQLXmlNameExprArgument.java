package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * name expr
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLXmlNameExprArgument extends AbstractSQLExpr {

    protected SQLExpr expr;

    public SQLXmlNameExprArgument(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
