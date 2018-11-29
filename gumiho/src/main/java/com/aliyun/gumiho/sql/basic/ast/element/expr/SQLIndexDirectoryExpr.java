package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *  DATA DIRECTORY [=] value
 *
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLIndexDirectoryExpr extends SQLSetOptionExpr {

    public SQLIndexDirectoryExpr() {
    }

    public SQLIndexDirectoryExpr(SQLExpr value) {
        super(SQLReserved.DATA_DIRECTORY.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLIndexDirectoryExpr clone() {
        SQLIndexDirectoryExpr x = new SQLIndexDirectoryExpr();
        this.cloneTo(x);
        return x;
    }
}
