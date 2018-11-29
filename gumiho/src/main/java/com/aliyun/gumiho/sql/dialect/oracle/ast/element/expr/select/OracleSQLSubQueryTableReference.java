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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSubqueryRestrictionClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSubQueryTableReference;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [LATERAL ] ( subQuery  subquery_restriction_clause)  [flashbackQueryClause]  [pivot]  [AS? alias]
 * Only  ( [LATERAL ] ( subQuery  subquery_restriction_clause)  ) [flashbackQueryClause]  [pivot]  [AS? alias]
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class OracleSQLSubQueryTableReference extends SQLSubQueryTableReference implements IOracleSQLTableReference {

    protected ISQLSubqueryRestrictionClause subQueryRestrictionClause;

    protected final List<OracleSQLFlashbackQueryClause> flashbackQueryClauses = new ArrayList<>();

    protected SQLExpr pivot;

    public OracleSQLSubQueryTableReference() {
    }

    public OracleSQLSubQueryTableReference(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            this.accept0((OracleSQLASTVisitor) visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
            this.acceptChild(visitor, subQueryRestrictionClause);
            this.acceptChild(visitor, flashbackQueryClauses);
            this.acceptChild(visitor, pivot);
            this.acceptChild(visitor, alias);
        }
    }

    @Override
    public OracleSQLSubQueryTableReference clone() {
        OracleSQLSubQueryTableReference x = new OracleSQLSubQueryTableReference();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(OracleSQLSubQueryTableReference x) {
        super.cloneTo(x);

    }


    public ISQLSubqueryRestrictionClause getSubQueryRestrictionClause() {
        return subQueryRestrictionClause;
    }

    public void setSubQueryRestrictionClause(ISQLSubqueryRestrictionClause subQueryRestrictionClause) {
        setChildParent(subQueryRestrictionClause);
        this.subQueryRestrictionClause = subQueryRestrictionClause;
    }

    public List<OracleSQLFlashbackQueryClause> getFlashbackQueryClauses() {
        return flashbackQueryClauses;
    }

    public void addFlashbackQueryClause(OracleSQLFlashbackQueryClause flashbackQueryClause) {
        if (flashbackQueryClause == null) {
            return;
        }
        setChildParent(flashbackQueryClause);
        this.flashbackQueryClauses.add(flashbackQueryClause);
    }

    public SQLExpr getPivot() {
        return pivot;
    }

    public void setPivot(SQLExpr pivot) {
        setChildParent(pivot);
        this.pivot = pivot;
    }


}
