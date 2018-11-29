package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;

/**
 * https://www.postgresql.org/docs/current/static/sql-createsequence.html
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLOwnedByOption extends AbstractSQLExpr implements PostgreSQLSQLSequenceOption {

    protected SQLName ownedBy;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, ownedBy);
        }
    }

    @Override
    public SQLOwnedByOption clone() {
        SQLOwnedByOption x = new SQLOwnedByOption();

        SQLName cloneOwnedBy = this.ownedBy.clone();
        x.setOwnedBy(cloneOwnedBy);

        return x;
    }

    public SQLName getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(SQLName ownedBy) {
        this.ownedBy = ownedBy;
    }
}
