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
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/SERIALLY_REUSABLE-pragma.html#GUID-35B02603-B794-403C-9E0D-E40208CEAF35
 */
public class OracleSQLSeriallyReusablePragma extends AbstractOracleSQLPragma implements OracleSQLPragma {


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public OracleSQLSeriallyReusablePragma clone() {
        OracleSQLSeriallyReusablePragma x = new OracleSQLSeriallyReusablePragma();
        this.cloneTo(x);
        return x;
    }
}
