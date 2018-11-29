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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.view;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * ALTER VIEW [ IF EXISTS ] name ALTER [ COLUMN ] column_name SET DEFAULT expression
 * ALTER VIEW [ IF EXISTS ] name ALTER [ COLUMN ] column_name DROP DEFAULT
 * ALTER VIEW [ IF EXISTS ] name OWNER TO { new_owner | CURRENT_USER | SESSION_USER }
 * ALTER VIEW [ IF EXISTS ] name RENAME TO new_name
 * ALTER VIEW [ IF EXISTS ] name SET SCHEMA new_schema
 * ALTER VIEW [ IF EXISTS ] name SET ( view_option_name [= view_option_value] [, ... ] )
 * ALTER VIEW [ IF EXISTS ] name RESET ( view_option_name [, ... ] )
 * https://www.postgresql.org/docs/10/static/sql-alterview.html
 * <p>
 * <p>
 * ALTER VIEW [ schema. ] view { ADD out_of_line_constraint | MODIFY CONSTRAINT constraint { RELY | NORELY } | DROP { CONSTRAINT constraint | PRIMARY KEY | UNIQUE (column [, column ]...) } | COMPILE | { READ ONLY | READ WRITE } | { EDITIONABLE | NONEDITIONABLE } } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-VIEW.html#GUID-0DEDE960-B481-4B55-8027-EA9E4C863625
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterViewStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected boolean ifExists;
    protected SQLName name;
    protected SQLExpr action;

    public SQLAlterViewStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, action);
        }
    }


    @Override
    public SQLAlterViewStatement clone() {
        SQLAlterViewStatement x = new SQLAlterViewStatement(this.dbType);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == action) {
            setAction(target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_VIEW;
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
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getAction() {
        return action;
    }

    public void setAction(SQLExpr action) {
        setChildParent(action);
        this.action = action;
    }
}
