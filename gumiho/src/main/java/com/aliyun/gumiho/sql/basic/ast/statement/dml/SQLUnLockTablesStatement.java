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

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPartitionClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLForUpdateClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UNLOCK TABLES
 * https://dev.mysql.com/doc/refman/5.6/en/lock-tables.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLUnLockTablesStatement extends AbstractSQLStatement implements SQLDMLStatement {


    public SQLUnLockTablesStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
        }
    }

    @Override
    public SQLUnLockTablesStatement clone() {
        SQLUnLockTablesStatement x = new SQLUnLockTablesStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLUnLockTablesStatement x) {
        super.cloneTo(x);

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.UNLOCK_TABLE;
    }

}
