package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * returning expr (, expr ...)
 * [bulk collect] INTO expr (, expr ...)
 *
 * @author kongtong.ouyang on 2018/6/5.
 */
public class SQLReturningIntoClause extends SQLReturningClause implements ISQLReturningClause {

    protected boolean bulkCollect;

    protected final List<SQLExpr> intoItems = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, returningItems);
            this.acceptChild(visitor, intoItems);
        }
    }

    @Override
    public SQLReturningIntoClause clone() {
        SQLReturningIntoClause x = new SQLReturningIntoClause();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLReturningIntoClause x) {
        super.cloneTo(x);

        x.bulkCollect = this.bulkCollect;
        for (SQLExpr intoItem : intoItems) {
            SQLExpr intoItemClone = intoItem.clone();
            x.addIntoItem(intoItemClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = super.replace(source, target);
        if (replace) {
            return true;
        }

        replace = replaceInList(intoItems, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    public boolean isBulkCollect() {
        return bulkCollect;
    }

    public void setBulkCollect(boolean bulkCollect) {
        this.bulkCollect = bulkCollect;
    }

    public List<SQLExpr> getIntoItems() {
        return intoItems;
    }

    public void addIntoItem(SQLExpr intoItem) {
        if (intoItem == null) {
            return;
        }
        setChildParent(intoItem);
        this.intoItems.add(intoItem);
    }


}
