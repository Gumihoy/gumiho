package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang on 2018/6/6.
 */
public abstract class AbstractOracleSQLPivotClause extends AbstractOracleSQLExpr implements IOracleSQLPivotClause {

    protected SQLExpr pivotForExpr;

    protected final List<SQLExpr> inItems = new ArrayList<>();

    @Override
    public AbstractOracleSQLPivotClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLPivotClause x) {
        super.cloneTo(x);
    }


    public SQLExpr getPivotForExpr() {
        return pivotForExpr;
    }

    public void setPivotForExpr(SQLExpr pivotForExpr) {
        this.pivotForExpr = pivotForExpr;
    }

    public List<SQLExpr> getInItems() {
        return inItems;
    }

    public void addInItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.inItems.add(item);
    }
}
