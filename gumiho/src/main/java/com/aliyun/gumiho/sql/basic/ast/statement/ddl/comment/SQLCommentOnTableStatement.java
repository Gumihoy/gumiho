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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;

/**
 * https://www.postgresql.org/docs/10/static/sql-comment.html
 * <p>
 * <p>
 * COMMENT ON TABLE [ schema. ] { table | view } IS string ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/COMMENT.html#GUID-65F447C4-6914-4823-9691-F15D52DB74D7
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMENT.html#GUID-65F447C4-6914-4823-9691-F15D52DB74D7
 *
 * @author kongtong.ouyang onCondition 2018/3/27.
 */
public class SQLCommentOnTableStatement extends AbstractSQLCommentStatement {

    public SQLCommentOnTableStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, comment);
        }
    }


    @Override
    public SQLCommentOnTableStatement clone() {
        SQLCommentOnTableStatement x = new SQLCommentOnTableStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

}
