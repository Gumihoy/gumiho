package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARTITION ( expr[, expr ]... )
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/join.html
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public class SQLPartitionClause extends AbstractSQLPartitionClause {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLPartitionClause clone() {
        SQLPartitionClause x = new SQLPartitionClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionClause x) {
        super.cloneTo(x);
    }
}
