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
 * @author kongtong.ouyang onCondition 2018/3/29.
 */
public enum SQLIndexCategory implements ISQLEnum {

    UNIQUE(SQLReserved.UNIQUE),
    BITMAP(SQLReserved.BITMAP),
    FULLTEXT(SQLReserved.FULLTEXT),
    SPATIAL(SQLReserved.SPATIAL);

    public final SQLReserved name;


    SQLIndexCategory(SQLReserved name) {
        this.name = name;
    }

    public static SQLIndexCategory of(String name) {
        long hash = FNVHash.fnv1a_64_lower(name);
        for (SQLIndexCategory indexCategory : SQLIndexCategory.values()) {
            if (indexCategory.name.lowerHashCode64 == hash) {
                return indexCategory;
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
