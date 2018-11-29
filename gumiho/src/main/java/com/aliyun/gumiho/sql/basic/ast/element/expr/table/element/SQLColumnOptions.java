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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#column%20options
 *
 * @author kongtong.ouyang onCondition 2018/3/28.
 */
public class SQLColumnOptions extends AbstractSQLExpr implements SQLTableElement {

    protected SQLName columnName;

    protected SQLName scopeTableName;

    protected SQLExpr defaultExpr;

    protected final List<ISQLColumnConstraint> columnConstraints = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLColumnOptions clone() {
        SQLColumnOptions x = new SQLColumnOptions();
        return x;
    }


    public SQLName getColumnName() {
        return columnName;
    }

    public void setColumnName(SQLName columnName) {
        this.columnName = columnName;
    }

    public SQLName getScopeTableName() {
        return scopeTableName;
    }

    public void setScopeTableName(SQLName scopeTableName) {
        this.scopeTableName = scopeTableName;
    }

    public SQLExpr getDefaultExpr() {
        return defaultExpr;
    }

    public void setDefaultExpr(SQLExpr defaultExpr) {
        this.defaultExpr = defaultExpr;
    }

    public List<ISQLColumnConstraint> getColumnConstraints() {
        return columnConstraints;
    }
}
