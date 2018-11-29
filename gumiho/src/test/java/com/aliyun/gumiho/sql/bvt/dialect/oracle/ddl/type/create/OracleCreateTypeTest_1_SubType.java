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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.type.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateTypeTest_1_SubType {

    @Test
    public void test1() {
        String s = "CREATE TYPE customer_typ_demo AS OBJECT\n" +
                "    ( customer_id        NUMBER(6)\n" +
                "    , cust_first_name    VARCHAR2(20)\n" +
                "    , cust_last_name     VARCHAR2(20)\n" +
                "    , cust_address       CUST_ADDRESS_TYP\n" +
                "    , phone_numbers      PHONE_LIST_TYP\n" +
                "    , nls_language       VARCHAR2(3)\n" +
                "    , nls_territory      VARCHAR2(30)\n" +
                "    , credit_limit       NUMBER(9,2)\n" +
                "    , cust_email         VARCHAR2(30)\n" +
                "    , cust_orders        ORDER_LIST_TYP\n" +
                "    ) ;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE customer_typ_demo AS OBJECT (\n" +
                "\tcustomer_id NUMBER(6),\n" +
                "\tcust_first_name VARCHAR2(20),\n" +
                "\tcust_last_name VARCHAR2(20),\n" +
                "\tcust_address CUST_ADDRESS_TYP,\n" +
                "\tphone_numbers PHONE_LIST_TYP,\n" +
                "\tnls_language VARCHAR2(3),\n" +
                "\tnls_territory VARCHAR2(30),\n" +
                "\tcredit_limit NUMBER(9, 2),\n" +
                "\tcust_email VARCHAR2(30),\n" +
                "\tcust_orders ORDER_LIST_TYP\n" +
                ");", formatSQL);
    }

    @Test
    public void test2() {
        String s = "CREATE TYPE data_typ1 AS OBJECT \n" +
                "   ( year NUMBER, \n" +
                "     MEMBER FUNCTION prod(invent NUMBER) RETURN NUMBER \n" +
                "   ); \n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE data_typ1 AS OBJECT (\n" +
                "\tyear NUMBER,\n" +
                "\tMEMBER FUNCTION prod (\n" +
                "\t\tinvent NUMBER\n" +
                "\t) RETURN NUMBER\n" +
                ");", formatSQL);
    }
}
