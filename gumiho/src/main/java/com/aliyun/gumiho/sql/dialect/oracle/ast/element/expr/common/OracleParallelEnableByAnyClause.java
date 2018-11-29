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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * PARALLEL_ENABLE LEFT_PAREN PARTITION expr BY ANY  RIGHT_PAREN
 * <p>
 * https://docs.oracle.com/database/121/LNPLS/create_function.htm#GUID-B71BC5BD-B87C-4054-AAA5-213E856651F2__CIHJFAGA
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class OracleParallelEnableByAnyClause extends AbstractOracleSQLParallelEnableClause implements IOracleParallelEnableClause {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, argument);
        }
    }

    @Override
    public OracleParallelEnableByAnyClause clone() {
        OracleParallelEnableByAnyClause x = new OracleParallelEnableByAnyClause();
        this.cloneTo(x);
        return x;
    }
}
