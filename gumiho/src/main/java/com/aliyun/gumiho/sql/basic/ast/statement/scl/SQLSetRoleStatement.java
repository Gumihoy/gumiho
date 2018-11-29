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
package com.aliyun.gumiho.sql.basic.ast.statement.scl;

import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * SET ROLE
 * { role [ IDENTIFIED BY password ]
 * [, role [ IDENTIFIED BY password ] ]...
 * | ALL [ EXCEPT role [, role ]... ]
 * | NONE
 * } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-ROLE.html#GUID-863F9B6F-82B4-4C49-8E3A-3BA33AE79CAB
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLSetRoleStatement extends AbstractSQLStatement {


    public SQLSetRoleStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//            this.acceptChild(visitor, condition);
//        }
    }


    @Override
    public SQLStatement clone() {
        SQLSetRoleStatement x = new SQLSetRoleStatement(this.dbType);

        return x;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_ROLE;
    }

}
