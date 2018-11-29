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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/3/10.
 * @see {https://docs.oracle.com/database/121/SQLRF/statements_5005.htm#SQLRF01204}
 */
public class OracleSQLUserSystemClause extends AbstractOracleSQLExpr {

    public SQLIdentifier password;

    public OracleSQLUserSystemClause(SQLIdentifier password) {
        this.password = password;
    }

    @Override
    public OracleSQLUserSystemClause clone() {
        return null;
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }


}
