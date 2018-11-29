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
package com.aliyun.gumiho.sql.dependenv.dialect.oracle;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleTest_By_File {

    @Test
    public void test() throws Exception {
        String path = "/Users/kongtong.ouyang/Downloads/long_text_2018-08-02-20-56-18.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf8"));

        StringBuilder oracleSql = new StringBuilder();
        String line = "";
        int i = 0;
        while (line != null) {
            i++;
            line = reader.readLine();
            if (line == null) {
                break;
            }
            oracleSql.append(line).append(" ").append("\n");
        }

        String format = SQLUtils.format(oracleSql.toString(), DBType.Oracle);
        System.out.println(oracleSql);
//
        System.out.println("oracleSql.length():" + oracleSql.length());
//        TransformResult result = TransformUtils.oracleToPPAS(oracleSql.toString(), config);
//        assertNotNull(result.targetSql);
        System.out.println("----------------");
        System.out.println(oracleSql);
//
//        Assert.assertEquals(result.sourceSql, result.targetSql);
//        Assert.assertEquals(oracleSql.toString(), format);
    }
}
