package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * boolean_primary IS [NOT] {TRUE | FALSE | UNKNOWN}
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLIsBooleanLiteralCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;
    protected boolean not;
    protected SQLValue value;

    public SQLIsBooleanLiteralCondition(SQLExpr expr, SQLValue value) {
        setExpr(expr);
        setValue(value);
    }

    public SQLIsBooleanLiteralCondition(SQLExpr expr, boolean not, SQLValue value) {
        setExpr(expr);
        setValue(value);
        this.not = not;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLIsBooleanLiteralCondition clone() {
        SQLExpr exprClone = this.expr.clone();
        return new SQLIsBooleanLiteralCondition(exprClone, not, value);
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

    public SQLValue getValue() {
        return value;
    }

    public void setValue(SQLValue value) {
        this.value = value;
    }

    public enum SQLValue implements ISQLEnum {
        TRUE(SQLReserved.TRUE),
        FALSE(SQLReserved.FAST),
        UNKNOWN(SQLReserved.UNKNOWN),;

        public final SQLReserved name;

        SQLValue(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
