package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * ENGINE [=] 'string'
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLEngineOptionExpr extends SQLSetOptionExpr {


    public SQLEngineOptionExpr() {
        super(SQLReserved.ENGINE.ofExpr());
    }

    public SQLEngineOptionExpr(SQLExpr value) {
        super(SQLReserved.ENGINE.ofExpr(), value);
    }

    public SQLEngineOptionExpr(boolean equalSign, SQLExpr value) {
        super(SQLReserved.ENGINE.ofExpr(), equalSign, value);
    }

    @Override
    public SQLEngineOptionExpr clone() {
        SQLEngineOptionExpr x = new SQLEngineOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
