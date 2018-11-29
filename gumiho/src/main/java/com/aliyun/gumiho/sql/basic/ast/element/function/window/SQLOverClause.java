package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.SQLReplaceable;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OVER (analytic_clause)
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/window-functions-usage.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html
 *
 * @author kongtong.ouyang on 2018/4/24.
 */
public class SQLOverClause extends AbstractSQLExpr implements ISQLOverClause, SQLReplaceable {

    protected SQLWindowSpecification expr;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLOverClause clone() {
        SQLOverClause x = new SQLOverClause();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLOverClause x) {
        super.cloneTo(x);

        if (this.expr != null) {
            SQLWindowSpecification exprClone = this.expr.clone();
            x.setExpr(exprClone);
        }
    }

    public SQLWindowSpecification getExpr() {
        return expr;
    }

    public void setExpr(SQLWindowSpecification expr) {
        setChildParent(expr);
        this.expr = expr;
    }

}
