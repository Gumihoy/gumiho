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
 * UNNEST <left paren> <collection value expression> <right paren> [ WITH ORDINALITY ]
 * [ AS ] <correlation name> [ <left paren> <derived column list> <right paren> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#collection%20derived%20table
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20primary
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20reference
 * <p>
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLUnNestFunctionTableReference extends AbstractSQLTableReference {

    protected SQLExpr expr;

    protected boolean withOrdinality;

    public SQLUnNestFunctionTableReference() {
    }

    public SQLUnNestFunctionTableReference(SQLExpr expr) {
        this.expr = expr;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, alias);
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLUnNestFunctionTableReference clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLUnNestFunctionTableReference x = new SQLUnNestFunctionTableReference(exprClone);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLUnNestFunctionTableReference x) {
        super.cloneTo(x);

        x.withOrdinality = this.withOrdinality;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public boolean isWithOrdinality() {
        return withOrdinality;
    }

    public void setWithOrdinality(boolean withOrdinality) {
        this.withOrdinality = withOrdinality;
    }
}
