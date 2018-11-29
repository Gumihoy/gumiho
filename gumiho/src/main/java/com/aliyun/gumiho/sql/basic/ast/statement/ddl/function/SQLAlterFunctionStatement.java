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


import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *ALTER FUNCTION [ schema. ] function_name { function_compile_clause | EDITIONABLE | NONEDITIONABLE } ;
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-FUNCTION-statement.html#GUID-C78E0E7E-6BCF-4AE8-8C75-9F133E8FB4E1
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterFunctionStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected SQLName name;

    protected SQLExpr option;

    public SQLAlterFunctionStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, option);
        }
    }

    @Override
    public SQLAlterFunctionStatement clone() {
        SQLAlterFunctionStatement x = new SQLAlterFunctionStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterFunctionStatement x) {
        super.cloneTo(x);
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.option != null) {
            SQLExpr optionClone = this.option.clone();
            x.setOption(optionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_FUNCTION;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getOption() {
        return option;
    }

    public void setOption(SQLExpr option) {
        setChildParent(option);
        this.option = option;
    }
}
