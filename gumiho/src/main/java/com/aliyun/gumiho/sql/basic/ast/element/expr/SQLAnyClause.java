package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * ANY expr
 * expr: (expr, expr...)
 * expr: (subQuery)
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Comparison-Conditions.html#GUID-72CA75A4-AE94-471E-993F-20B969DB933F
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLAnyClause extends AbstractSQLExpr {

    protected SQLExpr expr;

    public SQLAnyClause(SQLExpr expr) {
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
