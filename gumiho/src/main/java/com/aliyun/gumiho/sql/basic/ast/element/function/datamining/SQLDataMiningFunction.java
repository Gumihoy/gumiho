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
package com.aliyun.gumiho.sql.basic.ast.element.function.datamining;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * functionName ( [argument]... [costMatrixClause] mining_attribute_clause [AND mining_attribute_clause])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Single-Row-Functions.html#GUID-B3E664DC-2675-4AC7-885B-B9AB287CF76F
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLDataMiningFunction extends AbstractSQLDataMiningFunction {

    public SQLDataMiningFunction(String name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, costMatrixClause);
            this.acceptChild(visitor, miningAttributeClause);
            this.acceptChild(visitor, andMiningAttributeClause);
        }
    }


}
