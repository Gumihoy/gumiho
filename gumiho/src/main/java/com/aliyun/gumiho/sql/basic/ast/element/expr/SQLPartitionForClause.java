package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARTITION FOR ( expr[, expr ]... )
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/join.html
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLPartitionForClause extends AbstractSQLPartitionClause {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLPartitionForClause clone() {
        SQLPartitionForClause x = new SQLPartitionForClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionClause x) {
        super.cloneTo(x);
    }
}