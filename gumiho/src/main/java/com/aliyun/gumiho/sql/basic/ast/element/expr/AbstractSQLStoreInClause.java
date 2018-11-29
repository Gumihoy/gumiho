package com.aliyun.gumiho.sql.basic.ast.element.expr;

import java.util.ArrayList;
import java.util.List;

/**
 * STORE IN (  tablespace [, tablespace]... )
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public abstract class AbstractSQLStoreInClause extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();


    @Override
    public AbstractSQLStoreInClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLStoreInClause x) {
        super.cloneTo(x);
        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
