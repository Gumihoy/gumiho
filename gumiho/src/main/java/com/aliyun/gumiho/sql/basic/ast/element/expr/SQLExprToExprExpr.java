package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr TO expr
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLExprToExprExpr extends AbstractSQLExpr {

    protected SQLExpr expr;
    protected SQLExpr toExpr;

    public SQLExprToExprExpr(SQLExpr expr, SQLExpr toExpr) {
        setExpr(expr);
        setToExpr(toExpr);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, toExpr);
        }
    }

    @Override
    public SQLExprToExprExpr clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLExpr toExprClone = this.toExpr.clone();

        return new SQLExprToExprExpr(exprClone, toExprClone);
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLExpr getToExpr() {
        return toExpr;
    }

    public void setToExpr(SQLExpr toExpr) {
        setChildParent(toExpr);
        this.toExpr = toExpr;
    }
}
