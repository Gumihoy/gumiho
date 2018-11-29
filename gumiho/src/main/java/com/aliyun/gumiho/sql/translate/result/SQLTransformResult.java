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
package com.aliyun.gumiho.sql.translate.result;

import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLTransformResult {

    public final String sourceSql;
    public String targetSql;
    public List<SQLResult> results = new ArrayList<>();


    public final Set<SQLTransformError> errors = new HashSet<SQLTransformError>();
    public final Set<SQLTransformChange> changes = new HashSet<SQLTransformChange>();
    public final Set<SQLTransformWarnning> warnnings = new HashSet<SQLTransformWarnning>();


    public int createTableCount;
    public int createViewCount;
    public int insertCount;
    public int deleteCount;
    public int selectCount;
    public int updateCount;
    public int createTypeCount;
    public int createTypeBodyCount;
    public int createPackageCount;
    public int createPackageBodyCount;
    public int createFunctionCount;
    public int createProcedureCount;


    public SQLTransformResult(String sourceSql) {
        this.sourceSql = sourceSql;
    }



    public void addResult(SQLResult result) {
        if (result == null) {
            return;
        }
        results.add(result);
    }

    public static class SQLResult {
        public final SQLObjectType type;
        public final String targetSql;

        private SQLResult(SQLObjectType type, String targetSql) {
            this.type = type;
            this.targetSql = targetSql;
        }

        public static SQLResult of(SQLObjectType type, String targetSql) {
            return new SQLResult(type, targetSql);
        }
    }

}
