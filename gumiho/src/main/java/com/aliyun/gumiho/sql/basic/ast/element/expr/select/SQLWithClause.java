/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByItem;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#with%20clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 * <p>
 * https://www.postgresql.org/docs/10/static/sql-select.html
 * <p>
 * https://www.postgresql.org/docs/10/static/sql-select.html#SQL-WITH
 *
 * @author kongtong.ouyang onCondition 2018/3/25.
 */
public class SQLWithClause extends AbstractSQLExpr implements ISQLWithClause {

    protected boolean recursive;

    protected final List<SQLWithElement> withElements = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, withElements);
        }
    }

    @Override
    public SQLWithClause clone() {
        SQLWithClause x = new SQLWithClause();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLWithClause x) {
        super.cloneTo(x);

        x.recursive = this.recursive;

        for (SQLWithElement withElement : withElements) {
            SQLWithElement withElementClone = withElement.clone();
            x.addWithElement(withElementClone);
        }
    }

    @Override
    public boolean isRecursive() {
        return recursive;
    }

    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    @Override
    public List<SQLWithElement> getWithElements() {
        return withElements;
    }

    public void addWithElement(SQLWithElement withElement) {
        if (withElement == null) {
            return;
        }
        withElement.setParent(this);
        withElements.add(withElement);
    }


    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#with%20list
     * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_10002.htm#i2161315
     * https://www.postgresql.org/docs/10/static/sql-select.html#SQL-WITH
     */
    public interface SQLWithElement extends SQLExpr {
        @Override
        SQLWithElement clone();
    }

    /**
     * <query name> [ <left paren> <with column list> <right paren> ]
     * AS <left paren> <query expression> <right paren> [ <search or cycle clause> ]
     * <p>
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#with%20list
     * <p>
     * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_10002.htm#i2161315
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
     * <p>
     * https://www.postgresql.org/docs/10/static/sql-select.html#SQL-WITH
     */
    public static class SQLSubQueryFactoringClause extends AbstractSQLExpr implements SQLWithElement {

        private SQLName queryName;

        private final List<SQLExpr> columns = new ArrayList<>();

        private SQLObject statement;

        private SQLSearchClause searchClause;

        private SQLCycleClause cycleClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, queryName);
                this.acceptChild(visitor, columns);
                this.acceptChild(visitor, statement);
                this.acceptChild(visitor, searchClause);
                this.acceptChild(visitor, cycleClause);
            }
        }

        @Override
        public SQLSubQueryFactoringClause clone() {
            SQLSubQueryFactoringClause x = new SQLSubQueryFactoringClause();
            this.cloneTo(x);
            return x;
        }


        public void cloneTo(SQLSubQueryFactoringClause x) {
            super.cloneTo(x);

            SQLName queryNameClone = this.queryName.clone();
            x.setQueryName(queryNameClone);

            for (SQLExpr column : columns) {
                SQLExpr columnClone = column.clone();
                x.addColumn(columnClone);
            }

            if (this.statement != null) {
                SQLObject statementClone = this.statement.clone();
                x.setStatement(statementClone);
            }

            if (this.searchClause != null) {
                SQLSearchClause searchClauseClone = this.searchClause.clone();
                x.setSearchClause(searchClauseClone);
            }

            if (this.cycleClause != null) {
                SQLCycleClause cycleClauseClone = this.cycleClause.clone();
                x.setCycleClause(cycleClauseClone);
            }

        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == queryName) {
                setQueryName((SQLName) target);
                return true;
            }

            boolean replace = replaceInList(columns, source, target, this);
            if (replace) {
                return true;
            }

            if (source == statement) {
                setStatement(target);
                return true;
            }

            return false;
        }

        public SQLName getQueryName() {
            return queryName;
        }

        public String getQueryNameStr() {
            if (queryName != null) {
                return queryName.getName();
            }
            return null;
        }

        public void setQueryName(SQLName queryName) {
            setChildParent(queryName);
            this.queryName = queryName;
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }

        public SQLObject getStatement() {
            return statement;
        }

        public void setStatement(SQLObject statement) {
            if (statement != null) {
                statement.setParent(this);
            }
            this.statement = statement;
        }

        public SQLSearchClause getSearchClause() {
            return searchClause;
        }

        public void setSearchClause(SQLSearchClause searchClause) {
            setChildParent(searchClause);
            this.searchClause = searchClause;
        }

        public SQLCycleClause getCycleClause() {
            return cycleClause;
        }

        public void setCycleClause(SQLCycleClause cycleClause) {
            setChildParent(cycleClause);
            this.cycleClause = cycleClause;
        }
    }


    /**
     * SEARCH <recursive search order> SET <sequence column>
     * <p>
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#search%20clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/search_clause.html
     */
    public static class SQLSearchClause extends AbstractSQLExpr {

        /**
         * DEPTH/BREADTH
         */
        protected SQLReserved type;

        protected final List<SQLOrderByItem> orderByItems = new ArrayList<>();

        protected SQLExpr column;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, orderByItems);
                this.acceptChild(visitor, column);
            }
        }

        @Override
        public SQLSearchClause clone() {
            SQLSearchClause x = new SQLSearchClause();
            this.cloneTo(x);
            return x;
        }

        public void cloneTo(SQLSearchClause x) {
            super.cloneTo(x);

            x.setType(this.type);

            for (SQLOrderByItem orderByItem : orderByItems) {
                SQLOrderByItem orderByItemClone = orderByItem.clone();
                x.addOrderByItem(orderByItemClone);
            }

            SQLExpr columnClone = this.column.clone();
            x.setColumn(columnClone);
        }


        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {

            if (target instanceof SQLOrderByItem) {
                boolean replace = replaceInList(orderByItems, source, (SQLOrderByItem) target, this);
                if (replace) {
                    return true;
                }
            }

            if (source == column) {
                this.setColumn(target);
                return true;
            }
            return false;
        }

        public SQLReserved getType() {
            return type;
        }

        public void setType(SQLReserved type) {
            this.type = type;
        }

        public List<SQLOrderByItem> getOrderByItems() {
            return orderByItems;
        }

        public void addOrderByItem(SQLOrderByItem orderByItem) {
            if (orderByItem == null) {
                return;
            }
            setChildParent(orderByItem);
            this.orderByItems.add(orderByItem);
        }

        public SQLExpr getColumn() {
            return column;
        }

        public void setColumn(SQLExpr column) {
            setChildParent(column);
            this.column = column;
        }
    }

    /**
     * CYCLE <cycle column list>
     * SET <cycle mark column> TO <cycle mark value>
     * DEFAULT <non-cycle mark value>
     * USING <path column>
     * <p>
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#cycle%20clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/cycle_clause.html
     */
    public static class SQLCycleClause extends AbstractSQLExpr {

        protected final List<SQLExpr> cycleColumns = new ArrayList<>();

        protected SQLExpr cycleMarkColumn;

        protected SQLExpr cycleMarkValue;

        protected SQLExpr nonCycleMarkValue;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, cycleColumns);
                this.acceptChild(visitor, cycleMarkColumn);
                this.acceptChild(visitor, cycleMarkValue);
                this.acceptChild(visitor, nonCycleMarkValue);
            }
        }

        @Override
        public SQLCycleClause clone() {
            SQLCycleClause x = new SQLCycleClause();
            this.cloneTo(x);
            return x;
        }

        public void cloneTo(SQLCycleClause x) {
            super.cloneTo(x);
            for (SQLExpr cycleColumn : cycleColumns) {
                SQLExpr cycleColumnClone = cycleColumn.clone();
                x.addCycleColumn(cycleColumnClone);
            }

            SQLExpr cycleMarkColumnClone = this.cycleMarkColumn.clone();
            x.setCycleMarkColumn(cycleMarkColumnClone);

            SQLExpr cycleMarkValueClone = this.cycleMarkValue.clone();
            x.setCycleMarkValue(cycleMarkValueClone);

            SQLExpr nonCycleMarkValueClone = this.nonCycleMarkValue.clone();
            x.setNonCycleMarkValue(nonCycleMarkValueClone);
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(cycleColumns, source, target, this);
            if (replace) {
                return true;
            }

            if (source == cycleMarkColumn) {
                this.setCycleMarkColumn(target);
                return true;
            }

            if (source == cycleMarkValue) {
                this.setCycleMarkValue(target);
                return true;
            }

            if (source == nonCycleMarkValue) {
                this.setNonCycleMarkValue(target);
                return true;
            }

            return false;
        }

        public List<SQLExpr> getCycleColumns() {
            return cycleColumns;
        }

        public void addCycleColumn(SQLExpr cycleColumn) {
            if (cycleColumn == null) {
                return;
            }
            setChildParent(cycleColumn);
            this.cycleColumns.add(cycleColumn);
        }

        public SQLExpr getCycleMarkColumn() {
            return cycleMarkColumn;
        }

        public void setCycleMarkColumn(SQLExpr cycleMarkColumn) {
            setChildParent(cycleMarkColumn);
            this.cycleMarkColumn = cycleMarkColumn;
        }

        public SQLExpr getCycleMarkValue() {
            return cycleMarkValue;
        }

        public void setCycleMarkValue(SQLExpr cycleMarkValue) {
            setChildParent(cycleMarkValue);
            this.cycleMarkValue = cycleMarkValue;
        }

        public SQLExpr getNonCycleMarkValue() {
            return nonCycleMarkValue;
        }

        public void setNonCycleMarkValue(SQLExpr nonCycleMarkValue) {
            setChildParent(nonCycleMarkValue);
            this.nonCycleMarkValue = nonCycleMarkValue;
        }
    }
}
