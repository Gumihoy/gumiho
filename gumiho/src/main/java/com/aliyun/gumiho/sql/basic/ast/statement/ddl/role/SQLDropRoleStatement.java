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


import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP ROLE <role name>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#drop%20role%20statement
 * <p>
 * DROP ROLE [IF EXISTS] role [, role ] ...
 * https://dev.mysql.com/doc/refman/8.0/en/drop-role.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropRoleStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists;

    protected final List<SQLName> names = new ArrayList<>();


    public SQLDropRoleStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }


    @Override
    public SQLDropRoleStatement clone() {
        SQLDropRoleStatement x = new SQLDropRoleStatement(DBType.Oracle);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropRoleStatement x) {
        super.cloneTo(x);

        x.ifExists = this.ifExists;

        for (SQLName name : names) {
            SQLName nameClone = name.clone();
            x.addName(nameClone);
        }
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_ROLE;
    }




    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
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
}
