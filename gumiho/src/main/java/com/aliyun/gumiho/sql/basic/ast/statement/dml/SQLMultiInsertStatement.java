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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLErrorLoggingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLValuesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.hint.SQLHint;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * insert
 * { ALL
 * { insert_into_clause [ values_clause ] [error_logging_clause] }...
 * | conditional_insert_clause
 * } subquery
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/INSERT.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLMultiInsertStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected List<SQLHint> hints;

    protected SQLReserved option;

    protected SQLExpr expr;

    protected ISQLSelectQuery subQuery;


    public SQLMultiInsertStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, subQuery);
        }
    }

    @Override
    public SQLMultiInsertStatement clone() {
        SQLMultiInsertStatement x = new SQLMultiInsertStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLMultiInsertStatement x) {
        super.cloneTo(x);

        x.option = this.option;

        SQLExpr exprClone = expr.clone();
        x.setExpr(exprClone);

        if (subQuery != null) {
            ISQLSelectQuery clone = subQuery.clone();
            x.setSubQuery(clone);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.INSERT;
    }


    public SQLReserved getOption() {
        return option;
    }

    public void setOption(SQLReserved option) {
        this.option = option;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }


    /**
     * { insert_into_clause [ values_clause ] [error_logging_clause] }...
     */
    public static class SQLInsertIntoClause extends AbstractSQLExpr {
        protected final List<SQLExpr> items = new ArrayList<>();

        @Override
        public void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, items);
            }
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

    /**
     * WHEN condition
     * THEN insert_into_clause
     * [ values_clause ]
     * [ error_logging_clause ]
     * [ insert_into_clause [ values_clause ] [ error_logging_clause ] ]...
     * [ WHEN condition
     * THEN insert_into_clause
     * [ values_clause ]
     * [ error_logging_clause ]
     * [ insert_into_clause [ values_clause ] [ error_logging_clause ] ]...
     * ]...
     * [ ELSE insert_into_clause
     * [ values_clause ]
     * [ error_logging_clause ]
     * [ insert_into_clause [ values_clause ] [ error_logging_clause ] ]...
     * ]
     */
    public static class SQLConditionalInsertIntoClause extends AbstractSQLExpr {

        protected final List<SQLConditionalInsertWhenClause> whenClauses = new ArrayList<>();

        protected final List<SQLInsertIntoClauseItem> elseItems = new ArrayList<>();

        @Override
        public void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, whenClauses);
                this.acceptChild(visitor, elseItems);
            }
        }

        public List<SQLConditionalInsertWhenClause> getWhenClauses() {
            return whenClauses;
        }

        public void addWhenClause(SQLConditionalInsertWhenClause whenClause) {
            if (whenClause == null) {
                return;
            }
            setChildParent(whenClause);
            this.whenClauses.add(whenClause);
        }

        public List<SQLInsertIntoClauseItem> getElseItems() {
            return elseItems;
        }

        public void addElseItem(SQLInsertIntoClauseItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.elseItems.add(item);
        }
    }

    /**
     * INTO tableReference [columns] [valuesClause] [errorLoggingClause]
     */
    public static class SQLInsertIntoClauseItem extends AbstractSQLExpr {

        protected ISQLTableReference tableReference;
        protected final List<SQLExpr> columns = new ArrayList<>();
        protected SQLValuesClause valuesClause;
        protected SQLErrorLoggingClause errorLoggingClause;

        @Override
        public void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, tableReference);
                this.acceptChild(visitor, columns);
                this.acceptChild(visitor, valuesClause);
                this.acceptChild(visitor, errorLoggingClause);
            }
        }

        @Override
        public SQLInsertIntoClauseItem clone() {
            SQLInsertIntoClauseItem x = new SQLInsertIntoClauseItem();
            this.cloneTo(x);
            return x;
        }

        public void cloneTo(SQLInsertIntoClauseItem x) {
            super.cloneTo(x);
        }


        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(columns, source, target, this);
            if (replace) {
                return true;
            }
            return false;
        }

        public ISQLTableReference getTableReference() {
            return tableReference;
        }

        public void setTableReference(ISQLTableReference tableReference) {
            setChildParent(tableReference);
            this.tableReference = tableReference;
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

        public SQLValuesClause getValuesClause() {
            return valuesClause;
        }

        public void setValuesClause(SQLValuesClause valuesClause) {
            setChildParent(valuesClause);
            this.valuesClause = valuesClause;
        }

        public SQLErrorLoggingClause getErrorLoggingClause() {
            return errorLoggingClause;
        }

        public void setErrorLoggingClause(SQLErrorLoggingClause errorLoggingClause) {
            setChildParent(errorLoggingClause);
            this.errorLoggingClause = errorLoggingClause;
        }
    }


    /**
     * WHEN condition THEN thens
     */
    public static class SQLConditionalInsertWhenClause extends AbstractSQLExpr {

        protected SQLExpr condition;
        protected final List<SQLInsertIntoClauseItem> thenItems = new ArrayList<>();

        @Override
        public void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, condition);
                this.acceptChild(visitor, thenItems);
            }
        }

        public SQLExpr getCondition() {
            return condition;
        }

        public void setCondition(SQLExpr condition) {
            setChildParent(condition);
            this.condition = condition;
        }

        public List<SQLInsertIntoClauseItem> getThenItems() {
            return thenItems;
        }

        public void addThenItem(SQLInsertIntoClauseItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.thenItems.add(item);
        }
    }

}
