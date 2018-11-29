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
 * 反引号字符串 `xxx` 主要用在mysql
 *
 * @author kongtong.ouyang onCondition 2018/3/9.
 */
public class SQLReverseQuoteIdentifier extends AbstractSQLIdentifier {

    public SQLReverseQuoteIdentifier(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        setName(name);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public SQLReverseQuoteIdentifier clone() {
        SQLReverseQuoteIdentifier x = new SQLReverseQuoteIdentifier(this.name);

        super.cloneTo(x);

        return x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = SQLUtils.removeReverseQuote(name);
        this.name = name;
    }

    @Override
    public String getFullName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return "`" + getName() + "`";
    }
}
