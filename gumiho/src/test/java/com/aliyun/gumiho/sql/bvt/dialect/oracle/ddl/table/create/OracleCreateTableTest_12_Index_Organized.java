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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateTableTest_12_Index_Organized {

    @Test
    public void test() {
        String s = "CREATE TABLE countries_demo\n" +
                "    ( country_id      CHAR(2)\n" +
                "      CONSTRAINT country_id_nn_demo NOT NULL\n" +
                "    , country_name    VARCHAR2(40)\n" +
                "    , currency_name   VARCHAR2(25)\n" +
                "    , currency_symbol VARCHAR2(3)\n" +
                "    , region          VARCHAR2(15)\n" +
                "    , CONSTRAINT    country_c_id_pk_demo\n" +
                "                    PRIMARY KEY (country_id ) )\n" +
                "    ORGANIZATION INDEX \n" +
                "    INCLUDING   country_name \n" +
                "    PCTTHRESHOLD 2 \n" +
                "    STORAGE \n" +
                "     ( INITIAL  4K ) \n" +
                "   OVERFLOW \n" +
                "    STORAGE \n" +
                "      ( INITIAL  4K ); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE countries_demo (\n" +
                "\tcountry_id CHAR(2) CONSTRAINT country_id_nn_demo NOT NULL,\n" +
                "\tcountry_name VARCHAR2(40),\n" +
                "\tcurrency_name VARCHAR2(25),\n" +
                "\tcurrency_symbol VARCHAR2(3),\n" +
                "\tregion VARCHAR2(15),\n" +
                "\tCONSTRAINT country_c_id_pk_demo PRIMARY KEY (country_id)\n" +
                ")\n" +
                "ORGANIZATION INDEX INCLUDING country_name PCTTHRESHOLD 2 STORAGE (\n" +
                "\tINITIAL 4K\n" +
                ") OVERFLOW STORAGE (\n" +
                "\tINITIAL 4K\n" +
                ");", formatSQL);
    }
}
