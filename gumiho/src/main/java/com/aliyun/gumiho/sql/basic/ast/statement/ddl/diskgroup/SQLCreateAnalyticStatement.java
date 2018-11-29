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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.diskgroup;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-ANALYTIC-VIEW.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateAnalyticStatement extends AbstractSQLStatement implements SQLCreateStatement {

    public SQLName name;


    public SQLCreateAnalyticStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {

//        if (visitor.visit(this)) {
//            acceptChild(visitor, name);
//        }
    }

    @Override
    public SQLStatement clone() {
        SQLCreateAnalyticStatement x = new SQLCreateAnalyticStatement(this.dbType);

        this.cloneTo(x);

        return x;
    }

    public void cloneTo(SQLCreateAnalyticStatement x) {

        x.setName(this.name);

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_ANALYTIC;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        if (name != null) {
            name.setParent(this);
        }

        this.name = name;
    }


}
