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
package com.aliyun.gumiho.sql.basic.ast.element.datatype;


import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSQLDataType extends AbstractSQLExpr implements SQLDataType {

    protected String name;
    protected SQLName nameExpr;
    protected boolean paren = false;
    protected final List<SQLExpr> arguments = new ArrayList<SQLExpr>();


    public AbstractSQLDataType() {
    }

    public AbstractSQLDataType(String name) {
        setName(name);
    }

    public AbstractSQLDataType(SQLName name) {
        setName(name);
    }

    @Override
    public SQLDataType clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLDataType x) {
        super.cloneTo(x);

        SQLName nameClone = nameExpr.clone();
        x.setName(nameClone);

        x.setParen(this.paren);

        for (SQLExpr argument : this.arguments) {
            SQLExpr argumentClone = argument.clone();
            x.addArgument(argumentClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == nameExpr
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        boolean replace = replaceInList(arguments, source, target, this);
        if (replace) {
            return true;
        }
        return false;
    }

    @Override
    public long hash() {
        return nameExpr.hash();
    }

    @Override
    public long lowerHash() {
        return nameExpr.lowerHash();
    }

    @Override
    public String getName() {
        if (name == null) {
            name = nameExpr.getFullName();
        }
        return name;
    }

    @Override
    public SQLName getNameExpr() {
        return nameExpr;
    }

    public void setName(String name) {
        setName(SQLUtils.ofName(name));
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = null;
        this.nameExpr = name;
    }


    @Override
    public boolean isParen() {
        return paren;
    }

    @Override
    public void setParen(boolean paren) {
        this.paren = paren;
    }

    @Override
    public List<SQLExpr> getArguments() {
        return arguments;
    }

    @Override
    public void addArgument(SQLExpr argument) {
        if (argument == null) {
            return;
        }
        if (!this.paren) {
            setParen(true);
        }
        argument.setParent(this);
        this.arguments.add(argument);
    }

}
