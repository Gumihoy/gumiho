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

/**
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public enum SQLTableScope implements ISQLEnum {

    TEMP(SQLReserved.TEMP),
    TEMPORARY(SQLReserved.TEMPORARY),
    GLOBAL_TEMP(SQLReserved.GLOBAL_TEMP),
    LOCAL_TEMP(SQLReserved.LOCAL_TEMP),
    GLOBAL_TEMPORARY(SQLReserved.GLOBAL_TEMPORARY),
    LOCAL_TEMPORARY(SQLReserved.LOCAL_TEMPORARY),
    PRIVATE_TEMPORARY(SQLReserved.PRIVATE_TEMPORARY),
    SHARDED(SQLReserved.SHARDED),
    DUPLICATED(SQLReserved.DUPLICATED),
    UNLOGGED(SQLReserved.UNLOGGED),
    ;

    public final SQLReserved name;

    SQLTableScope(SQLReserved name) {
        this.name = name;
    }

    public static SQLTableScope of(long lowerHashCode64) {
        SQLTableScope[] tableScopes = SQLTableScope.values();
        for (SQLTableScope tableScope : tableScopes) {
            if (tableScope.name.lowerHashCode64 != lowerHashCode64) {
                continue;
            }
            return tableScope;
        }
        return null;
    }
    @Override
    public String toString() {
        return name.upper;
    }


    @Override
    public SQLReserved getName() {
        return name;
    }
}
