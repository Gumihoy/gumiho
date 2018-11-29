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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.AbstractSQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIndexType;

/**
 * USING {BTREE | HASH}
 * <p>
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public abstract class AbstractSQLTableConstraint extends AbstractSQLConstraint implements ISQLTableConstraint {

    protected SQLIndexType indexType;

    @Override
    public AbstractSQLTableConstraint clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLTableConstraint x) {
        super.cloneTo(x);
        x.indexType = this.indexType;
    }

    public SQLIndexType getIndexType() {
        return indexType;
    }

    public void setIndexType(SQLIndexType indexType) {
        this.indexType = indexType;
    }
}
