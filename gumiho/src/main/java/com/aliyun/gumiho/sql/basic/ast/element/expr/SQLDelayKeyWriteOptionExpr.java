package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * DELAY_KEY_WRITE [=] 'string'
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLDelayKeyWriteOptionExpr extends SQLSetOptionExpr {


    public SQLDelayKeyWriteOptionExpr() {
        super(SQLReserved.DELAY_KEY_WRITE.ofExpr());
    }

    public SQLDelayKeyWriteOptionExpr(SQLExpr value) {
        super(SQLReserved.DELAY_KEY_WRITE.ofExpr(), value);
    }

    @Override
    public SQLDelayKeyWriteOptionExpr clone() {
        SQLDelayKeyWriteOptionExpr x = new SQLDelayKeyWriteOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
