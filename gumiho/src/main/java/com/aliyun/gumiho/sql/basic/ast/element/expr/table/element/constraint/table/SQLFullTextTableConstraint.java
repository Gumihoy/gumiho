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

import com.aliyun.gumiho.sql.basic.ast.enums.SQLIndexFormat;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * FULLTEXT [INDEX|KEY] [index_name] (key_part,...) [index_option] ...
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLFullTextTableConstraint extends AbstractSQLIndexTableConstraint implements ISQLTableConstraint {

    protected SQLIndexFormat indexFormat;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLFullTextTableConstraint clone() {
        SQLFullTextTableConstraint x = new SQLFullTextTableConstraint();
        this.cloneTo(x);
        x.indexFormat = this.indexFormat;
        return x;
    }


    public SQLIndexFormat getIndexFormat() {
        return indexFormat;
    }

    public void setIndexFormat(SQLIndexFormat indexFormat) {
        this.indexFormat = indexFormat;
    }
}
