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

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * HANDLER tbl_name OPEN [ [AS] alias]
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/handler.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public abstract class AbstractSQLHandlerStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLName name;

    public AbstractSQLHandlerStatement(DBType dbType) {
        super(dbType);
    }


    public void cloneTo(AbstractSQLHandlerStatement x) {
        super.cloneTo(x);
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.HANDLER;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
