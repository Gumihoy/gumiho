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
package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * WHERE condition
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#where%20clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLWhereClause extends AbstractSQLExpr {

    protected SQLExpr condition;

    public SQLWhereClause() {
    }

    public SQLWhereClause(SQLExpr condition) {
        setCondition(condition);
    }

    public static SQLWhereClause of(SQLExpr condition) {
        return new SQLWhereClause(condition);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
        }
    }

    @Override
    public SQLWhereClause clone() {
        SQLWhereClause x = new SQLWhereClause();
        this.cloneTo(x);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == condition) {
            this.setCondition(target);
            return true;
        }
        return false;
    }

    public void andCondition(SQLExpr condition) {
        if (condition == null) {
            return;
        }
        condition = SQLBinaryOperatorExpr.and(this.condition, condition);
        setCondition(condition);
    }

    public void orCondition(SQLExpr condition) {
        if (condition == null) {
            return;
        }
        condition = SQLBinaryOperatorExpr.or(this.condition, condition);
        setCondition(condition);
    }

    public void SQLWhereClause(SQLWhereClause x) {
        super.cloneTo(x);
        SQLExpr conditionClone = this.condition.clone();
        x.setCondition(conditionClone);
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
        if (condition == null) {
            SQLUtils.replaceInParent(this, null);
        }
    }
}
