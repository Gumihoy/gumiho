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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select.group;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#having%20clause
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLHavingClause extends AbstractSQLExpr {

    protected SQLExpr condition;

    public SQLHavingClause(SQLExpr condition) {
        setCondition(condition);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
        }
    }

    @Override
    public SQLHavingClause clone() {
        SQLExpr conditionClone = this.condition.clone();
        SQLHavingClause x = new SQLHavingClause(conditionClone);
        this.cloneTo(x);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == condition) {
            this.setCondition(target);
            if (target == null) {
                SQLUtils.replaceInParent(this, null);
            }
            return true;
        }
        return false;
    }


    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }
}
