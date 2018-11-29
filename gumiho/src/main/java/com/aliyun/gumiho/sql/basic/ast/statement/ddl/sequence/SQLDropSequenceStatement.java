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
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCascadeType;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP SEQUENCE <sequence generator name> <drop behavior>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#drop%20sequence%20generator%20statement
 *
 * DROP SEQUENCE [ IF EXISTS ] name [, ...] [ CASCADE | RESTRICT ]
 * https://www.postgresql.org/docs/devel/static/sql-dropsequence.html
 *
 * DROP SEQUENCE [ schema. ] sequence_name ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/DROP-SEQUENCE.html#GUID-32B640EE-47C9-46A7-9746-6125BAF8FF8C
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropSequenceStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists = false;

    protected final List<SQLName> names = new ArrayList<>();

    protected SQLCascadeType dropBehavior;


    public SQLDropSequenceStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLDropSequenceStatement clone() {
        SQLDropSequenceStatement x = new SQLDropSequenceStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropSequenceStatement x) {
        super.cloneTo(x);

        x.setIfExists(this.ifExists);

        for (SQLName name : this.names) {
            SQLName cloneName = name.clone();
            x.addName(cloneName);
        }

        x.dropBehavior = this.dropBehavior;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source instanceof SQLName) {
            boolean replace = replaceInList(names, source, (SQLName) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_SEQUENCE;
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
}
