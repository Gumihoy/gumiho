package com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [NOT] DEFERRABLE
 * https://www.postgresql.org/docs/10/static/sql-set-transaction.html
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLSetTransactionDeferrableOption extends AbstractSQLExpr implements SQLSetTransactionOption {

    protected boolean not;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLSetTransactionDeferrableOption clone() {
        SQLSetTransactionDeferrableOption x = new SQLSetTransactionDeferrableOption();
        x.not = this.not;
        return x;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }
}
