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
package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.AbstractSQLObject;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

public abstract class AbstractSQLExpr extends AbstractSQLObject implements SQLExpr {

    public AbstractSQLExpr() {
    }

    @Override
    public SQLExpr clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void AbstractSQLExpr(AbstractSQLExpr x) {
        super.cloneTo(x);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.EXPR;
    }
}
