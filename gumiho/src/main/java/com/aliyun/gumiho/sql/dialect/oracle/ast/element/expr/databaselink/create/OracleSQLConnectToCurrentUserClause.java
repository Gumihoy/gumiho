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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 *
 * CONNECT TO CURRENT_USER
 *
 * https://docs.oracle.com/database/121/SQLRF/statements_5006.htm#SQLRF01205
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-DATABASE-LINK.html
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLConnectToCurrentUserClause extends AbstractOracleSQLExpr {


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLConnectToCurrentUserClause clone() {
        return new OracleSQLConnectToCurrentUserClause();
    }


}
