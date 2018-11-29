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

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * exception_declaration
 *
 * exception EXCEPTION;
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/exception-declaration.html#GUID-AAC8C54F-775C-4E65-B531-0350CFF5B1BD
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/exception-declaration.html#GUID-AAC8C54F-775C-4E65-B531-0350CFF5B1BD
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSQLExceptionDeclaration extends AbstractOracleSQLExpr {

    private SQLName name;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }


    @Override
    public OracleSQLExceptionDeclaration clone() {
        OracleSQLExceptionDeclaration x = new OracleSQLExceptionDeclaration();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(OracleSQLExceptionDeclaration x) {
        super.cloneTo(x);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}
