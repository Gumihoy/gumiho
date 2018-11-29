package com.aliyun.gumiho.sql.basic.ast.element.function.xml;


import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * PASSING [ BY VALUE ] expr [ AS identifier ] [, expr [ AS identifier ]]...
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLXmlPassingClause extends AbstractSQLExpr {

    protected boolean byValue;

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }


    public boolean isByValue() {
        return byValue;
    }

    public void setByValue(boolean byValue) {
        this.byValue = byValue;
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
