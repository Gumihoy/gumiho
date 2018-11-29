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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.insert;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleMultiInsertTest_0 {

    @Test
    public void test_0() {
        String sql = "INSERT ALL\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date, sales_sun)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+1, sales_mon)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+2, sales_tue)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+3, sales_wed)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+4, sales_thu)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+5, sales_fri)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+6, sales_sat)\n" +
                "   SELECT product_id, customer_id, weekly_start_date, sales_sun,\n" +
                "      sales_mon, sales_tue, sales_wed, sales_thu, sales_fri, sales_sat\n" +
                "      FROM sales_input_table;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT ALL\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date, sales_sun)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 1, sales_mon)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 2, sales_tue)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 3, sales_wed)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 4, sales_thu)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 5, sales_fri)\n" +
                "\tINTO sales (prod_id, cust_id, time_id, amount)\n" +
                "\tVALUES (product_id, customer_id, weekly_start_date + 6, sales_sat)\n" +
                "SELECT product_id, customer_id, weekly_start_date, sales_sun, sales_mon,\n" +
                "\tsales_tue, sales_wed, sales_thu, sales_fri, sales_sat\n" +
                "FROM sales_input_table;", format);
    }


    @Test
    public void test2() {
        String sql = "INSERT ALL\n" +
                "   WHEN order_total <= 100000 THEN\n" +
                "      INTO small_orders\n" +
                "   WHEN order_total > 1000000 AND order_total <= 200000 THEN\n" +
                "      INTO medium_orders\n" +
                "   WHEN order_total > 200000 THEN\n" +
                "      INTO large_orders\n" +
                "   SELECT order_id, order_total, sales_rep_id, customer_id\n" +
                "      FROM orders;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT ALL\n" +
                "\tWHEN order_total <= 100000 THEN\n" +
                "\t\tINTO small_orders\n" +
                "\tWHEN order_total > 1000000 AND order_total <= 200000 THEN\n" +
                "\t\tINTO medium_orders\n" +
                "\tWHEN order_total > 200000 THEN\n" +
                "\t\tINTO large_orders\n" +
                "SELECT order_id, order_total, sales_rep_id, customer_id\n" +
                "FROM orders;", format);
    }

    @Test
    public void test3() {
        String sql = "INSERT ALL \n" +
                "  /* Everyone is a person, so insert all rows into people */ \n" +
                "  WHEN 1=1 THEN \n" +
                "    INTO people (person_id, given_name, family_name, title) \n" +
                "    VALUES (id, given_name, family_name, title) \n" +
                "  /* Only people with an admission date are patients */ \n" +
                "  WHEN admission_date IS NOT NULL THEN \n" +
                "    INTO patients (patient_id, last_admission_date) \n" +
                "    VALUES (id, admission_date) \n" +
                "  /* Only people with a hired date are staff */ \n" +
                "  WHEN hired_date IS NOT NULL THEN \n" +
                "    INTO staff (staff_id, hired_date) \n" +
                "    VALUES (id, hired_date) \n" +
                "  WITH names AS ( \n" +
                "    SELECT 4 id, 'Ruth' given_name, 'Fox' family_name, 'Mrs' title, \n" +
                "           NULL hired_date, DATE'2009-12-31' admission_date \n" +
                "    FROM   dual UNION ALL \n" +
                "    SELECT 5 id, 'Isabelle' given_name, 'Squirrel' family_name, 'Miss' title , \n" +
                "           NULL hired_date, DATE'2014-01-01' admission_date \n" +
                "    FROM   dual UNION ALL \n" +
                "    SELECT 6 id, 'Justin' given_name, 'Frog' family_name, 'Master' title, \n" +
                "           NULL hired_date, DATE'2015-04-22' admission_date \n" +
                "    FROM   dual UNION ALL \n" +
                "    SELECT 7 id, 'Lisa' given_name, 'Owl' family_name, 'Dr' title, \n" +
                "           DATE'2015-01-01' hired_date, NULL admission_date \n" +
                "    FROM   dual \n" +
                "  ) \n" +
                "  SELECT * FROM names;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT ALL\n" +
                "\tWHEN 1 = 1 THEN\n" +
                "\t\tINTO people (person_id, given_name, family_name, title)\n" +
                "\t\tVALUES (id, given_name, family_name, title)\n" +
                "\tWHEN admission_date IS NOT NULL THEN\n" +
                "\t\tINTO patients (patient_id, last_admission_date)\n" +
                "\t\tVALUES (id, admission_date)\n" +
                "\tWHEN hired_date IS NOT NULL THEN\n" +
                "\t\tINTO staff (staff_id, hired_date)\n" +
                "\t\tVALUES (id, hired_date)\n" +
                "WITH\n" +
                "\tnames AS (\n" +
                "\t\tSELECT 4 id, 'Ruth' given_name, 'Fox' family_name, 'Mrs' title,\n" +
                "\t\t\tNULL hired_date, DATE '2009-12-31' admission_date\n" +
                "\t\tFROM dual\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT 5 id, 'Isabelle' given_name, 'Squirrel' family_name, 'Miss' title,\n" +
                "\t\t\tNULL hired_date, DATE '2014-01-01' admission_date\n" +
                "\t\tFROM dual\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT 6 id, 'Justin' given_name, 'Frog' family_name, 'Master' title,\n" +
                "\t\t\tNULL hired_date, DATE '2015-04-22' admission_date\n" +
                "\t\tFROM dual\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT 7 id, 'Lisa' given_name, 'Owl' family_name, 'Dr' title,\n" +
                "\t\t\tDATE '2015-01-01' hired_date, NULL admission_date\n" +
                "\t\tFROM dual\n" +
                "\t)\n" +
                "SELECT *\n" +
                "FROM names;", format);
    }


    @Test
    public void test4() {
        String sql = "INSERT FIRST\n" +
                "   WHEN ottl <= 100000 THEN\n" +
                "      INTO small_orders\n" +
                "         VALUES(oid, ottl, sid, cid)\n" +
                "   WHEN ottl > 100000 and ottl <= 200000 THEN\n" +
                "      INTO medium_orders\n" +
                "         VALUES(oid, ottl, sid, cid)\n" +
                "   WHEN ottl > 290000 THEN\n" +
                "      INTO special_orders\n" +
                "   WHEN ottl > 200000 THEN\n" +
                "      INTO large_orders\n" +
                "         VALUES(oid, ottl, sid, cid)\n" +
                "   SELECT o.order_id oid, o.customer_id cid, o.order_total ottl,\n" +
                "      o.sales_rep_id sid, c.credit_limit cl, c.cust_email cem\n" +
                "      FROM orders o, customers c\n" +
                "      WHERE o.customer_id = c.customer_id;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT FIRST\n" +
                "\tWHEN ottl <= 100000 THEN\n" +
                "\t\tINTO small_orders\n" +
                "\t\tVALUES (oid, ottl, sid, cid)\n" +
                "\tWHEN ottl > 100000 AND ottl <= 200000 THEN\n" +
                "\t\tINTO medium_orders\n" +
                "\t\tVALUES (oid, ottl, sid, cid)\n" +
                "\tWHEN ottl > 290000 THEN\n" +
                "\t\tINTO special_orders\n" +
                "\tWHEN ottl > 200000 THEN\n" +
                "\t\tINTO large_orders\n" +
                "\t\tVALUES (oid, ottl, sid, cid)\n" +
                "SELECT o.order_id oid, o.customer_id cid, o.order_total ottl,\n" +
                "\to.sales_rep_id sid, c.credit_limit cl, c.cust_email cem\n" +
                "FROM orders o, customers c\n" +
                "WHERE o.customer_id = c.customer_id;", format);
    }
}
