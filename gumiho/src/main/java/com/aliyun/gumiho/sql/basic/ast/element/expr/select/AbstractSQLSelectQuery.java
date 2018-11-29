package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/8.
 */
public abstract class AbstractSQLSelectQuery extends AbstractSQLExpr implements ISQLSelectQuery {

    protected SQLOrderByClause orderByClause;

    protected ISQLLimitClause limitClause;

    protected ISQLLockClause lockClause;

    @Override
    public AbstractSQLSelectQuery clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLSelectQuery x) {
        super.cloneTo(x);

        if (this.orderByClause != null) {
            SQLOrderByClause orderByClauseClone = orderByClause.clone();
            x.setOrderByClause(orderByClauseClone);
        }

        if (this.limitClause != null) {
            ISQLLimitClause limitClauseClone = limitClause.clone();
            x.setLimitClause(limitClauseClone);
        }

        if (this.lockClause != null) {
            ISQLLockClause lockClauseClone = lockClause.clone();
            x.setLockClause(lockClauseClone);
        }
    }


    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }

    public ISQLLimitClause getLimitClause() {
        return limitClause;
    }

    public void setLimitClause(ISQLLimitClause limitClause) {
        setChildParent(limitClause);
        this.limitClause = limitClause;
    }

    public ISQLLockClause getLockClause() {
        return lockClause;
    }

    public void setLockClause(ISQLLockClause lockClause) {
        setParent(lockClause);
        this.lockClause = lockClause;
    }
}
