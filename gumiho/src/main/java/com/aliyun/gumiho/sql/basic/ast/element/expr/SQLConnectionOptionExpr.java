package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * CONNECTION [=] 'string'
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLConnectionOptionExpr extends SQLSetOptionExpr {


    public SQLConnectionOptionExpr() {
        super(SQLReserved.CONNECTION.ofExpr());
    }

    public SQLConnectionOptionExpr(SQLExpr value) {
        super(SQLReserved.CONNECTION.ofExpr(), value);
    }

    @Override
    public SQLConnectionOptionExpr clone() {
        SQLConnectionOptionExpr x = new SQLConnectionOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
