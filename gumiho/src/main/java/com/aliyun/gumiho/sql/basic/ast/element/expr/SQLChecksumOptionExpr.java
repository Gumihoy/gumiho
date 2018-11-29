package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * CHECKSUM [=] {0 | 1}
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLChecksumOptionExpr extends SQLSetOptionExpr {


    public SQLChecksumOptionExpr() {
        super(SQLReserved.CHECKSUM.ofExpr());
    }

    public SQLChecksumOptionExpr(SQLExpr value) {
        super(SQLReserved.CHECKSUM.ofExpr(), value);
    }

    public SQLChecksumOptionExpr(boolean equalSign, SQLExpr value) {
        super(SQLReserved.CHECKSUM.ofExpr(), equalSign, value);
    }

    @Override
    public SQLChecksumOptionExpr clone() {
        SQLChecksumOptionExpr x = new SQLChecksumOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
