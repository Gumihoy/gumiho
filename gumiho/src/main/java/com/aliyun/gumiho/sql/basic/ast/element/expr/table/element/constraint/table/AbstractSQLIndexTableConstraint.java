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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * {INDEX|KEY} [index_name] [index_type] (key_part,...) [index_option] ...
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public abstract class AbstractSQLIndexTableConstraint extends AbstractSQLTableConstraint implements ISQLUniqueTableConstraint {

    protected SQLExpr indexName;
    protected final List<SQLColumn> columns = new ArrayList<>();

    @Override
    public AbstractSQLIndexTableConstraint clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLIndexTableConstraint x) {
        super.cloneTo(x);

        if (indexName != null) {
            SQLExpr indexNameClone = this.indexName.clone();
            x.setIndexName(indexNameClone);
        }

        for (SQLColumn column : this.columns) {
            SQLColumn columnClone = column.clone();
            x.addColumn(columnClone);
        }
    }

    public SQLExpr getIndexName() {
        return indexName;
    }

    public void setIndexName(SQLExpr indexName) {
        setChildParent(indexName);
        this.indexName = indexName;
    }

    public List<SQLColumn> getColumns() {
        return columns;
    }

    public void addColumn(SQLColumn column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

    public void addColumn(SQLExpr expr) {
        if (expr == null) {
            return;
        }
        SQLColumn column;
        if (expr instanceof SQLColumn) {
            column = (SQLColumn) expr;
        } else {
            column = SQLColumn.of(expr);
        }
        setChildParent(column);
        this.columns.add(column);
    }

}
