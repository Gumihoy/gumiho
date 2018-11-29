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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/DELETE.html#GUID-156845A5-B626-412B-9F95-8869B988ABD7
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLExplainPlanStatement extends AbstractSQLStatement implements SQLDMLStatement {


    public SQLExplainPlanStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//
//        }
    }

    @Override
    public SQLExplainPlanStatement clone() {
        SQLExplainPlanStatement x = new SQLExplainPlanStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLExplainPlanStatement x) {
        super.cloneTo(x);

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DELETE;
    }


}
