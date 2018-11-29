package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ROW (expr, expr [, expr] ...)
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLRowExpr extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLRowExpr clone() {
        SQLRowExpr x = new SQLRowExpr();
        return x;
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
