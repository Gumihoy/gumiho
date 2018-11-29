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

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/3/14.
 */
public class SQLReservedIdentifier extends AbstractSQLIdentifier {

    public SQLReserved reserved;

    public SQLReservedIdentifier(SQLReserved reserved) {
        this.reserved = reserved;
    }

    public static SQLReservedIdentifier of(SQLReserved reserved) {
        return new SQLReservedIdentifier(reserved);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public SQLReservedIdentifier clone() {
        return null;
    }


    public SQLReserved getReserved() {
        return reserved;
    }

    public void setReserved(SQLReserved reserved) {
        this.reserved = reserved;
    }

    public String lower() {
        return reserved.lower;
    }

    public String upper() {
        return reserved.upper;
    }

    @Override
    public String getName() {
        return upper();
    }

    @Override
    public String getFullName() {
        return getName();
    }

    @Override
    public String getValue() {
        return upper();
    }
}
