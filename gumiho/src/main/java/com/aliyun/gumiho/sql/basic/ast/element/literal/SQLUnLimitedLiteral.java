package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * UNLIMITED
 *
 * @author kongtong.ouyang on 2018/6/3.
 */
public class SQLUnLimitedLiteral extends AbstractSQLExpr {


    public static SQLUnLimitedLiteral of() {
        return new SQLUnLimitedLiteral();
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLUnLimitedLiteral clone() {
        return new SQLUnLimitedLiteral();
    }
}
