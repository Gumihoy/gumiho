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
package com.aliyun.gumiho.sql.basic.ast.element.comment;

import com.aliyun.gumiho.sql.basic.ast.AbstractSQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * //
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#comment
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLSlashCommentsExpr extends AbstractSQLObject implements SQLComments {

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLSlashCommentsExpr clone() {
        SQLSlashCommentsExpr x = new SQLSlashCommentsExpr();
        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return null;
    }
}
