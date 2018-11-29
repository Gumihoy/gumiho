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
package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#referential%20action
 *
 * @author kongtong.ouyang onCondition 2018/3/27.
 */
public enum SQLReferentialAction implements ISQLEnum {

    CASCADE(SQLReserved.CASCADE),
    SET_NULL(SQLReserved.SET_NULL),
    SET_DEFAULT(SQLReserved.SET_DEFAULT),
    RESTRICT(SQLReserved.RESTRICT),
    NO_ACTION(SQLReserved.NO_ACTION),;

    public final SQLReserved name;

    SQLReferentialAction(SQLReserved name) {
        this.name = name;
    }

    public static SQLReferentialAction of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        for (SQLReferentialAction action : SQLReferentialAction.values()) {
            if (action.name.lowerHashCode64 == lowerHashCode64) {
                return action;
            }
        }
        return null;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.upper;
    }


}
