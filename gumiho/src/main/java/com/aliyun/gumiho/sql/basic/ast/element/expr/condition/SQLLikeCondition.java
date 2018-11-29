package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLLikeOperator;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * char1 [ NOT ] { LIKE | LIKEC | LIKE2 | LIKE4 } char2 [ ESCAPE esc_char ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#like%20predicate
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pattern-matching-Conditions.html#GUID-3FA7F5AB-AC64-4200-8F90-294101428C26
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/string-comparison-functions.html#operator_like
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLLikeCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    protected SQLLikeOperator operator = SQLLikeOperator.LIKE;

    protected SQLExpr pattern;

    protected SQLExpr escape;

    public SQLLikeCondition() {
    }

    public SQLLikeCondition(SQLExpr expr, SQLExpr pattern) {
        setExpr(expr);
        setPattern(pattern);
    }

    public SQLLikeCondition(SQLExpr expr, SQLLikeOperator operator, SQLExpr pattern) {
        this.operator = operator;
        setExpr(expr);
        setPattern(pattern);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, pattern);
            this.acceptChild(visitor, escape);
        }
    }


    @Override
    public SQLLikeCondition clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLExpr patternClone = this.pattern.clone();

        SQLLikeCondition x = new SQLLikeCondition(exprClone, patternClone);

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLLikeCondition x) {
        super.cloneTo(x);

        x.not = this.not;

        if (this.escape != null) {
            SQLExpr escapeClone = this.escape.clone();
            x.setEscape(escapeClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == pattern) {
            setPattern(target);
            return true;
        }

        if (source == escape) {
            setEscape(target);
            return true;
        }
        return false;
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

    public SQLLikeOperator getOperator() {
        return operator;
    }

    public void setOperator(SQLLikeOperator operator) {
        this.operator = operator;
    }

    public SQLExpr getPattern() {
        return pattern;
    }

    public void setPattern(SQLExpr pattern) {
        setChildParent(pattern);
        this.pattern = pattern;
    }

    public SQLExpr getEscape() {
        return escape;
    }

    public void setEscape(SQLExpr escape) {
        setChildParent(escape);
        this.escape = escape;
    }
}
