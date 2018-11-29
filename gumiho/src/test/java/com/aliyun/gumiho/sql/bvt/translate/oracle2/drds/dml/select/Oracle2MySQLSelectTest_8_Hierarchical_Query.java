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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class Oracle2MySQLSelectTest_8_Hierarchical_Query {

    @Test
    public void test1() {
        String sql = "SELECT DECODE(GROUPING(department_name), 1, 'All Departments',\n" +
                "      department_name) AS department_name,\n" +
                "   DECODE(GROUPING(job_id), 1, 'All Jobs', job_id) AS job_id,\n" +
                "   COUNT(*) \"Total Empl\", AVG(salary) * 12 \"Average Sal\"\n" +
                "   FROM employees e, departments d\n" +
                "   WHERE d.department_id = e.department_id\n" +
                "   GROUP BY CUBE (department_name, job_id)\n" +
                "   ORDER BY department_name, job_id;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DECODE(GROUPING(department_name), 1, 'All Departments', department_name) AS department_name,\n" +
                "\tDECODE(GROUPING(job_id), 1, 'All Jobs', job_id) AS job_id,\n" +
                "\tCOUNT(*) \"Total Empl\", AVG(salary) * 12 \"Average Sal\"\n" +
                "FROM employees e, departments d\n" +
                "WHERE d.department_id = e.department_id\n" +
                "GROUP BY CUBE (department_name, job_id)\n" +
                "ORDER BY department_name, job_id;", format);
    }


    @Test
    public void test2() {
        String sql = "SELECT channel_desc, calendar_month_desc, co.country_id,\n" +
                "      TO_CHAR(sum(amount_sold) , '9,999,999,999') SALES$\n" +
                "   FROM sales, customers, times, channels, countries co\n" +
                "   WHERE sales.time_id=times.time_id \n" +
                "      AND sales.cust_id=customers.cust_id \n" +
                "      AND sales.channel_id= channels.channel_id \n" +
                "      AND customers.country_id = co.country_id\n" +
                "      AND channels.channel_desc IN ('Direct Sales', 'Internet') \n" +
                "      AND times.calendar_month_desc IN ('2000-09', '2000-10')\n" +
                "      AND co.country_iso_code IN ('UK', 'US')\n" +
                "  GROUP BY GROUPING SETS( \n" +
                "      (channel_desc, calendar_month_desc, co.country_id), \n" +
                "      (channel_desc, co.country_id), \n" +
                "      (calendar_month_desc, co.country_id) );";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT channel_desc, calendar_month_desc, co.country_id,\n" +
                "\tTO_CHAR(sum(amount_sold), '9,999,999,999') SALES$\n" +
                "FROM sales, customers, times, channels, countries co\n" +
                "WHERE sales.time_id = times.time_id\n" +
                "\tAND sales.cust_id = customers.cust_id\n" +
                "\tAND sales.channel_id = channels.channel_id\n" +
                "\tAND customers.country_id = co.country_id\n" +
                "\tAND channels.channel_desc IN ('Direct Sales', 'Internet')\n" +
                "\tAND times.calendar_month_desc IN ('2000-09', '2000-10')\n" +
                "\tAND co.country_iso_code IN ('UK', 'US')\n" +
                "GROUP BY GROUPING SETS (\n" +
                "\t(channel_desc, calendar_month_desc, co.country_id),\n" +
                "\t(channel_desc, co.country_id),\n" +
                "\t(calendar_month_desc, co.country_id)\n" +
                ");", format);
    }

}
