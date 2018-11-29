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
package com.aliyun.gumiho.sql.basic.ast.element.identifier;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * 不带引号的name: xxx
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 * @see SQLDoubleQuoteIdentifier
 * @see SQLReverseQuoteIdentifier
 */
public class SQLIdentifierImpl extends AbstractSQLIdentifier {

    public SQLIdentifierImpl(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        SQLUtils.removeQuote(name);
        this.name = name;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLIdentifierImpl clone() {
        SQLIdentifierImpl x = new SQLIdentifierImpl(this.name);
        super.cloneTo(x);
        return x;
    }

    public void setName(String name) {
        SQLUtils.removeQuote(name);
        this.name = name;
    }

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String getValue() {
        return name;
    }
}