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
package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * VALUES expr, expr
 * expr: listExpr
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#contextually%20typed%20table%20value%20constructor
 * <p>
 * VALUES (expr), expr
 * [ ORDER BY sort_expression [ ASC | DESC | USING operator ] [, ...] ]
 * [ LIMIT { count | ALL } ]
 * [ OFFSET start [ ROW | ROWS ] ]
 * [ FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } ONLY ]
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/insert.html
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-values.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/INSERT.html#GUID-903F8043-0254-4EE9-ACC1-CB8AC0AF3423
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLValuesClause extends AbstractSQLExpr {

    protected SQLReserved values = SQLReserved.VALUES;

    protected final List<SQLValuesItem> items = new ArrayList<>();

    protected SQLOrderByClause orderByClause;

    protected ISQLLimitClause limitClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
        }
    }

    @Override
    public SQLValuesClause clone() {
        SQLValuesClause x = new SQLValuesClause();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLValuesClause x) {
        super.cloneTo(x);

        x.values = this.values;

        for (SQLValuesItem value : this.items) {
            SQLValuesItem valueClone = value.clone();
            x.addValue(valueClone);
        }

        if (this.orderByClause != null) {
            SQLOrderByClause orderByClauseClone = this.orderByClause.clone();
            x.setOrderByClause(orderByClauseClone);
        }

        if (this.limitClause != null) {
            ISQLLimitClause limitClause = this.limitClause.clone();
            x.setLimitClause(limitClause);
        }

    }

    public SQLReserved getValues() {
        return values;
    }

    public void setValues(SQLReserved values) {
        this.values = values;
    }

    public List<SQLValuesItem> getItems() {
        return items;
    }

    public void addValue(SQLValuesItem value) {
        if (value == null) {
            return;
        }
        setChildParent(value);
        this.items.add(value);
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }

    public ISQLLimitClause getLimitClause() {
        return limitClause;
    }

    public void setLimitClause(ISQLLimitClause limitClause) {
        setChildParent(limitClause);
        this.limitClause = limitClause;
    }


    public static class SQLValuesItem extends AbstractSQLExpr {

        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, columns);
            }
        }

        @Override
        public SQLValuesItem clone() {
            SQLValuesItem x = new SQLValuesItem();
            for (SQLExpr column : this.columns) {
                SQLExpr columnClone = column.clone();
                x.addColumn(columnClone);
            }
            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(columns, source, target, this);
            if (replace) {
                return true;
            }

            return false;
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
    }
}
