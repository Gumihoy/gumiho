package com.aliyun.gumiho.sql.basic.ast.element.hint;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IGNORE KEY [FOR {JOIN|ORDER BY|GROUP BY}] ([index_list])
 * https://dev.mysql.com/doc/refman/5.7/en/index-hints.html
 * <p>
 * IGNORE KEY [FOR {JOIN|ORDER BY|GROUP BY}] ([index_list])
 * https://help.aliyun.com/document_detail/71274.html?spm=a2c4g.11186623.6.684.732442295I0RfQ#1
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class SQLIgnoreKeyHint extends AbstractSQLIndexHint {

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public AbstractSQLIndexHint clone() {
        SQLIgnoreKeyHint x = new SQLIgnoreKeyHint();
        this.cloneTo(x);
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }
}
