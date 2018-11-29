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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.event;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/create-event.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateEventStatement extends AbstractSQLStatement implements SQLCreateStatement {

    public SQLCreateEventStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }


    @Override
    public SQLStatement clone() {
        return null;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_EVENT;
    }

}