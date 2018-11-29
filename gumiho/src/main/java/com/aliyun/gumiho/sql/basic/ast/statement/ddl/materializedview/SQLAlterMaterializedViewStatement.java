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


import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://www.w3resource.com/sql/creating-index/sql-alter-index.php
 *
 * https://www.postgresql.org/docs/devel/static/sql-alterindex.html
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/ALTER-INDEX.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterMaterializedViewStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected SQLName name;

    public SQLAlterMaterializedViewStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }


    @Override
    public SQLAlterMaterializedViewStatement clone() {
        SQLAlterMaterializedViewStatement x = new SQLAlterMaterializedViewStatement(this.dbType);
        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_MATERIALIZED_VIEW;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
