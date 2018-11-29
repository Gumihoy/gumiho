package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * CUBE <left paren> <ordinary grouping set list> <right paren>
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#cube%20list
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLCubeClause extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLCubeClause clone() {
        SQLCubeClause x = new SQLCubeClause();

        for (SQLExpr item : items) {
            SQLExpr clone = item.clone();
            x.addItem(clone);
        }
        return x;
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
