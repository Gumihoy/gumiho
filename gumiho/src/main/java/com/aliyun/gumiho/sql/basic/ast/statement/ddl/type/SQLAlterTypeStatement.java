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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.type;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * ALTER TYPE typename <alter type action>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#alter%20type%20statement
 * <p>
 * <p>
 * ALTER TYPE name action [, ... ]
 * ALTER TYPE name OWNER TO { new_owner | CURRENT_USER | SESSION_USER }
 * ALTER TYPE name RENAME ATTRIBUTE attribute_name TO new_attribute_name [ CASCADE | RESTRICT ]
 * ALTER TYPE name RENAME TO new_name
 * ALTER TYPE name SET SCHEMA new_schema
 * ALTER TYPE name ADD VALUE [ IF NOT EXISTS ] new_enum_value [ { BEFORE | AFTER } neighbor_enum_value ]
 * ALTER TYPE name RENAME VALUE existing_enum_value TO new_enum_value
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-altertype.html
 * <p>
 * <p>
 * ALTER TYPE [ schema. ] type_name { { EDITIONABLE | NONEDITIONABLE } | alter_type_clause } ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterTypeStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected SQLName name;

    protected final List<SQLExpr> actions = new ArrayList<>();


    public SQLAlterTypeStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, actions);
        }
    }


    @Override
    public SQLAlterTypeStatement clone() {
        SQLAlterTypeStatement x = new SQLAlterTypeStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLAlterTypeStatement x) {
        super.cloneTo(x);

        SQLName cloneName = this.name.clone();
        x.setName(cloneName);

        for (SQLExpr action : actions) {
            SQLExpr actionClone = action.clone();
            x.addAction(actionClone);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_TYPE;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }


    public List<SQLExpr> getActions() {
        return actions;
    }

    public void addAction(SQLExpr action) {
        if (action == null) {
            return;
        }
        setChildParent(action);
        this.actions.add(action);
    }

}
