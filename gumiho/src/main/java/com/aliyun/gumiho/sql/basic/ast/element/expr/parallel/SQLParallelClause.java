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
package com.aliyun.gumiho.sql.basic.ast.element.expr.parallel;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARALLEL [ integer ]
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses005.htm#SQLRF30009
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class SQLParallelClause extends AbstractSQLExpr implements ISQLParallelClause {

    protected SQLExpr value;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }


    @Override
    public SQLParallelClause clone() {
        SQLParallelClause x = new SQLParallelClause();

        if (this.value != null) {
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
        }
        return x;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
