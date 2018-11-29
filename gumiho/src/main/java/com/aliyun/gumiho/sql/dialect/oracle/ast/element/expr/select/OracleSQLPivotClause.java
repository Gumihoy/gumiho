package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.function.ISQLFunction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * PIVOT [ XML ] ( aggregate_function ( expr ) [[AS] alias ] [, aggregate_function ( expr ) [[AS] alias ] ]...
 * pivot_for_clause pivot_in_clause)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/UPDATE.html#GUID-027A462D-379D-4E35-8611-410F3AC8FDA5
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class OracleSQLPivotClause extends AbstractOracleSQLPivotClause {

    protected boolean xml;

    protected final List<OracleSQLPivotItem> items = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, pivotForExpr);
            this.acceptChild(visitor, inItems);
        }
    }

    public boolean isXml() {
        return xml;
    }

    public void setXml(boolean xml) {
        this.xml = xml;
    }

    public List<OracleSQLPivotItem> getItems() {
        return items;
    }

    public void addItem(OracleSQLPivotItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    /**
     * aggregate_function [[AS] alias ]
     */
    public static class OracleSQLPivotItem extends AbstractOracleSQLExpr {

        protected ISQLFunction aggregateFunction;

        protected boolean as;

        protected SQLName alias;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, aggregateFunction);
                this.acceptChild(visitor, alias);
            }
        }

        public ISQLFunction getAggregateFunction() {
            return aggregateFunction;
        }

        public void setAggregateFunction(ISQLFunction aggregateFunction) {
            setChildParent(aggregateFunction);
            this.aggregateFunction = aggregateFunction;
        }

        public boolean isAs() {
            return as;
        }

        public void setAs(boolean as) {
            this.as = as;
        }

        public SQLName getAlias() {
            return alias;
        }

        public void setAlias(SQLName alias) {
            setChildParent(alias);
            this.alias = alias;
        }
    }

}
