package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *  CONNECTION [=] value
 *
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLConnectionExpr extends SQLSetOptionExpr {

    public SQLConnectionExpr() {
    }

    public SQLConnectionExpr(SQLExpr value) {
        super(SQLReserved.CONNECTION.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLConnectionExpr clone() {
        SQLConnectionExpr x = new SQLConnectionExpr();
        this.cloneTo(x);
        return x;
    }
}
