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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * subQuery [ AS?  alias]  [ <left paren> <derived column list> <right paren> ]
 * <p>
 * Only (subQuery) [ AS?  alias]  [ <left paren> <derived column list> <right paren> ]
 * [LATERAL ] ( subQuery )
 * Only  ( [LATERAL ] ( subQuery  subquery_restriction_clause)  )
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20primary
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20reference
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/join.html
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLSubQueryTableReference extends AbstractSQLTableReference {

    protected boolean only;

    protected boolean lateral;

    protected ISQLSelectQuery subQuery;

    public SQLSubQueryTableReference() {
    }

    public SQLSubQueryTableReference(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    public SQLSubQueryTableReference(ISQLSelectQuery subQuery, String alias) {
        setSubQuery(subQuery);
        setAlias(alias);
    }

    public SQLSubQueryTableReference(ISQLSelectQuery subQuery,boolean as, String alias) {
        setSubQuery(subQuery);
        setAs(as);
        setAlias(alias);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
            this.acceptChild(visitor, alias);
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLSubQueryTableReference clone() {

        SQLSubQueryTableReference x = new SQLSubQueryTableReference();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLSubQueryTableReference x) {
        super.cloneTo(x);

        ISQLSelectQuery subQueryClone = this.subQuery.clone();
        x.setSubQuery(subQueryClone);

        x.as = this.as;

        SQLIdentifier aliasClone = this.alias;
        if (aliasClone != null) {
            x.setAlias(aliasClone);
        }

        for (SQLExpr derived : this.columns) {
            SQLExpr derivedClone = derived.clone();
            x.addColumn(derived);
        }

    }

    public boolean isOnly() {
        return only;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public boolean isLateral() {
        return lateral;
    }

    public void setLateral(boolean lateral) {
        this.lateral = lateral;
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }
}
