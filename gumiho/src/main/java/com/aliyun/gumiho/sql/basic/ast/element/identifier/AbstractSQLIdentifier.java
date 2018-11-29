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

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.ISQLTextLiteral;
import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * @author kongtong.ouyang onCondition 2018/3/9.
 */
public abstract class AbstractSQLIdentifier extends AbstractSQLExpr implements SQLIdentifier, ISQLTextLiteral {

    protected String name;
    protected String fullName;
    protected long nameHashCode64;
    protected long fullNameHashCode64;
    protected long lowerNameHashCode64;
    protected long lowerFullNameHashCode64;

    @Override
    public AbstractSQLIdentifier clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public long hash() {
        if (this.nameHashCode64 == 0) {
            this.nameHashCode64 = FNVHash.fnv1a_64(getName());
        }
        return nameHashCode64;
    }

    @Override
    public long fullNameHash() {
        if (this.fullNameHashCode64 == 0) {
            this.fullNameHashCode64 = FNVHash.fnv1a_64(getFullName());
        }
        return nameHashCode64;
    }

    @Override
    public long lowerHash() {
        if (this.lowerNameHashCode64 == 0) {
            this.lowerNameHashCode64 = FNVHash.fnv1a_64_lower(getName());
        }
        return lowerNameHashCode64;
    }

    @Override
    public long fullNameLowerHash() {
        if (this.lowerFullNameHashCode64 == 0) {
            this.lowerFullNameHashCode64 = FNVHash.fnv1a_64_lower(getFullName());
        }
        return lowerFullNameHashCode64;
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SQLIdentifierImpl that = (SQLIdentifierImpl) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
