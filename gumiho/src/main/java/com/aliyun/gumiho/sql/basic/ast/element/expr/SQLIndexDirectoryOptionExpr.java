package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * INDEX DIRECTORY [=] 'string'
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLIndexDirectoryOptionExpr extends SQLSetOptionExpr {


    public SQLIndexDirectoryOptionExpr() {
        super(SQLReserved.INDEX_DIRECTORY.ofExpr());
    }

    public SQLIndexDirectoryOptionExpr(SQLExpr value) {
        super(SQLReserved.INDEX_DIRECTORY.ofExpr(), value);
    }

    @Override
    public SQLIndexDirectoryOptionExpr clone() {
        SQLIndexDirectoryOptionExpr x = new SQLIndexDirectoryOptionExpr();
        super.cloneTo(x);
        return x;
    }
}
