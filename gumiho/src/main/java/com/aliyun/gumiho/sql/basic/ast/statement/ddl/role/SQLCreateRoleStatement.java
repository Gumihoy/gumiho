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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.role;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE ROLE <role name> [ WITH ADMIN <grantor> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#role%20definition
 *
 *
 * CREATE ROLE [IF NOT EXISTS] role [, role ] ...
 * https://dev.mysql.com/doc/refman/8.0/en/create-role.html
 * <p>
 * CREATE ROLE role [ NOT IDENTIFIED | IDENTIFIED { BY password | USING [ schema. ] package | EXTERNALLY | GLOBALLY AS domain_name_of directory_group } ] [ CONTAINER = { CURRENT | ALL } ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-ROLE.html
 *
 * @author kongtong.ouyang on 2018/1/23.
 */
public class SQLCreateRoleStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean ifNotExists;

    protected final List<SQLName> names = new ArrayList<>();

    protected SQLExpr auth;

    protected final List<SQLExpr> options = new ArrayList<>();



    public SQLCreateRoleStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
            this.acceptChild(visitor, auth);
        }
    }


    @Override
    public SQLCreateRoleStatement clone() {
        SQLCreateRoleStatement x = new SQLCreateRoleStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateRoleStatement x) {
        super.cloneTo(x);
    }



    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_ROLE;
    }



    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public List<SQLName> getNames() {
        return names;
    }

    public void addName(SQLName name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }

    public SQLExpr getAuth() {
        return auth;
    }

    public void setAuth(SQLExpr auth) {
        setChildParent(auth);
        this.auth = auth;
    }

    public List<SQLExpr> getOptions() {
        return options;
    }

    public void addOption(SQLExpr option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }



}
