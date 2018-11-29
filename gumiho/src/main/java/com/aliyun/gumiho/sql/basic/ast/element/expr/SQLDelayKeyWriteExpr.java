package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *  DELAY_KEY_WRITE [=] value
 *
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLDelayKeyWriteExpr extends SQLSetOptionExpr {

    public SQLDelayKeyWriteExpr() {
    }

    public SQLDelayKeyWriteExpr(SQLExpr value) {
        super(SQLReserved.DELAY_KEY_WRITE.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLDelayKeyWriteExpr clone() {
        SQLDelayKeyWriteExpr x = new SQLDelayKeyWriteExpr();
        this.cloneTo(x);
        return x;
    }
}
