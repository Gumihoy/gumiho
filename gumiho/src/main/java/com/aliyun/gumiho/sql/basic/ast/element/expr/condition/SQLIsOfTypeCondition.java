package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * expr IS [ NOT ] OF [ TYPE ] ([ ONLY ] [ schema. ] type [, [ ONLY ] [ schema. ] type ]...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/IS-OF-type-Condition.html#GUID-7254E4C7-0194-4C1F-A3B2-2CFB0AD907CD
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLIsOfTypeCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;
    protected boolean not;
    protected boolean type;
    protected final List<Item> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLIsOfTypeCondition clone() {
        SQLIsOfTypeCondition x = new SQLIsOfTypeCondition();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLIsOfTypeCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = expr.clone();
        x.setExpr(exprClone);

        x.not = this.not;
        x.type = this.type;

        for (Item item : this.items) {
            Item itemClone = item.clone();
            x.addItem(itemClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }
        return false;
    }


    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }




    public static final class Item extends AbstractSQLExpr {

        protected boolean only;
        protected SQLName name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public Item clone() {
            Item x = new Item();

            x.only = this.only;

            SQLName nameClone = name.clone();
            x.setName(nameClone);

            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == name
                    && target instanceof SQLName) {
                setName((SQLName) target);
                return true;
            }
            return false;
        }

        public boolean isOnly() {
            return only;
        }

        public void setOnly(boolean only) {
            this.only = only;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }
}
