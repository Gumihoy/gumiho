package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * INSERT_METHOD [=] 'string'
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLInsertMethodOptionExpr extends SQLSetOptionExpr{


    public SQLInsertMethodOptionExpr() {
        super(SQLReserved.INSERT_METHOD.ofExpr());
    }

    public SQLInsertMethodOptionExpr(SQLExpr value) {
        super(SQLReserved.INSERT_METHOD.ofExpr(), value);
    }

    @Override
    public SQLInsertMethodOptionExpr clone() {
        SQLInsertMethodOptionExpr x = new SQLInsertMethodOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
