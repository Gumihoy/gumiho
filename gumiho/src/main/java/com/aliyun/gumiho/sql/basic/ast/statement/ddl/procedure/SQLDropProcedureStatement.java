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


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * DROP PROCEDURE [IF EXISTS]  procedure ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/DROP-PROCEDURE-statement.html#GUID-A66E96E6-A582-4A59-B97E-8E6EA52EC292
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropProcedureStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists;

    private SQLName name;

    public SQLDropProcedureStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLDropProcedureStatement clone() {
        SQLDropProcedureStatement x = new SQLDropProcedureStatement(this.dbType);

        x.ifExists = this.ifExists;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }

        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_PROCEDURE;
    }



    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
