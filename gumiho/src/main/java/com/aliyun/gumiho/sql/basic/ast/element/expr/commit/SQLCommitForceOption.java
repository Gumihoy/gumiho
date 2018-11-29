package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * FORCE string [, integer ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMIT.html#GUID-6CD5C9A7-54B9-4FA2-BA3C-D6B4492B9EE2
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLCommitForceOption extends AbstractSQLExpr implements SQLCommitOption {

    protected SQLExpr id;
    protected SQLExpr scn;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, id);
            this.acceptChild(visitor, scn);
        }
    }

    @Override
    public SQLCommitForceOption clone() {
        SQLCommitForceOption x = new SQLCommitForceOption();

        SQLExpr idClone = this.id.clone();
        x.setId(idClone);

        if (this.scn != null) {
            SQLExpr scnClone = this.scn.clone();
            x.setScn(scnClone);
        }

        return x;
    }

    public SQLExpr getId() {
        return id;
    }

    public void setId(SQLExpr id) {
        setChildParent(id);
        this.id = id;
    }

    public SQLExpr getScn() {
        return scn;
    }

    public void setScn(SQLExpr scn) {
        setChildParent(scn);
        this.scn = scn;
    }
}
