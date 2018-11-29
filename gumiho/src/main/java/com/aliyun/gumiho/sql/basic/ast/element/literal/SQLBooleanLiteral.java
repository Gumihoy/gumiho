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
package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * Boolean Literals
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#boolean%20literal
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00221
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLBooleanLiteral extends AbstractSQLExpr implements SQLLiteral {

    public Boolean value;

    public SQLBooleanLiteral() {
    }

    public SQLBooleanLiteral(Boolean value) {
        this.value = value;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBooleanLiteral clone() {
        SQLBooleanLiteral x = new SQLBooleanLiteral();

        x.value = this.value;
        return x;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
