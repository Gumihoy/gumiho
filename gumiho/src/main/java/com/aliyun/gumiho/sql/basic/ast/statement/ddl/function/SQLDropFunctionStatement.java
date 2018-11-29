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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.function;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLParameterDeclaration;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCascadeType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP FUNCTION [IF EXISTS] function_name  [(parameters)]  [ CASCADE | RESTRICT ]
 * <p>
 * https://www.postgresql.org/docs/current/static/sql-dropfunction.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/DROP-FUNCTION-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropFunctionStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists;

    protected SQLName name;

    protected final List<SQLParameterDeclaration> parameters = new ArrayList<>();

    protected SQLCascadeType option;


    public SQLDropFunctionStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
        }
    }

    @Override
    public SQLDropFunctionStatement clone() {
        SQLDropFunctionStatement x = new SQLDropFunctionStatement(this.dbType);
        cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropFunctionStatement x) {
        super.cloneTo(x);

        x.setIfExists(this.ifExists);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLParameterDeclaration parameter : x.parameters) {
            SQLParameterDeclaration parameterClone = parameter.clone();
            x.addParameter(parameterClone);
        }

        x.setOption(this.option);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_FUNCTION;
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
        this.name = name;
    }

    public List<SQLParameterDeclaration> getParameters() {
        return parameters;
    }

    public void addParameter(SQLParameterDeclaration parameter) {
        if (parameter == null) {
            return;
        }
        setChildParent(parameter);
        this.parameters.add(parameter);
    }

    public SQLCascadeType getOption() {
        return option;
    }

    public void setOption(SQLCascadeType option) {
        this.option = option;
    }
}
