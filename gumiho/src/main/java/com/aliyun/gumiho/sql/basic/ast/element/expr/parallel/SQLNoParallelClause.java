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
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NOPARALLEL
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses005.htm#SQLRF30009
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/parallel_clause.html#GUID-59C9EBF3-A45E-4EE5-ABE7-0DA0FCF6C4B5
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class SQLNoParallelClause extends AbstractSQLExpr implements ISQLParallelClause {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNoParallelClause clone() {
        return new SQLNoParallelClause();
    }
}
