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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLForUpdateClause;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#query%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLSelectStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected ISQLSelectQuery query;

    public SQLSelectStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, this.query);
        }
    }

    @Override
    public SQLSelectStatement clone() {
        SQLSelectStatement x = new SQLSelectStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLSelectStatement x) {
        super.cloneTo(x);
        ISQLSelectQuery queryClone = this.query.clone();
        x.setQuery(queryClone);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == query
                && target instanceof ISQLSelectQuery) {
            this.setQuery((ISQLSelectQuery) target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SELECT;
    }


    public ISQLSelectQuery getQuery() {
        return query;
    }

    public void setQuery(ISQLSelectQuery query) {
        setChildParent(query);
        this.query = query;
    }

}
