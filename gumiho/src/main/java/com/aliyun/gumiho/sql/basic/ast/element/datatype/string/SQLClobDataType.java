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
package com.aliyun.gumiho.sql.basic.ast.element.datatype.string;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CLOB [ <left paren> <large object length> <right paren> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#character%20string%20type
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-7B72E154-677A-4342-A1EA-C74C1EA928E6
 *
 * @author kongtong.ouyang onCondition 2018/3/11.
 */
public class SQLClobDataType extends AbstractSQLTextDataType {

    public SQLClobDataType() {
        super(SQLReserved.CLOB.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }
}