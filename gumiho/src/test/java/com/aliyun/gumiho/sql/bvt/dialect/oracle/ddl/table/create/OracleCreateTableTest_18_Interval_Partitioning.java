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
public class OracleCreateTableTest_18_Interval_Partitioning {

    @Test
    public void test() {
        String s = "CREATE TABLE customers_demo (\n" +
                "  customer_id number(6),\n" +
                "  cust_first_name varchar2(20),\n" +
                "  cust_last_name varchar2(20),\n" +
                "  credit_limit number(9,2))\n" +
                "PARTITION BY RANGE (credit_limit)\n" +
                "INTERVAL (1000)\n" +
                "(PARTITION p1 VALUES LESS THAN (5001)); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE customers_demo (\n" +
                "\tcustomer_id NUMBER(6),\n" +
                "\tcust_first_name VARCHAR2(20),\n" +
                "\tcust_last_name VARCHAR2(20),\n" +
                "\tcredit_limit NUMBER(9, 2)\n" +
                ")\n" +
                "PARTITION BY RANGE (credit_limit) INTERVAL (1000) (\n" +
                "\tPARTITION p1 VALUES LESS THAN (5001)\n" +
                ");", formatSQL);
    }
}
