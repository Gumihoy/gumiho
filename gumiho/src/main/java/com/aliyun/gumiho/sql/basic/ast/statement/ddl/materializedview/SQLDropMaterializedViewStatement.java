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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP MATERIALIZED VIEW [ IF EXISTS ] name [, ...] [ CASCADE | RESTRICT ]
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-dropmaterializedview.html
 * <p>
 * <p>
 * DROP MATERIALIZED VIEW [ schema. ] materialized_view [ PRESERVE TABLE ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/DROP-MATERIALIZED-VIEW.html#GUID-187B88E0-F84A-44DB-8F4D-F477586FD22B
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropMaterializedViewStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists;

    protected final List<SQLName> names = new ArrayList<>();

    protected SQLOption option;


    public SQLDropMaterializedViewStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLDropMaterializedViewStatement clone() {
        SQLDropMaterializedViewStatement x = new SQLDropMaterializedViewStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLDropMaterializedViewStatement x) {
        super.cloneTo(x);

        x.ifExists = this.ifExists;

        for (SQLName name : this.names) {
            SQLName nameClone = name.clone();
            x.addName(nameClone);
        }

        x.option = this.option;
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
        return SQLObjectType.DROP_MATERIALIZED_VIEW;
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
        setChildParent(name);
        this.names.add(name);
    }

    public SQLOption getOption() {
        return option;
    }

    public void setOption(SQLOption option) {
        this.option = option;
    }


    public enum SQLOption {
        PRESERVE_TABLE(SQLReserved.PRESERVE_TABLE),;
        public final SQLReserved name;

        SQLOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
