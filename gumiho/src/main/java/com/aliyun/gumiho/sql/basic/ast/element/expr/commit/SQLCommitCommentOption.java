package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COMMET string
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMIT.html#GUID-6CD5C9A7-54B9-4FA2-BA3C-D6B4492B9EE2
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLCommitCommentOption extends AbstractSQLExpr implements SQLCommitOption {

    protected SQLExpr value;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLCommitCommentOption clone() {
        SQLCommitCommentOption x = new SQLCommitCommentOption();
        SQLExpr valueClone = this.value.clone();
        x.setValue(valueClone);
        return x;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
