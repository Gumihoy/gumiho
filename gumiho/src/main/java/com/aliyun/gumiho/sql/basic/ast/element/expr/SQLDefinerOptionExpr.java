package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DEFINER = { user | CURRENT_USER }
 * <p>
 * https://dev.mysql.com/doc/refman/5.6/en/create-trigger.html
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLDefinerOptionExpr extends SQLSetOptionExpr {

    public SQLDefinerOptionExpr() {
    }

    public SQLDefinerOptionExpr(SQLExpr value) {
        super(SQLReserved.DEFINER.ofExpr(), value);
    }

    public SQLDefinerOptionExpr(boolean equalSign, SQLExpr value) {
        super(SQLReserved.DEFINER.ofExpr(), equalSign, value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLDefinerOptionExpr clone() {
        SQLDefinerOptionExpr x = new SQLDefinerOptionExpr();
        this.cloneTo(x);
        return x;
    }
}
