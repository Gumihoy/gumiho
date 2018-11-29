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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * HANDLER tbl_name OPEN [ [AS] alias]
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/handler.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLHandlerOpenStatement extends AbstractSQLHandlerStatement {

    protected boolean as;
    protected SQLName alias;

    public SQLHandlerOpenStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, alias);
        }
    }

    @Override
    public SQLHandlerOpenStatement clone() {
        SQLHandlerOpenStatement x = new SQLHandlerOpenStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLHandlerOpenStatement x) {
        x.as = this.as;

        if (this.alias != null) {
            SQLName aliasClone = this.alias.clone();
            x.setAlias(aliasClone);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.HANDLER;
    }

    public boolean isAs() {
        return as;
    }

    public SQLHandlerOpenStatement setAs(boolean as) {
        this.as = as;
        return this;
    }

    public SQLName getAlias() {
        return alias;
    }

    public SQLHandlerOpenStatement setAlias(SQLName alias) {
        setChildParent(alias);
        this.alias = alias;
        return this;
    }
}
