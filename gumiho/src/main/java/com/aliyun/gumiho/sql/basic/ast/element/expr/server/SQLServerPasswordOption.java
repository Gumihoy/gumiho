package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * PASSWORD character-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerPasswordOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerPasswordOption() {
        super(SQLReserved.PASSWORD.ofExpr());
    }

    public SQLServerPasswordOption(SQLExpr value) {
        super(SQLReserved.PASSWORD.ofExpr(), value);
    }

    @Override
    public SQLServerPasswordOption clone() {
        SQLServerPasswordOption x = new SQLServerPasswordOption();
        this.cloneTo(x);
        return x;
    }
}
