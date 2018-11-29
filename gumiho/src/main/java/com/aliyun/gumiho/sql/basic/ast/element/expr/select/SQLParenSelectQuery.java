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

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ( query ) [orderByClause] [limitClause]
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class SQLParenSelectQuery extends AbstractSQLSelectQuery implements ISQLSelectQuery {

    private ISQLSelectQuery query;


    public SQLParenSelectQuery(ISQLSelectQuery query) {
        setQuery(query);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, query);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
        }
    }

    @Override
    public SQLParenSelectQuery clone() {
        ISQLSelectQuery queryClone = query.clone();
        SQLParenSelectQuery x = new SQLParenSelectQuery(queryClone);

        super.cloneTo(x);

        return x;
    }


    public ISQLSelectQuery getQuery() {
        return query;
    }

    public void setQuery(ISQLSelectQuery query) {
        setChildParent(query);
        this.query = query;
    }
}
