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
package com.aliyun.gumiho.sql.basic.ast.element.function.aggreate;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#aggregate%20function
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Aggregate-Functions.html#GUID-62BE676B-AF18-4E63-BD14-25206FEA0848
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CUME_DIST.html#GUID-B12C577C-A63C-4D19-8E18-FCCBBFBF8278
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/FIRST.html#GUID-85AB9246-0E0A-44A1-A7E6-4E57502E9238
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLAggregateFunction extends AbstractSQLAggregateFunction {

    public SQLAggregateFunction(String name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, arguments);

            this.acceptChild(visitor, partitionClause);
            this.acceptChild(visitor, orderByClause);

            this.acceptChild(visitor, withinGroup);
            this.acceptChild(visitor, filterClause);
            this.acceptChild(visitor, overClause);
        }
    }


    @Override
    public AbstractSQLAggregateFunction clone() {
        return super.clone();
    }

}
