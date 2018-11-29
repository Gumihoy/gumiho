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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema;


import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLCreateDatabaseStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE SCHEMA [IF NOT EXISTS] db_name [create_specification] ...
 * create_specification: [DEFAULT] CHARACTER SET [=] charset_name | [DEFAULT] COLLATE [=] collation_name
 * https://dev.mysql.com/doc/refman/5.7/en/create-database.html
 *
 *
 * CREATE SCHEMA AUTHORIZATION schema { create_table_statement | create_view_statement | grant_statement }...
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-SCHEMA.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateSchemaStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean ifNotExists;
    protected SQLName name;
    protected final List<SQLObject> actions = new ArrayList<>();


    public SQLCreateSchemaStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, actions);
        }
    }

    @Override
    public SQLCreateSchemaStatement clone() {
        SQLCreateSchemaStatement x = new SQLCreateSchemaStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLCreateSchemaStatement x) {
        super.cloneTo(x);

        x.ifNotExists = this.ifNotExists;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLObject action : this.actions) {
            SQLObject actionClone = action.clone();
            x.addAction(actionClone);
        }

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName)target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_SCHEMA;
    }


    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public SQLCreateSchemaStatement setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
        return this;
    }

    public SQLName getName() {
        return name;
    }

    public SQLCreateSchemaStatement setName(SQLName name) {
        setChildParent(name);
        this.name = name;
        return this;
    }

    public List<SQLObject> getActions() {
        return actions;
    }
    public SQLCreateSchemaStatement addAction(SQLObject action) {
        if (action == null) {
            return this;
        }
        setChildParent(action);
        this.actions.add(action);
        return this;
    }
}
