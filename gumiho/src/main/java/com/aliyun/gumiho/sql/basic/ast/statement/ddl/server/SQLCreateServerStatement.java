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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.server;


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
 * CREATE SERVER server_name FOREIGN DATA WRAPPER wrapper_name OPTIONS (option [, option] ...)
 * <p>
 * option: { HOST character-literal | DATABASE character-literal | USER character-literal | PASSWORD character-literal | SOCKET character-literal | OWNER character-literal | PORT numeric-literal }
 * https://dev.mysql.com/doc/refman/8.0/en/create-server.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateServerStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLName name;
    protected SQLName wrapper;
    protected final List<SQLExpr> options = new ArrayList<>();

    public SQLCreateServerStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, wrapper);
            this.acceptChild(visitor, options);
        }
    }


    @Override
    public SQLStatement clone() {
        return null;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == wrapper
                && target instanceof SQLName) {
            setWrapper((SQLName) target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_SERVER;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLName getWrapper() {
        return wrapper;
    }

    public void setWrapper(SQLName wrapper) {
        setChildParent(wrapper);
        this.wrapper = wrapper;
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
