package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * PARTITION BY { expr[, expr ]... | ( expr[, expr ]... ) }
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20partition%20clause
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public class SQLPartitionByClause extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLPartitionByClause clone() {
        SQLPartitionByClause x = new SQLPartitionByClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionByClause x) {
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
