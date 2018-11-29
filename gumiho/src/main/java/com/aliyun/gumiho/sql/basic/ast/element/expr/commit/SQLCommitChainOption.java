package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * AND [NO] CHAIN
 * https://dev.mysql.com/doc/refman/8.0/en/commit.html
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLCommitChainOption extends AbstractSQLExpr implements SQLCommitOption {

    protected boolean no;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLCommitChainOption clone() {
        SQLCommitChainOption x = new SQLCommitChainOption();

        x.no = this.no;
        return x;
    }

    public boolean isNo() {
        return no;
    }

    public void setNo(boolean no) {
        this.no = no;
    }
}
