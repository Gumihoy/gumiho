package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * :host_variable INDICATOR? :indicator_variable
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Placeholder-Expressions.html#GUID-B98B5394-A573-4BF8-9EC3-7B1BB1130553
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLPlaceholderExpr extends AbstractSQLExpr {

    protected SQLBindVariableExpr hostExpr;
    protected boolean indicator;
    protected SQLBindVariableExpr indicatorExpr;

    public SQLPlaceholderExpr() {
    }

    public SQLPlaceholderExpr(SQLBindVariableExpr hostExpr, SQLBindVariableExpr indicatorExpr) {
        setHostExpr(hostExpr);
        setIndicatorExpr(indicatorExpr);
    }

    public SQLPlaceholderExpr(SQLBindVariableExpr hostExpr, boolean indicator, SQLBindVariableExpr indicatorExpr) {
        setHostExpr(hostExpr);
        this.indicator = indicator;
        setIndicatorExpr(indicatorExpr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, hostExpr);
            this.acceptChild(visitor, indicatorExpr);
        }
    }

    public SQLBindVariableExpr getHostExpr() {
        return hostExpr;
    }

    public void setHostExpr(SQLBindVariableExpr hostExpr) {
        setChildParent(hostExpr);
        this.hostExpr = hostExpr;
    }

    public boolean isIndicator() {
        return indicator;
    }

    public void setIndicator(boolean indicator) {
        this.indicator = indicator;
    }

    public SQLBindVariableExpr getIndicatorExpr() {
        return indicatorExpr;
    }

    public void setIndicatorExpr(SQLBindVariableExpr indicatorExpr) {
        setChildParent(indicatorExpr);
        this.indicatorExpr = indicatorExpr;
    }
}
