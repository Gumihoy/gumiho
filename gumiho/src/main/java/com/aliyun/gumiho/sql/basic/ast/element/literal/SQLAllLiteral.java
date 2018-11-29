package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ALL
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLAllLiteral extends AbstractSQLExpr implements SQLLiteral {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAllLiteral clone() {
        return new SQLAllLiteral();
    }

    @Override
    public String getValue() {
        return SQLReserved.ALL.upper;
    }
}
