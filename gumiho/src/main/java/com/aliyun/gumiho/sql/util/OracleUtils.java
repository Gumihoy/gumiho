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
package com.aliyun.gumiho.sql.util;


import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;

import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public final class OracleUtils {

    public static String format(String sql)  {
        return SQLUtils.format(sql, DBType.Oracle);
    }

    public static String toSQLString(SQLObject sqlObject)  {
        return SQLUtils.toSQLString(sqlObject, DBType.Oracle);
    }

    public static String toSQLString(List<SQLObject> sqlObjects) {
        return SQLUtils.toSQLString(sqlObjects, DBType.Oracle);
    }

    public static SQLTransformResult toMySQL(String sql)  {
        return SQLTransformUtils.oracleToMySQL(sql);
    }

    public static SQLTransformResult toMySQL(String sql, SQLTransformConfig config)  {
        return SQLTransformUtils.oracleToMySQL(sql, config);
    }

    public static SQLTransformResult toPPAS(String sql)  {
        return SQLTransformUtils.oracleToPPAS(sql);
    }

    public static SQLTransformResult toPPAS(String sql, SQLTransformConfig config)  {
        return SQLTransformUtils.oracleToPPAS(sql, config);
    }

    public static SQLTransformResult toPostgreSQL(String sql)  {
        return SQLTransformUtils.oracleToPostgreSQL(sql);
    }

    public static SQLTransformResult toPostgreSQL(String sql, SQLTransformConfig config)  {
        return SQLTransformUtils.oracleToPostgreSQL(sql, config);
    }


}
