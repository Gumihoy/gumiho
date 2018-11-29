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
 * autonomous_trans_pragma
 * <p>
 * PRAGMA AUTONOMOUS_TRANSACTION ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/AUTONOMOUS_TRANSACTION-pragma.html#GUID-AD33D949-081B-4CD3-A240-C29773E908C3
 */
public class OracleSQLAutonomousTransPragma extends AbstractOracleSQLPragma implements OracleSQLPragma {

    public OracleSQLAutonomousTransPragma() {
        setAfterSemi(true);
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLAutonomousTransPragma clone() {
        OracleSQLAutonomousTransPragma x = new OracleSQLAutonomousTransPragma();
        this.cloneTo(x);
        return x;
    }
}
