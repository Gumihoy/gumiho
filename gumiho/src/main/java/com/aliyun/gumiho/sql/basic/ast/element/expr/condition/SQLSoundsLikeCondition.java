package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr SOUNDS LIKE pat
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLSoundsLikeCondition extends AbstractSQLExpr {

    protected SQLExpr expr;

    protected SQLExpr pattern;

    public SQLSoundsLikeCondition() {
    }

    public SQLSoundsLikeCondition(SQLExpr expr, SQLExpr pattern) {
        setExpr(expr);
        setPattern(pattern);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, pattern);
        }
    }


    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLExpr getPattern() {
        return pattern;
    }

    public void setPattern(SQLExpr pattern) {
        setChildParent(pattern);
        this.pattern = pattern;
    }

}
