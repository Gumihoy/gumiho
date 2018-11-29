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
package com.aliyun.gumiho.sql.dialect.mysql.ast;

import com.aliyun.gumiho.sql.basic.ast.AbstractSQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTOutputVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public abstract class AbstractMySQLSQLObject extends AbstractSQLObject implements MySQLSQLObject {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof MySQLSQLASTVisitor) {
            accept0((MySQLSQLASTVisitor) visitor);
        } else {
            throw new IllegalArgumentException("not support visitor type : " + visitor.getClass().getName());
        }
    }

    @Override
    public abstract void accept0(MySQLSQLASTVisitor visitor);

    @Override
    public void output(StringBuilder out) {
        MySQLSQLASTOutputVisitor visitor = new MySQLSQLASTOutputVisitor(out);
        this.accept(visitor);
    }
}