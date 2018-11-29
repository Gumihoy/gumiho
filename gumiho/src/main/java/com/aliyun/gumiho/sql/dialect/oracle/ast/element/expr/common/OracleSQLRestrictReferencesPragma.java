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
 * restrict_references_pragma
 * PRAGMA RESTRICT_REFERENCES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN SEMI
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/RESTRICT_REFERENCES-pragma.html#GUID-D189A0B4-D0D3-4951-BFC2-7D996F1659FE
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/RESTRICT_REFERENCES-pragma.html#GUID-D189A0B4-D0D3-4951-BFC2-7D996F1659FE
 */
public class OracleSQLRestrictReferencesPragma extends AbstractOracleSQLPragma implements OracleSQLPragma {


    public OracleSQLRestrictReferencesPragma() {
        setAfterSemi(true);
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public OracleSQLRestrictReferencesPragma clone() {
        OracleSQLRestrictReferencesPragma x = new OracleSQLRestrictReferencesPragma();
        this.cloneTo(x);
        return x;
    }


}
