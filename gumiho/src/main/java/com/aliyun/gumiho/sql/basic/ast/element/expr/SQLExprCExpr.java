package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * @author kongtong.ouyang on 2018/6/25.
 */
public class SQLExprCExpr extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLExpr clone() {
        return super.clone();
    }
}
