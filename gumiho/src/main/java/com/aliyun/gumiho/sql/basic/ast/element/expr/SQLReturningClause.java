package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * returning expr (, expr ...)
 *
 * @author kongtong.ouyang on 2018/6/5.
 */
public class SQLReturningClause extends AbstractSQLExpr implements ISQLReturningClause {

    protected SQLReturningType returning = SQLReturningType.RETURNING;

    protected final List<SQLExpr> returningItems = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, returningItems);
        }
    }

    @Override
    public SQLReturningClause clone() {
        SQLReturningClause x = new SQLReturningClause();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLReturningClause x) {
        super.cloneTo(x);

        x.returning = this.returning;
        for (SQLExpr returningItem : returningItems) {
            SQLExpr returningItemClone = returningItem.clone();
            x.addReturningItem(returningItemClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(returningItems, source, target, this);
        if (replace) {
            return true;
        }
        return false;
    }

    public SQLReturningType getReturning() {
        return returning;
    }

    public void setReturning(SQLReturningType returning) {
        this.returning = returning;
    }

    public List<SQLExpr> getReturningItems() {
        return returningItems;
    }

    public void addReturningItem(SQLExpr returningItem) {
        if (returningItem == null) {
            return;
        }
        setChildParent(returningItem);
        this.returningItems.add(returningItem);
    }


    public enum SQLReturningType {
        RETURNING(SQLReserved.RETURNING),
        RETURN(SQLReserved.RETURN),;

        public final SQLReserved name;

        SQLReturningType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
