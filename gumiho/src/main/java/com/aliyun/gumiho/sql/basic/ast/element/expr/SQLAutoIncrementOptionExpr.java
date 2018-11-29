package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * AUTO_INCREMENT [=] value
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLAutoIncrementOptionExpr extends SQLSetOptionExpr {


    public SQLAutoIncrementOptionExpr() {
        super(SQLReserved.AUTO_INCREMENT.ofExpr());
    }

    public SQLAutoIncrementOptionExpr(SQLExpr value) {
        super(SQLReserved.AUTO_INCREMENT.ofExpr(), value);
    }

    @Override
    public SQLAutoIncrementOptionExpr clone() {
        SQLAutoIncrementOptionExpr x = new SQLAutoIncrementOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
