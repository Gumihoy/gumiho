package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * USER character-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerUserOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerUserOption() {
        super(SQLReserved.USER.ofExpr());
    }

    public SQLServerUserOption(SQLExpr value) {
        super(SQLReserved.USER.ofExpr(), value);
    }

    @Override
    public SQLServerUserOption clone() {
        SQLServerUserOption x = new SQLServerUserOption();
        this.cloneTo(x);
        return x;
    }
}
