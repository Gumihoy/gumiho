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
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.hash.FNVHash;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public abstract class AbstractSQLName extends AbstractSQLExpr implements SQLName {

    protected SQLName nameExpr;

    protected String name;
    protected String fullName;
    protected long nameHashCode64;
    protected long fullNameHashCode64;
    protected long lowerNameHashCode64;
    protected long lowerFullNameHashCode64;


    public AbstractSQLName() {
    }

    public AbstractSQLName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        setName(SQLUtils.ofName(name));
    }

    public AbstractSQLName(SQLName name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        setName(name);
    }

    @Override
    public AbstractSQLName clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLName x) {
        super.cloneTo(x);

        SQLName nameExprClone = this.nameExpr.clone();
        x.setName(nameExprClone);

        x.name = this.name;
        x.fullName = this.fullName;
        x.nameHashCode64 = this.nameHashCode64;
        x.fullNameHashCode64 = this.fullNameHashCode64;
        x.lowerNameHashCode64 = this.lowerNameHashCode64;
        x.lowerFullNameHashCode64 = this.lowerFullNameHashCode64;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == nameExpr
                && target instanceof SQLName) {
            setName((SQLName) target);
        }
        return false;
    }

    public SQLName getNameExpr() {
        return nameExpr;
    }

    public void setName(SQLName nameExpr) {
        setChildParent(nameExpr);
        clearName();
        this.nameExpr = nameExpr;
    }

    public void clearName() {
        this.name = null;
        this.fullName = null;
    }

    @Override
    public String getName() {
        if (name == null) {
            this.name = nameExpr.getName();
        }
        return name;
    }

    @Override
    public String getFullName() {
        if (fullName == null) {
            this.fullName = nameExpr.getFullName();
        }
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
        if (this.nameHashCode64 == 0) {
            this.nameHashCode64 = FNVHash.fnv1a_64_lower(getName());
        }
        return nameHashCode64;
    }

    @Override
    public long fullNameLowerHash() {
        if (this.fullNameHashCode64 == 0) {
            this.fullNameHashCode64 = FNVHash.fnv1a_64_lower(getFullName());
        }
        return nameHashCode64;
    }


}
