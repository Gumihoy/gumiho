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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#alter%20sequence%20generator%20statement
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterSequenceStatement extends AbstractSQLStatement implements SQLAlterStatement {


    protected boolean ifExists = false;

    protected SQLName name;

    // --------- options ------------------

    protected final List<SQLObject> options = new ArrayList<>();


    public SQLAlterSequenceStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, options);
        }
    }


    @Override
    public SQLAlterSequenceStatement clone() {
        SQLAlterSequenceStatement x = new SQLAlterSequenceStatement(this.dbType);
        cloneTo(x);
        return x;
    }


    public void cloneTo(SQLAlterSequenceStatement x) {
        super.cloneTo(x);

        x.setIfExists(this.ifExists);

        SQLName cloneName = this.name.clone();
        x.setName(cloneName);

        for (SQLObject option : this.options) {
            SQLObject cloneOption = option.clone();
            x.addOption(cloneOption);
        }

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_SEQUENCE;
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

    public List<SQLObject> getOptions() {
        return options;
    }

    public void addOption(SQLObject option) {
        if (option == null) {
            return;
        }

        option.setParent(this);
        this.options.add(option);
    }

}
