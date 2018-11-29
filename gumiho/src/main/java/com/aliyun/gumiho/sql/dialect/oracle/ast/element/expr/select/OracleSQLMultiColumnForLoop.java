package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 *FOR (expr ....) IN (expr...)
 * @author kongtong.ouyang on 2018/6/11.
 */
public class OracleSQLMultiColumnForLoop extends AbstractOracleSQLExpr {

    protected final List<SQLName> forItems = new ArrayList<>();

    protected final List<SQLExpr> inItems = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, forItems);
            this.acceptChild(visitor, inItems);
        }
    }

    public List<SQLName> getForItems() {
        return forItems;
    }

    public void addForItem(SQLName forItem) {
        if (forItem == null) {
            return;
        }
        setChildParent(forItem);
        this.forItems.add(forItem);
    }

    public List<SQLExpr> getInItems() {
        return inItems;
    }

    public void addInItem(SQLExpr inItem) {
        if (inItem == null) {
            return;
        }
        setChildParent(inItem);
        this.inItems.add(inItem);
    }
}
