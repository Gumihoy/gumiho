package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLInvalidationType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * UNUSABLE [ ONLINE ] [ { DEFERRED | IMMEDIATE } INVALIDATION ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLAlterIndexUnusableAction extends AbstractSQLExpr implements ISQLAlterIndexAction {

    protected boolean online;
    protected SQLInvalidationType invalidation;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterIndexUnusableAction clone() {
        SQLAlterIndexUnusableAction x = new SQLAlterIndexUnusableAction();

        x.online  = this.online;
        x.invalidation = this.invalidation;
        return x;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public SQLInvalidationType getInvalidation() {
        return invalidation;
    }

    public void setInvalidation(SQLInvalidationType invalidation) {
        this.invalidation = invalidation;
    }
}
