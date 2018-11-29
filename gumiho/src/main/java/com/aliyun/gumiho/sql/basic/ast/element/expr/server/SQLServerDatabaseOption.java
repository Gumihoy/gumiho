package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * DATABASE character-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerDatabaseOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerDatabaseOption() {
        super(SQLReserved.DATABASE.ofExpr());
    }

    public SQLServerDatabaseOption(SQLExpr value) {
        super(SQLReserved.DATABASE.ofExpr(), value);
    }

    @Override
    public SQLServerHostOption clone() {
        SQLServerHostOption x = new SQLServerHostOption();
        this.cloneTo(x);
        return x;
    }
}
