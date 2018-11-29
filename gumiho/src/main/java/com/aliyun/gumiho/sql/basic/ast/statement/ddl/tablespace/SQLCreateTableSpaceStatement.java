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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.tablespace;


import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateTableSpaceStatement extends AbstractSQLStatement implements SQLCreateStatement {

    private SQLName name;


    public SQLCreateTableSpaceStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//        }
    }

    @Override
    public SQLCreateTableSpaceStatement clone() {
        SQLCreateTableSpaceStatement x = new SQLCreateTableSpaceStatement(this.dbType);

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLCreateTableSpaceStatement x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_TABLESPACE;
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
