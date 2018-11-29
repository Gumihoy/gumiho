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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.rollbacksegment;


import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * DROP ROLLBACK SEGMENT rollback_segment
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/DROP-ROLLBACK-SEGMENT.html#GUID-26B4C9D6-EFB4-4523-B84D-FAD42060D3D4
 *
 * @author kongtong.ouyang onCondition 2018/6/23.
 */
public class SQLDropRollbackSegmentStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected SQLName name;


    public SQLDropRollbackSegmentStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }


    @Override
    public SQLDropRollbackSegmentStatement clone() {
        SQLDropRollbackSegmentStatement x = new SQLDropRollbackSegmentStatement(DBType.Oracle);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropRollbackSegmentStatement x) {
        super.cloneTo(x);

        SQLName nameClone = name.clone();
        x.setName(nameClone);

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_ROLLBACK_SEGMENT;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}
