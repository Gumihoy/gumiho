package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * OWNER character-literal
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLServerOwnerOption extends SQLSetOptionExpr implements ISQLServerOption {

    public SQLServerOwnerOption() {
        super(SQLReserved.OWNER.ofExpr());
    }

    public SQLServerOwnerOption(SQLExpr value) {
        super(SQLReserved.OWNER.ofExpr(), value);
    }

    @Override
    public SQLServerOwnerOption clone() {
        SQLServerOwnerOption x = new SQLServerOwnerOption();
        this.cloneTo(x);
        return x;
    }
}
