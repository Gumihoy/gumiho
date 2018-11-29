package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr [NOT] REGEXP pat
 * https://dev.mysql.com/doc/refman/8.0/en/regexp.html
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLRegexpCondition extends AbstractSQLExpr {

    protected SQLExpr expr;

    protected boolean not;

    protected SQLExpr pattern;

    public SQLRegexpCondition() {
    }

    public SQLRegexpCondition(SQLExpr expr, SQLExpr pattern) {
        setExpr(expr);
        setPattern(pattern);
    }

    public SQLRegexpCondition(SQLExpr expr, boolean not, SQLExpr pattern) {
        this.not = not;
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
        setExpr(expr);
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
        setExpr(pattern);
        this.pattern = pattern;
    }

}
