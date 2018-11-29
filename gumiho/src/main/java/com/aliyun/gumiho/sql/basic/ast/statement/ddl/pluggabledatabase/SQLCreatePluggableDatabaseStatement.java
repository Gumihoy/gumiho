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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.pluggabledatabase;


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
 *
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-PLUGGABLE-DATABASE.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreatePluggableDatabaseStatement extends AbstractSQLStatement implements SQLCreateStatement {

    public SQLName name;
    protected final List<SQLExpr> actions = new ArrayList<>();

    public SQLCreatePluggableDatabaseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//            this.acceptChild(visitor, actions);
//        }
    }

    @Override
    public SQLStatement clone() {
        SQLCreatePluggableDatabaseStatement x = new SQLCreatePluggableDatabaseStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreatePluggableDatabaseStatement x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLExpr action : this.actions) {
            SQLExpr actionClone = action.clone();
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

        boolean replace = replaceInList(actions, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_PLUGGABLE_DATABASE;
    }


    public SQLName getName() {
        return name;
    }

    public SQLCreatePluggableDatabaseStatement setName(SQLName name) {
        setChildParent(name);
        this.name = name;
        return this;
    }

    public List<SQLExpr> getActions() {
        return actions;
    }

    public SQLCreatePluggableDatabaseStatement addAction(SQLExpr action) {
        if (action == null) {
            return this;
        }
        setChildParent(action);
        this.actions.add(action);
        return this;
    }
}
