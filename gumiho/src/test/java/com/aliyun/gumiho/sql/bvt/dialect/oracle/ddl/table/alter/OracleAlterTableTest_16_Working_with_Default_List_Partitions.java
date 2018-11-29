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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterTableTest_16_Working_with_Default_List_Partitions {

    @Test
    public void test_0() {
        String s = "ALTER TABLE list_customers SPLIT PARTITION rest \n" +
                "   VALUES ('MEXICO', 'COLOMBIA')\n" +
                "   INTO (PARTITION south, PARTITION rest); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE list_customers\n" +
                "\tSPLIT PARTITION rest VALUES (\n" +
                "\t\t'MEXICO',\n" +
                "\t\t'COLOMBIA'\n" +
                "\t)\n" +
                "\tINTO (\n" +
                "\t\tPARTITION south,\n" +
                "\t\tPARTITION rest\n" +
                "\t);", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "ALTER TABLE list_customers \n" +
                "   MERGE PARTITIONS asia, rest INTO PARTITION rest; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE list_customers\n" +
                "\tMERGE PARTITIONS asia, rest\n" +
                "\tINTO PARTITION rest;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "ALTER TABLE list_customers SPLIT PARTITION rest \n" +
                "   VALUES ('CHINA', 'THAILAND')\n" +
                "   INTO (PARTITION asia, PARTITION rest); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE list_customers\n" +
                "\tSPLIT PARTITION rest VALUES (\n" +
                "\t\t'CHINA',\n" +
                "\t\t'THAILAND'\n" +
                "\t)\n" +
                "\tINTO (\n" +
                "\t\tPARTITION asia,\n" +
                "\t\tPARTITION rest\n" +
                "\t);", formatSQL);
    }
}
