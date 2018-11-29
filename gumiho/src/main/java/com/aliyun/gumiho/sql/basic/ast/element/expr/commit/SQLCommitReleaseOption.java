package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [NO] RELEASE
 * https://dev.mysql.com/doc/refman/8.0/en/commit.html
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLCommitReleaseOption extends AbstractSQLExpr implements SQLCommitOption {

    protected boolean no;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLCommitReleaseOption clone() {
        SQLCommitReleaseOption x = new SQLCommitReleaseOption();

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
