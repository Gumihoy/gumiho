package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#select%20target%20list
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public class SQLSelectTargetItem extends AbstractSQLExpr {

    protected SQLExpr expr;

    public SQLSelectTargetItem(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLSelectTargetItem clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLSelectTargetItem x = new SQLSelectTargetItem(exprClone);
        return x;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
