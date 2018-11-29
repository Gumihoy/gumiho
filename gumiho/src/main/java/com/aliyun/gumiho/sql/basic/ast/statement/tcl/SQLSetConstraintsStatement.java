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
package com.aliyun.gumiho.sql.basic.ast.statement.tcl;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * SET { CONSTRAINT | CONSTRAINTS } { constraint [, constraint ]... | ALL } { IMMEDIATE | DEFERRED } ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-CONSTRAINTS.html#GUID-1EF5B212-17C5-4F7C-9412-D777DFDEDCE9
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLSetConstraintsStatement extends AbstractSQLSetConstraintsStatement {

    public SQLSetConstraintsStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }


    @Override
    public SQLSetConstraintsStatement clone() {
        SQLSetConstraintsStatement x = new SQLSetConstraintsStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_CONSTRAINTS;
    }

}
