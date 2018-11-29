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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select.order;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#order%20by%20clause
 * <p>
 * [ORDER BY {col_name | expr | position} [ASC | DESC], ... [WITH ROLLUP]]
 * https://dev.mysql.com/doc/refman/8.0/en/select.html
 * <p>
 * <p>
 * ORDER [ SIBLINGS ] BY { expr | position | c_alias } [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ] [, { expr | position | c_alias } [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ] ]...
 * order_by_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html#GUID-527832F7-63C0-4445-8C16-307FA5084056
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-select.html#SQL-ORDERBY
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLOrderByClause extends AbstractSQLExpr {

    protected boolean siblings;

    protected final List<SQLOrderByItem> items = new ArrayList<>();

    protected boolean withRollup;


    public SQLOrderByClause() {
    }

    public SQLOrderByClause(String sortKey) {
        if (sortKey == null) {
            throw new IllegalArgumentException("sortKey is null.");
        }
        SQLOrderByItem item = new SQLOrderByItem(sortKey);
        addItem(item);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLOrderByClause clone() {
        SQLOrderByClause x = new SQLOrderByClause();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLOrderByClause x) {
        super.cloneTo(x);

        x.siblings = this.siblings;

        for (SQLOrderByItem item : this.items) {
            SQLOrderByItem itemClone = item.clone();
            x.addItem(itemClone);
        }

    }

    public boolean isSiblings() {
        return siblings;
    }

    public void setSiblings(boolean siblings) {
        this.siblings = siblings;
    }

    public List<SQLOrderByItem> getItems() {
        return items;
    }

    public void addItem(SQLOrderByItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public boolean isWithRollup() {
        return withRollup;
    }

    public void setWithRollup(boolean withRollup) {
        this.withRollup = withRollup;
    }
}
