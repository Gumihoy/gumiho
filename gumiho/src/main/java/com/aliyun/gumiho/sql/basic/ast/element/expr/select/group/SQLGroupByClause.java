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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select.group;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * GROUP BY [ <set quantifier> ] <grouping element list>
 * <set quantifier>    ::=   DISTINCT | ALL
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#group%20by%20clause
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/select.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/group_by_clause.html
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLGroupByClause extends AbstractSQLExpr {

    /**
     * true: Group By XX Having XX
     * false: Having XX Group By XX
     */
    protected boolean order = true;

    protected Type quantifier;

    protected final List<SQLGroupByItem> items = new ArrayList<>();

    protected boolean withRollup;

    protected SQLHavingClause havingClause;


    public SQLGroupByClause() {
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            if (order) {
                this.acceptChild(visitor, items);
                this.acceptChild(visitor, havingClause);
            } else {
                this.acceptChild(visitor, havingClause);
                this.acceptChild(visitor, items);
            }
        }
    }


    @Override
    public SQLGroupByClause clone() {
        SQLGroupByClause x = new SQLGroupByClause();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLGroupByClause x) {
        super.cloneTo(x);

        x.order = this.order;
        x.quantifier = this.quantifier;

        for (SQLGroupByItem item : this.items) {
            SQLGroupByItem itemClone = item.clone();
            x.addItem(itemClone);
        }

        x.withRollup = this.withRollup;

        if (this.havingClause != null) {
            SQLHavingClause havingClauseClone = this.havingClause.clone();
            x.setHavingClause(havingClauseClone);
        }

    }


    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public Type getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(Type quantifier) {
        this.quantifier = quantifier;
    }

    public List<SQLGroupByItem> getItems() {
        return items;
    }

    public void addItem(SQLGroupByItem item) {
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

    public SQLHavingClause getHavingClause() {
        return havingClause;
    }

    public void setHavingClause(SQLHavingClause havingClause) {
        setChildParent(havingClause);
        this.havingClause = havingClause;
    }


    public enum Type {
        DISTINCT(SQLReserved.DISTINCT), ALL(SQLReserved.ALL);

        public final SQLReserved name;

        Type(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public static class SQLGroupByItem extends AbstractSQLExpr {

        protected SQLExpr expr;

        public SQLGroupByItem(String name) {
            setExpr(SQLUtils.ofName(name));
        }

        public SQLGroupByItem(SQLExpr expr) {
            setExpr(expr);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public SQLGroupByItem clone() {
            SQLExpr exprClone = this.expr.clone();
            SQLGroupByItem x = new SQLGroupByItem(exprClone);
            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == expr) {

                if (target == null
                        && this.getParent() instanceof SQLGroupByClause) {
                    for (int i = ((SQLGroupByClause) this.getParent()).getItems().size() - 1; i >= 0; i--) {
                        if (((SQLGroupByClause) this.getParent()).getItems().get(i) == this) {
                            ((SQLGroupByClause) this.getParent()).getItems().remove(i);
                            return true;
                        }
                    }
                    return false;
                }

                this.setExpr(target);
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
    }


}
