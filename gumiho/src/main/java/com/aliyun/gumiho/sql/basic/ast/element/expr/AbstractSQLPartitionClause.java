package com.aliyun.gumiho.sql.basic.ast.element.expr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */
public abstract class AbstractSQLPartitionClause extends AbstractSQLExpr implements ISQLPartitionClause {
    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    public AbstractSQLPartitionClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLPartitionClause x) {
        super.cloneTo(x);

        for (SQLExpr item : items) {
            SQLExpr itemClone = item.clone();
            this.addItem(itemClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(items, source, target, this);
        if (replace) {
            return true;
        }
        return false;
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
