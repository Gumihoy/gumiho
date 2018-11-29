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
package com.aliyun.gumiho.sql.basic.ast.element.expr.update;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * SET expr = expr (, expr = expr)...
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/UPDATE.html#GUID-027A462D-379D-4E35-8611-410F3AC8FDA5
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLUpdateSetClause extends AbstractSQLExpr implements ISQLUpdateSetClause {

    protected final List<SQLUpdateSetItemClause> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLUpdateSetClause clone() {
        SQLUpdateSetClause x = new SQLUpdateSetClause();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLUpdateSetClause x) {
        super.cloneTo(x);

        for (SQLUpdateSetItemClause item : items) {
            SQLUpdateSetItemClause itemClone = item.clone();
            x.addItem(itemClone);
        }
    }

    public List<SQLUpdateSetItemClause> getItems() {
        return items;
    }

    public void addItem(SQLUpdateSetItemClause item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    /**
     * column = value
     */
    public static class SQLUpdateSetItemClause extends AbstractSQLExpr {
        protected SQLExpr column;
        protected SQLExpr value;

        public SQLUpdateSetItemClause() {
        }

        public SQLUpdateSetItemClause(SQLExpr column, SQLExpr value) {
            setColumn(column);
            setValue(value);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, column);
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public SQLUpdateSetItemClause clone() {
            SQLUpdateSetItemClause x = new SQLUpdateSetItemClause();

            this.cloneTo(x);
            return x;
        }

        public void cloneTo(SQLUpdateSetItemClause x) {
            super.cloneTo(x);

            SQLExpr columnClone = this.column.clone();
            x.setColumn(columnClone);

            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == column) {
                this.setColumn(target);
                return true;
            }

            if (source == value) {
                this.setValue(target);
                return true;
            }

            return false;
        }

        public SQLExpr getColumn() {
            return column;
        }

        public void setColumn(SQLExpr column) {
            setChildParent(column);
            this.column = column;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }
}
