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
package com.aliyun.gumiho.sql.bvt.util;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.repository.Schema;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class SQLUtilsTest {

    private static final ConcurrentHashMap<SQLName, Schema> SCHEMA_CONCURRENT_MAP = new ConcurrentHashMap<>();

    @Test
    public void test_0() {
//        SQLDataType dataType = SQLUtils.toSQLDataType("CHAR", DBType.Oracle);
//        System.out.println(dataType);

        SQLPropertyExpr propertyExpr1 = new SQLPropertyExpr("1", "2");
        SCHEMA_CONCURRENT_MAP.put(propertyExpr1, new Schema());
        Schema schema = SCHEMA_CONCURRENT_MAP.get(new SQLPropertyExpr("1", "2"));
        System.out.println(schema);

    }
}
