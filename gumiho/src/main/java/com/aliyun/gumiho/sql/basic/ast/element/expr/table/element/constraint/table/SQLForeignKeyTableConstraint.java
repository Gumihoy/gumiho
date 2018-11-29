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
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.AbstractSQLReferencesConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * FOREIGN KEY <left paren> <referencing columns> <right paren>  REFERENCES <referenced table and columns> [ MATCH <match type> ] [ <referential triggered action> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#referential%20constraint%20definition
 * <p>
 * [CONSTRAINT [symbol]] FOREIGN KEY [index_name] (key_part,...) reference_definition
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 * <p>
 * [ CONSTRAINT constraint_name ] FOREIGN KEY referencingColumns=(column [, column ]...) REFERENCES referencedTable=[ schema. ] object referencedColumns=[ (column [, column ]...) ] [ON DELETE { CASCADE | SET NULL } ] [ constraint_state ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLForeignKeyTableConstraint extends AbstractSQLReferencesConstraint implements ISQLForeignKeyTableConstraint {

    protected SQLExpr indexName;

    protected final List<SQLColumn> referencingColumns = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, referencingColumns);
            this.acceptChild(visitor, referencedTable);
            this.acceptChild(visitor, referencedColumns);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLForeignKeyTableConstraint clone() {
        SQLForeignKeyTableConstraint x = new SQLForeignKeyTableConstraint();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLForeignKeyTableConstraint x) {
        super.cloneTo(x);

        if (this.indexName != null) {
            SQLExpr indexNameClone = indexName.clone();
            x.setIndexName(indexNameClone);
        }
    }


    public SQLExpr getIndexName() {
        return indexName;
    }

    public void setIndexName(SQLExpr indexName) {
        setChildParent(indexName);
        this.indexName = indexName;
    }

    public List<SQLColumn> getReferencingColumns() {
        return referencingColumns;
    }

    public void addReferencingColumn(SQLColumn referencingColumn) {
        if (referencingColumn == null) {
            return;
        }
        setChildParent(referencingColumn);
        this.referencingColumns.add(referencingColumn);
    }

    public void addReferencingColumn(SQLExpr expr) {
        if (expr == null) {
            return;
        }
        SQLColumn referencingColumn;
        if (expr instanceof SQLColumn) {
            referencingColumn = (SQLColumn)expr;
        } else {
            referencingColumn = SQLColumn.of(expr);
        }
        setChildParent(referencingColumn);
        this.referencingColumns.add(referencingColumn);
    }
}
