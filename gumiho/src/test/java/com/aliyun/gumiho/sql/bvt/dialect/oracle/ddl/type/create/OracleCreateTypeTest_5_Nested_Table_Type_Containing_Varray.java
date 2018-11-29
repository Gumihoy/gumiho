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
public class OracleCreateTypeTest_5_Nested_Table_Type_Containing_Varray {

    @Test
    public void test1() {
        String s = "CREATE TYPE cust_address_typ2 AS OBJECT\n" +
                "       ( street_address     VARCHAR2(40)\n" +
                "       , postal_code        VARCHAR2(10)\n" +
                "       , city               VARCHAR2(30)\n" +
                "       , state_province     VARCHAR2(10)\n" +
                "       , country_id         CHAR(2)\n" +
                "       , phone              phone_list_typ_demo\n" +
                "       );\n" +
                "\n" +
                "CREATE TYPE cust_nt_address_typ\n" +
                "   AS TABLE OF cust_address_typ2; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE cust_address_typ2 AS OBJECT (\n" +
                "\tstreet_address VARCHAR2(40),\n" +
                "\tpostal_code VARCHAR2(10),\n" +
                "\tcity VARCHAR2(30),\n" +
                "\tstate_province VARCHAR2(10),\n" +
                "\tcountry_id CHAR(2),\n" +
                "\tphone phone_list_typ_demo\n" +
                ");\n" +
                "CREATE TYPE cust_nt_address_typ AS TABLE OF cust_address_typ2;", formatSQL);
    }
    
}
