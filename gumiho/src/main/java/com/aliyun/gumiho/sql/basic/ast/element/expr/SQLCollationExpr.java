package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [DEFAULT] COLLATION name
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLCollationExpr extends SQLSetOptionExpr {

    public SQLCollationExpr() {
    }

    public SQLCollationExpr(SQLExpr value) {
        super(SQLReserved.COLLATION.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLCollationExpr clone() {
        SQLCollationExpr x = new SQLCollationExpr();
        this.cloneTo(x);
        return x;
    }
}
