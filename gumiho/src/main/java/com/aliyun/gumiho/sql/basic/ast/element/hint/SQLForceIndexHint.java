package com.aliyun.gumiho.sql.basic.ast.element.hint;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * FORCE INDEX [FOR {JOIN|ORDER BY|GROUP BY}] ([index_list])
 * https://dev.mysql.com/doc/refman/5.7/en/index-hints.html
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class SQLForceIndexHint extends AbstractSQLIndexHint {

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public AbstractSQLIndexHint clone() {
        SQLForceIndexHint x = new SQLForceIndexHint();
        this.cloneTo(x);
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }
}
