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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.update;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleUpdateTest_0_Updating_a_Table {

    @Test
    public void test_0() {
        String sql = "UPDATE employees\n" +
                "   SET commission_pct = NULL\n" +
                "   WHERE job_id = 'SH_CLERK';";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees\n" +
                "SET commission_pct = NULL\n" +
                "WHERE job_id = 'SH_CLERK';", format);
    }


    @Test
    public void test_1() {
        String sql = "UPDATE employees SET \n" +
                "    job_id = 'SA_MAN', salary = salary + 1000, department_id = 120，salary = salary + 1000  \n" +
                "    WHERE first_name||' '||last_name = 'Douglas Grant'; ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees\n" +
                "SET job_id = 'SA_MAN', salary = salary + 1000, department_id = 120,\n" +
                "\tsalary = salary + 1000\n" +
                "WHERE first_name || ' ' || last_name = 'Douglas Grant';", format);
    }

    @Test
    public void test_2() {
        String sql = "UPDATE employees@remote\n" +
                "   SET salary = salary*1.1\n" +
                "   WHERE last_name = 'Baer';\n";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees@remote\n" +
                "SET salary = salary * 1.1\n" +
                "WHERE last_name = 'Baer';", format);
    }


    @Test
    public void test_3() {
        String sql = "UPDATE employees a \n" +
                "    SET department_id = \n" +
                "        (SELECT department_id \n" +
                "            FROM departments \n" +
                "            WHERE location_id = '2100'), \n" +
                "        (salary, commission_pct) = \n" +
                "        (SELECT 1.1*AVG(salary), 1.5*AVG(commission_pct) \n" +
                "          FROM employees b \n" +
                "          WHERE a.department_id = b.department_id) \n" +
                "    WHERE department_id IN \n" +
                "        (SELECT department_id \n" +
                "          FROM departments\n" +
                "          WHERE location_id = 2900 \n" +
                "              OR location_id = 2700); ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees a\n" +
                "SET department_id = (\n" +
                "\t\tSELECT department_id\n" +
                "\t\tFROM departments\n" +
                "\t\tWHERE location_id = '2100'\n" +
                "\t),\n" +
                "\t(salary, commission_pct) = (\n" +
                "\t\tSELECT 1.1 * AVG(salary), 1.5 * AVG(commission_pct)\n" +
                "\t\tFROM employees b\n" +
                "\t\tWHERE a.department_id = b.department_id\n" +
                "\t)\n" +
                "WHERE department_id IN (\n" +
                "\t\tSELECT department_id\n" +
                "\t\tFROM departments\n" +
                "\t\tWHERE location_id = 2900 OR location_id = 2700\n" +
                "\t);", format);
    }
}
