package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * lower .. upper
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class SQLBoundsClause extends AbstractSQLExpr implements ISQLBoundsClause {

    protected SQLExpr lower;
    protected SQLExpr upper;

    public SQLBoundsClause() {
    }

    public SQLBoundsClause(SQLExpr lower, SQLExpr upper) {
        setLower(lower);
        setUpper(upper);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, lower);
            this.acceptChild(visitor, upper);
        }
    }

    @Override
    public SQLBoundsClause clone() {
        SQLBoundsClause x = new SQLBoundsClause();
        return x;
    }

    public SQLExpr getLower() {
        return lower;
    }

    public void setLower(SQLExpr lower) {
        setChildParent(lower);
        this.lower = lower;
    }

    public SQLExpr getUpper() {
        return upper;
    }

    public void setUpper(SQLExpr upper) {
        setChildParent(upper);
        this.upper = upper;
    }
}
