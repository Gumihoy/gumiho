package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr RLIKE pat
 * expr NOT RLIKE pat
 * https://dev.mysql.com/doc/refman/8.0/en/regexp.html
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLRlikeCondition extends AbstractSQLExpr {

    protected SQLExpr expr;

    protected boolean not;

    protected SQLExpr pattern;

    public SQLRlikeCondition() {
    }

    public SQLRlikeCondition(SQLExpr expr, SQLExpr pattern) {
        setExpr(expr);
        setPattern(pattern);
    }

    public SQLRlikeCondition(SQLExpr expr, boolean not, SQLExpr pattern) {
        setExpr(expr);
        setPattern(pattern);
        this.not = not;
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

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public SQLExpr getPattern() {
        return pattern;
    }

    public void setPattern(SQLExpr pattern) {
        setChildParent(pattern);
        this.pattern = pattern;
    }

}
