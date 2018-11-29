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
package com.aliyun.gumiho.sql.basic.ast.element.function.json;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ( expr [ FORMAT JSON ] [, expr [ FORMAT JSON ] ]...
 * [ JSON_on_null_clause ] [ JSON_returning_clause ]
 * [STRICT] [WITH UNIQUE KEYS]
 * [ JSON_query_wrapper_clause ] [ JSON_query_on_error_clause ]
 * [ JSON_query_on_empty_clause ] [JSON_columns_clause])
 * <p>
 * onNullClause: { NULL | ABSENT } ON NULL
 * wrapperClause: {WITHOUT [ ARRAY ] WRAPPER | WITH [ UNCONDITIONAL | CONDITIONAL ] [ ARRAY ] WRAPPER}
 * onErrorClause: { ERROR | NULL | DEFAULT literal } ON ERROR
 * onEmptyClause: { ERROR | NULL | DEFAULT literal } ON EMPTY
 * JSON_columns_clause: COLUMNS ( JSON_column_definition [, JSON_column_definition ]... )
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Single-Row-Functions.html#GUID-C13171B3-C070-4137-AC71-7A30BD26F380
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLJsonFunction extends AbstractSQLJsonFunction {

    public SQLJsonFunction(String name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, returningClause);
            this.acceptChild(visitor, onErrorClause);
            this.acceptChild(visitor, onEmptyClause);
            this.acceptChild(visitor, jsonColumnsClause);
        }
    }


}
