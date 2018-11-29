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

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#order%20by%20clause
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLSelectItem extends AbstractSQLExpr {

    private SQLExpr expr;

    private boolean as;

    private SQLExpr alias;

    public SQLSelectItem() {
    }

    public SQLSelectItem(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, alias);
        }
    }

    @Override
    public SQLSelectItem clone() {
        SQLSelectItem x = new SQLSelectItem();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLSelectItem x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        x.as = this.as;

        if (this.alias != null) {
            SQLExpr aliasClone = this.alias.clone();
            x.setAlias(aliasClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            this.setExpr(target);
            return true;
        }

        if (source == alias) {
            this.setAlias(target);
            return true;
        }

        return false;
    }

    public boolean match(SQLExpr expr) {
        if (expr == null) {
            return false;
        }

        boolean match = SQLUtils.equalsIgnoreCase(alias, expr, false);
        if (match) {
            return true;
        }

        match = SQLUtils.equalsIgnoreCase(this.expr, expr, false);
        if (match) {
            return true;
        }

        return false;
    }

    public boolean match(long hash) {
        if (alias instanceof SQLName
                && ((SQLName) alias).lowerHash() == hash) {
            return true;
        }

        if (expr instanceof SQLName
                && ((SQLName) expr).lowerHash() == hash) {
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

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public SQLExpr getAlias() {
        return alias;
    }

    public void setAlias(SQLExpr alias) {
        setChildParent(alias);
        this.alias = alias;
    }
}
