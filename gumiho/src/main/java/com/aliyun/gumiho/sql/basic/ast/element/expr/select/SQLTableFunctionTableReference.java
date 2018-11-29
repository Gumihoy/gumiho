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
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TABLE (expr) [(+)]
 * |
 * ONLY ( TABLE (expr) [(+)] )
 *
 * [ AS ] <correlation name> [ <left paren> <derived column list> <right paren> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20function%20derived%20table
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20primary
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20reference
 * <p>
 * table_collection_expression: https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLTableFunctionTableReference extends AbstractSQLTableReference {

    protected boolean only;

    protected SQLExpr expr;

    protected boolean outerJoin;


//    protected final List<OracleSQLFlashbackQueryClause> flashbackQueryClauses = new ArrayList<>();

    protected SQLExpr pivot;

    public SQLTableFunctionTableReference() {
    }

    public SQLTableFunctionTableReference(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
//            this.acceptChild(visitor, flashbackQueryClauses);
            this.acceptChild(visitor, pivot);
            this.acceptChild(visitor, alias);
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLTableFunctionTableReference clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLTableFunctionTableReference x = new SQLTableFunctionTableReference(exprClone);

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLTableFunctionTableReference x) {
        super.cloneTo(x);
    }


    public boolean isOnly() {
        return only;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public boolean isOuterJoin() {
        return outerJoin;
    }

    public void setOuterJoin(boolean outerJoin) {
        this.outerJoin = outerJoin;
    }

//    public List<OracleSQLFlashbackQueryClause> getFlashbackQueryClauses() {
//        return flashbackQueryClauses;
//    }
//
//    public void addFlashbackQueryClause(OracleSQLFlashbackQueryClause flashbackQueryClause) {
//        if (flashbackQueryClause == null) {
//            return;
//        }
//        setChildParent(flashbackQueryClause);
//        this.flashbackQueryClauses.add(flashbackQueryClause);
//    }

    public SQLExpr getPivot() {
        return pivot;
    }

    public void setPivot(SQLExpr pivot) {
        setChildParent(pivot);
        this.pivot = pivot;
    }
}
