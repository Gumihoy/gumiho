package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * event [of column,column...]
 *
 * @author kongtong.ouyang on 2018/6/15.
 */
public class SQLTriggerDMLEvent extends AbstractSQLExpr implements SQLTriggerEvent.ISQLTriggerDMLEvent, Comparable<SQLTriggerDMLEvent> {

    protected SQLTriggerDMLEventType type;

    protected final List<SQLExpr> ofColumns = new ArrayList<>();

    public SQLTriggerDMLEvent(SQLTriggerDMLEventType type) {
        this.type = type;
    }

    public static SQLTriggerDMLEvent of(SQLTriggerDMLEventType type) {
        return new SQLTriggerDMLEvent(type);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, ofColumns);
        }
    }

    @Override
    public SQLTriggerDMLEvent clone() {
        SQLTriggerDMLEvent x = new SQLTriggerDMLEvent(this.type);
        this.cloneTo(x);
        return x;

    }

    public void cloneTo(SQLTriggerDMLEvent x) {
        super.cloneTo(x);

        for (SQLExpr ofColumn : ofColumns) {
            SQLExpr ofColumnClone = ofColumn.clone();
            x.addOfColumn(ofColumnClone);
        }
    }

    @Override
    public int compareTo(SQLTriggerDMLEvent o) {
        return 0;
    }

    @Override
    public String getEvent() {
        return type.getEvent();
    }

    public SQLTriggerDMLEventType getType() {
        return type;
    }

    public void setType(SQLTriggerDMLEventType type) {
        this.type = type;
    }

    public List<SQLExpr> getOfColumns() {
        return ofColumns;
    }

    public void addOfColumn(SQLExpr ofColumn) {
        if (ofColumn == null) {
            return;
        }
        setChildParent(ofColumn);
        this.ofColumns.add(ofColumn);
    }


    public enum SQLTriggerDMLEventType implements TriggerEventType {

        DELETE(SQLReserved.DELETE),
        INSERT(SQLReserved.INSERT),
        UPDATE(SQLReserved.UPDATE),;
        public final SQLReserved name;

        SQLTriggerDMLEventType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String getEvent() {
            return name.upper;
        }
    }
}
