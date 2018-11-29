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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.database;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE DATABASE [IF NOT EXISTS] db_name [create_specification] ...
 * create_specification: [DEFAULT] CHARACTER SET [=] charset_name | [DEFAULT] COLLATE [=] collation_name
 * https://dev.mysql.com/doc/refman/5.7/en/create-database.html
 * <p>
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-DATABASE.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateDatabaseStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean ifNotExists;
    public SQLName name;
    protected final List<SQLExpr> items = new ArrayList<>();

    public SQLCreateDatabaseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLStatement clone() {
        SQLCreateDatabaseStatement x = new SQLCreateDatabaseStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateDatabaseStatement x) {
        super.cloneTo(x);

        x.ifNotExists = this.ifNotExists;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName)target);
            return true;
        }

        boolean replace = replaceInList(items, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_DATABASE;
    }


    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public SQLCreateDatabaseStatement setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
        return this;
    }

    public SQLName getName() {
        return name;
    }

    public SQLCreateDatabaseStatement setName(SQLName name) {
        setChildParent(name);
        this.name = name;
        return this;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
