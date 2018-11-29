package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * AVG_ROW_LENGTH [=] value
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLAvgRowLengthOptionExpr extends SQLSetOptionExpr {


    public SQLAvgRowLengthOptionExpr() {
        super(SQLReserved.AVG_ROW_LENGTH.ofExpr());
    }

    public SQLAvgRowLengthOptionExpr(SQLExpr value) {
        super(SQLReserved.AVG_ROW_LENGTH.ofExpr(), value);
    }

    @Override
    public SQLAvgRowLengthOptionExpr clone() {
        SQLAvgRowLengthOptionExpr x = new SQLAvgRowLengthOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
