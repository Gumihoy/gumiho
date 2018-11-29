package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ( [expr [, expr ]] ...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Expression-Lists.html#GUID-5CC8FC75-813B-44AA-8737-D940FA887D1E
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLListExpr extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();

    public SQLListExpr() {
    }

    public SQLListExpr(SQLExpr item) {
        this.items.add(item);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLListExpr clone() {
        SQLListExpr x = new SQLListExpr();
        this.cloneTo(x);
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            addItem(itemClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return replaceInList(items, source, target, this);
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
