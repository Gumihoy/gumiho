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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.table;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCascadeType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP TABLE <table name> [CASCADE | RESTRICT]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#drop%20table%20statement
 * <p>
 *
 * DROP [TEMPORARY] TABLE [IF EXISTS] tbl_name [, tbl_name] ... [RESTRICT | CASCADE]
 * https://dev.mysql.com/doc/refman/5.7/en/drop-table.html
 *
 * DROP TABLE [ schema. ] table [ CASCADE CONSTRAINTS ] [ PURGE ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/DROP-TABLE.html
 *
 * DROP TABLE [ IF EXISTS ] name [, ...] [ CASCADE | RESTRICT ]
 * https://www.postgresql.org/docs/devel/static/sql-droptable.html
 *
 * DROP TABLE [ IF EXISTS ] [ database_name . [ schema_name ] . | schema_name . ] table_name [ ,...n ]
 * https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-table-transact-sql
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropTableStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean temporary;

    protected boolean ifExists = false;

    protected final List<SQLName> names = new ArrayList<>(1);

    protected SQLCascadeType dropBehavior;

    protected boolean purge;

    public SQLDropTableStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }


    @Override
    public SQLDropTableStatement clone() {
        SQLDropTableStatement x = new SQLDropTableStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropTableStatement x) {
        super.cloneTo(x);

        x.temporary = this.temporary;

        x.ifExists = this.ifExists;

        for (SQLName name : this.names) {
            SQLName nameClone = name.clone();
            x.names.add(nameClone);
        }
        x.dropBehavior = this.dropBehavior;
        x.purge = this.purge;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target instanceof SQLName) {
            boolean replace = replaceInList(names, source, (SQLName) target, this);
            if (replace) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_TABLE;
    }


    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
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
        name.setParent(this);
        this.names.add(name);
    }

    public SQLCascadeType getDropBehavior() {
        return dropBehavior;
    }

    public void setDropBehavior(SQLCascadeType dropBehavior) {
        this.dropBehavior = dropBehavior;
    }

    public boolean isPurge() {
        return purge;
    }

    public void setPurge(boolean purge) {
        this.purge = purge;
    }
}
