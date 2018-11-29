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
public class OracleCreateTableTest_19_List_Partitioning {

    @Test
    public void test() {
        String s = "CREATE TABLE list_customers \n" +
                "   ( customer_id             NUMBER(6)\n" +
                "   , cust_first_name         VARCHAR2(20) \n" +
                "   , cust_last_name          VARCHAR2(20)\n" +
                "   , cust_address            CUST_ADDRESS_TYP\n" +
                "   , nls_territory           VARCHAR2(30)\n" +
                "   , cust_email              VARCHAR2(40))\n" +
                "   PARTITION BY LIST (nls_territory) (\n" +
                "   PARTITION asia VALUES ('CHINA', 'THAILAND'),\n" +
                "   PARTITION europe VALUES ('GERMANY', 'ITALY', 'SWITZERLAND'),\n" +
                "   PARTITION west VALUES ('AMERICA'),\n" +
                "   PARTITION east VALUES ('INDIA'),\n" +
                "   PARTITION rest VALUES (DEFAULT)); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE list_customers (\n" +
                "\tcustomer_id NUMBER(6),\n" +
                "\tcust_first_name VARCHAR2(20),\n" +
                "\tcust_last_name VARCHAR2(20),\n" +
                "\tcust_address CUST_ADDRESS_TYP,\n" +
                "\tnls_territory VARCHAR2(30),\n" +
                "\tcust_email VARCHAR2(40)\n" +
                ")\n" +
                "PARTITION BY LIST (nls_territory) (\n" +
                "\tPARTITION asia VALUES ('CHINA', 'THAILAND'),\n" +
                "\tPARTITION europe VALUES ('GERMANY', 'ITALY', 'SWITZERLAND'),\n" +
                "\tPARTITION west VALUES ('AMERICA'),\n" +
                "\tPARTITION east VALUES ('INDIA'),\n" +
                "\tPARTITION rest VALUES (DEFAULT)\n" +
                ");", formatSQL);
    }
}
