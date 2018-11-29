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
 * ALTER SESSION
 * { ADVISE { COMMIT | ROLLBACK | NOTHING }
 * | CLOSE DATABASE LINK dblink
 * | { ENABLE | DISABLE } COMMIT IN PROCEDURE
 * | { ENABLE | DISABLE } GUARD
 * | { ENABLE | DISABLE | FORCE } PARALLEL
 * { DML | DDL | QUERY } [ PARALLEL integer ]
 * | { ENABLE RESUMABLE [ TIMEOUT integer ] [ NAME string ]
 * | DISABLE RESUMABLE
 * }
 * | { ENABLE | DISABLE } SHARD DDL
 * | SYNC WITH PRIMARY
 * | alter_session_set_clause
 * } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-SESSION.html#GUID-27186B28-7EFC-4998-B1ED-2B905CC0211B
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLAlterSessionStatement extends AbstractSQLStatement {


    public SQLAlterSessionStatement(DBType dbType) {
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
        SQLAlterSessionStatement x = new SQLAlterSessionStatement(this.dbType);

        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_SESSION;
    }

}
