package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MAXVALUE
 *
 * @author kongtong.ouyang on 2018/6/3.
 */
public class SQLMaxValueLiteral extends AbstractSQLExpr {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLMaxValueLiteral clone() {
        return new SQLMaxValueLiteral();
    }
}
