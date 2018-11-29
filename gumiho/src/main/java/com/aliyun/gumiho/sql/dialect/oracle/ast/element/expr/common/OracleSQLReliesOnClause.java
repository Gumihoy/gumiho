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

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * https://docs.oracle.com/database/121/LNPLS/function.htm#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C__CJADHAHB
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class OracleSQLReliesOnClause extends AbstractOracleSQLExpr implements OracleSQLElementStatement {


//    private List<>


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {

    }

    @Override
    public OracleSQLReliesOnClause clone() {
        return null;
    }


}
