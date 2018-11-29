package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * PORT numeric-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerPortOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerPortOption() {
        super(SQLReserved.PORT.ofExpr());
    }

    public SQLServerPortOption(SQLExpr value) {
        super(SQLReserved.PORT.ofExpr(), value);
    }

    @Override
    public SQLServerPortOption clone() {
        SQLServerPortOption x = new SQLServerPortOption();
        this.cloneTo(x);
        return x;
    }
}
