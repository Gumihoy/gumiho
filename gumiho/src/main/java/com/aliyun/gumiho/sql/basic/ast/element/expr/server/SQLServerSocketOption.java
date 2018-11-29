package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * SOCKET character-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerSocketOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerSocketOption() {
        super(SQLReserved.SOCKET.ofExpr());
    }

    public SQLServerSocketOption(SQLExpr value) {
        super(SQLReserved.SOCKET.ofExpr(), value);
    }

    @Override
    public SQLServerSocketOption clone() {
        SQLServerSocketOption x = new SQLServerSocketOption();
        this.cloneTo(x);
        return x;
    }
}
