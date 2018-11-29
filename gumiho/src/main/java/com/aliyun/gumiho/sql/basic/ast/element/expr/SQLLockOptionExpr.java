package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * LOCK [=] {DEFAULT | NONE | SHARED | EXCLUSIVE}
 * https://dev.mysql.com/doc/refman/8.0/en/create-index.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLLockOptionExpr extends SQLSetOptionExpr {

    public SQLLockOptionExpr() {
    }

    public SQLLockOptionExpr(SQLExpr value) {
        super(SQLReserved.LOCK.ofExpr(), value);
    }

    @Override
    public SQLLockOptionExpr clone() {
        SQLLockOptionExpr x = new SQLLockOptionExpr();
        this.cloneTo(x);
        return x;
    }
}
