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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure;


import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * ALTER PROCEDURE [ schema. ] procedure_name { procedure_compile_clause | { EDITIONABLE | NONEDITIONABLE } } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-PROCEDURE-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterProcedureStatement extends AbstractSQLStatement implements SQLAlterStatement {

    private SQLName name;

    public SQLAlterProcedureStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    public SQLStatement clone() {
        return null;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_PROCEDURE;
    }



    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}
