package com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SNAPSHOT snapshot_id
 * https://www.postgresql.org/docs/10/static/sql-set-transaction.html
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLSetTransactionSnapshotOption extends AbstractSQLExpr implements SQLSetTransactionOption {

    protected SQLExpr id;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, id);
        }
    }

    @Override
    public SQLSetTransactionSnapshotOption clone() {
        SQLSetTransactionSnapshotOption x = new SQLSetTransactionSnapshotOption();

        SQLExpr idClone = this.id.clone();
        x.setId(idClone);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == id) {
            setId(target);
            return true;
        }
        return false;
    }

    public SQLExpr getId() {
        return id;
    }

    public void setId(SQLExpr id) {
        setChildParent(id);
        this.id = id;
    }
}
