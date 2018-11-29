package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * BROADCAST
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class SQLBroadcastExpr extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBroadcastExpr clone() {
        return new SQLBroadcastExpr();
    }
}
