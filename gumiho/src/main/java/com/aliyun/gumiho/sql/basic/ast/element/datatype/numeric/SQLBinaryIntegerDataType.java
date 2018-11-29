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
package com.aliyun.gumiho.sql.basic.ast.element.datatype.numeric;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * BINARY_INTEGER
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/plsql-data-types.html#GUID-9517B7AC-9CEA-4C36-A454-52588BEEBE8F
 *
 * @author kongtong.ouyang onCondition 2018/3/11.
 */
public class SQLBinaryIntegerDataType extends AbstractSQLNumericDataType {

    public SQLBinaryIntegerDataType() {
        super(SQLReserved.BINARY_INTEGER.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }


}