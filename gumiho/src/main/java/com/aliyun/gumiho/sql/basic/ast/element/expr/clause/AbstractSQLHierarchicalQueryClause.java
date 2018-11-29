package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * hierarchical_query_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/7.
 */
public abstract class AbstractSQLHierarchicalQueryClause extends AbstractSQLExpr implements SQLHierarchicalQueryClause {

    protected boolean noCycle;
    protected SQLExpr connectByCondition;
    protected SQLExpr startWithCondition;

    @Override
    public AbstractSQLHierarchicalQueryClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLHierarchicalQueryClause x) {
        super.cloneTo(x);

        x.noCycle = this.noCycle;

        if (this.connectByCondition != null) {
            SQLExpr connectByConditionClone = this.connectByCondition.clone();
            x.setConnectByCondition(connectByConditionClone);
        }

        if (this.startWithCondition != null) {
            SQLExpr startWithConditionClone = this.startWithCondition.clone();
            x.setStartWithCondition(startWithConditionClone);
        }

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == connectByCondition) {
            setConnectByCondition(target);
            return true;
        }
        if (source == startWithCondition) {
            setStartWithCondition(target);
            return true;
        }
        return false;
    }

    public boolean isNoCycle() {
        return noCycle;
    }

    public void setNoCycle(boolean noCycle) {
        this.noCycle = noCycle;
    }

    @Override
    public SQLExpr getConnectByCondition() {
        return connectByCondition;
    }

    public void setConnectByCondition(SQLExpr connectByCondition) {
        setChildParent(connectByCondition);
        this.connectByCondition = connectByCondition;
    }

    @Override
    public SQLExpr getStartWithCondition() {
        return startWithCondition;
    }

    public void setStartWithCondition(SQLExpr startWithCondition) {
        setChildParent(startWithCondition);
        this.startWithCondition = startWithCondition;
    }
}
