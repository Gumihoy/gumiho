package com.aliyun.gumiho.sql.basic.ast.element.expr.rollback;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitOption;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * FORCE string
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ROLLBACK.html#GUID-94551F0C-A47F-43DE-BC68-9B1C1ED38C93
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLRollbackForceOption extends AbstractSQLExpr implements SQLRollbackOption {

    protected SQLExpr id;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, id);
        }
    }

    @Override
    public SQLRollbackForceOption clone() {
        SQLRollbackForceOption x = new SQLRollbackForceOption();

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
