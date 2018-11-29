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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/plsql-language-fundamentals.html#GUID-D6EFD7E8-39DF-4430-B625-B6D37E49F6F4
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public abstract class AbstractOracleSQLPragma extends AbstractOracleSQLExpr implements OracleSQLPragma {

    protected final List<SQLExpr> arguments = new ArrayList<>();

    public AbstractOracleSQLPragma() {
    }

    @Override
    public AbstractOracleSQLPragma clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLPragma x) {
        super.cloneTo(x);

        for (SQLExpr argument : arguments) {
            SQLExpr argumentClone = argument.clone();
            x.addArgument(argumentClone);
        }
    }

    public List<SQLExpr> getArguments() {
        return arguments;
    }

    public void addArgument(SQLExpr argument) {
        if (argument == null) {
            return;
        }
        setChildParent(argument);
        this.arguments.add(argument);
    }
}
