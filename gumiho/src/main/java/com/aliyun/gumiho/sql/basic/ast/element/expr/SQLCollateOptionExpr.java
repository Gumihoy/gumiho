package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [DEFAULT] COLLATE [=] name
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#collate%20clause
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLCollateOptionExpr extends SQLSetOptionExpr {

    public SQLCollateOptionExpr() {
    }

    public SQLCollateOptionExpr(SQLExpr value) {
        super(SQLReserved.COLLATE.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLCollateOptionExpr clone() {
        SQLCollateOptionExpr x = new SQLCollateOptionExpr();
        this.cloneTo(x);
        return x;
    }
}
