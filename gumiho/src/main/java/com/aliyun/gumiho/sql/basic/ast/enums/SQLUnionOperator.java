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

import java.util.concurrent.ConcurrentHashMap;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/The-UNION-ALL-INTERSECT-MINUS-Operators.html#GUID-B64FE747-586E-4513-945F-80CB197125EE
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public enum SQLUnionOperator {

    UNION(SQLReserved.UNION),
    UNION_ALL(SQLReserved.UNION_ALL),
    UNION_DISTINCT(SQLReserved.UNION_DISTINCT),

    MINUS(SQLReserved.MINUS),

    EXCEPT(SQLReserved.EXCEPT),
    EXCEPT_ALL(SQLReserved.EXCEPT_ALL),
    EXCEPT_DISTINCT(SQLReserved.EXCEPT_DISTINCT),

    INTERSECT(SQLReserved.INTERSECT),
    INTERSECT_ALL(SQLReserved.INTERSECT_ALL),
    INTERSECT_DISTINCT(SQLReserved.INTERSECT_DISTINCT),;

    public final SQLReserved name;

    SQLUnionOperator(SQLReserved name) {
        this.name = name;
    }

    public static SQLUnionOperator of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        return SQLUnionOperatorHolder.MAP.get(lowerHashCode64);
    }

    public static class SQLUnionOperatorHolder {
        public static final ConcurrentHashMap<Long, SQLUnionOperator> MAP = new ConcurrentHashMap<>();

        static {
            for (SQLUnionOperator operator : SQLUnionOperator.values()) {
                MAP.put(operator.name.lowerHashCode64, operator);
            }
        }
    }

    @Override
    public String toString() {
        return name.upper;
    }

}
