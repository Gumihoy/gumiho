package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * STORE IN (  tablespace [, tablespace]... )
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class SQLStoreInClause extends AbstractSQLStoreInClause {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLStoreInClause clone() {
        SQLStoreInClause x = new SQLStoreInClause();
        this.cloneTo(x);
        return x;
    }


}
