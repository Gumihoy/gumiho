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
package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * OPEN cursor [ ( cursor_parameter [ [,] actual_cursor_parameter ]... ) ] ;
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#open%20statement
 * <p>
 * <p>
 * OPEN cursor [ ( cursor_parameter [ [,] actual_cursor_parameter ]... ) ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/OPEN-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/3/14.
 */
public class SQLOpenStatement extends AbstractSQLStatement {

    protected SQLExpr name;

    protected final List<SQLExpr> parameters = new ArrayList<>();


    public SQLOpenStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
        }
    }


    @Override
    public SQLStatement clone() {
        SQLOpenStatement x = new SQLOpenStatement(this.dbType);
        this.cloneTo(x);

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLExpr parameter : this.parameters) {
            SQLExpr parameterClone = parameter.clone();
            x.addParameter(parameterClone);
        }
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.OPEN;
    }


    public SQLExpr getName() {
        return name;
    }

    public String getCursorName() {
        if (name instanceof SQLName) {
            return ((SQLName) name).getName();
        }
        return null;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }


    public List<SQLExpr> getParameters() {
        return parameters;
    }

    public void addParameter(SQLExpr parameter ) {
        if (parameter == null) {
            return;
        }
        setChildParent(parameter);
        this.parameters.add(parameter);
    }
}
