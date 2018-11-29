package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NONE
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLNoneLiteral extends AbstractSQLExpr implements SQLLiteral {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNoneLiteral clone() {
        return new SQLNoneLiteral();
    }

    @Override
    public String getValue() {
        return SQLReserved.NONE.upper;
    }
}
