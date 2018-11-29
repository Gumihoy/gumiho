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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_14_Join {

    @Test
    public void test1() {
        String sql = "SELECT last_name, job_id, departments.department_id, department_name\n" +
                "   FROM employees, departments\n" +
                "   WHERE employees.department_id = departments.department_id\n" +
                "   ORDER BY last_name, job_id;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name, job_id, departments.department_id, department_name\n" +
                "FROM employees, departments\n" +
                "WHERE employees.department_id = departments.department_id\n" +
                "ORDER BY last_name, job_id;", format);
    }

    @Test
    public void test2() {
        String sql = "SELECT d.department_id, e.last_name\n" +
                "   FROM departments d LEFT OUTER JOIN employees e\n" +
                "   ON d.department_id = e.department_id\n" +
                "   ORDER BY d.department_id, e.last_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_id, e.last_name\n" +
                "FROM departments d\n" +
                "\tLEFT OUTER JOIN employees e ON d.department_id = e.department_id\n" +
                "ORDER BY d.department_id, e.last_name;", format);
    }


    @Test
    public void test3() {
        String sql = "SELECT d.department_id, e.last_name\n" +
                "   FROM departments d, employees e\n" +
                "   WHERE d.department_id = e.department_id(+)\n" +
                "   ORDER BY d.department_id, e.last_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_id, e.last_name\n" +
                "FROM departments d, employees e\n" +
                "WHERE d.department_id = e.department_id(+)\n" +
                "ORDER BY d.department_id, e.last_name;", format);
    }

    @Test
    public void test4() {
        String sql = "SELECT d.department_id, e.last_name\n" +
                "   FROM departments d RIGHT OUTER JOIN employees e\n" +
                "   ON d.department_id = e.department_id\n" +
                "   ORDER BY d.department_id, e.last_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_id, e.last_name\n" +
                "FROM departments d\n" +
                "\tRIGHT OUTER JOIN employees e ON d.department_id = e.department_id\n" +
                "ORDER BY d.department_id, e.last_name;", format);
    }

    @Test
    public void test5() {
        String sql = "SELECT d.department_id as d_dept_id, e.department_id as e_dept_id,\n" +
                "      e.last_name\n" +
                "   FROM departments d FULL OUTER JOIN employees e\n" +
                "   ON d.department_id = e.department_id\n" +
                "   ORDER BY d.department_id, e.last_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_id AS d_dept_id, e.department_id AS e_dept_id,\n" +
                "\te.last_name\n" +
                "FROM departments d\n" +
                "\tFULL OUTER JOIN employees e ON d.department_id = e.department_id\n" +
                "ORDER BY d.department_id, e.last_name;", format);
    }

    @Test
    public void test6() {
        String sql = "SELECT department_id AS d_e_dept_id, e.last_name\n" +
                "   FROM departments d FULL OUTER JOIN employees e\n" +
                "   USING (department_id)\n" +
                "   ORDER BY department_id, e.last_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT department_id AS d_e_dept_id, e.last_name\n" +
                "FROM departments d\n" +
                "\tFULL OUTER JOIN employees e USING (department_id)\n" +
                "ORDER BY department_id, e.last_name;", format);
    }


    @Test
    public void test7() {
        String sql = "SELECT times.time_id, product, quantity FROM inventory \n" +
                "   PARTITION BY  (product) \n" +
                "   RIGHT OUTER JOIN times ON (times.time_id = inventory.time_id) \n" +
                "   WHERE times.time_id BETWEEN TO_DATE('01/04/01', 'DD/MM/YY') \n" +
                "      AND TO_DATE('06/04/01', 'DD/MM/YY') \n" +
                "   ORDER BY  2,1; ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT times.time_id, product, quantity\n" +
                "FROM inventory PARTITION BY (product)\n" +
                "\tRIGHT OUTER JOIN times ON (times.time_id = inventory.time_id)\n" +
                "WHERE times.time_id BETWEEN TO_DATE('01/04/01', 'DD/MM/YY') AND TO_DATE('06/04/01', 'DD/MM/YY')\n" +
                "ORDER BY 2, 1;", format);
    }


    @Test
    public void test8() {
        String sql = "SELECT time_id, product, LAST_VALUE(quantity IGNORE NULLS) \n" +
                "   OVER (PARTITION BY product ORDER BY time_id) quantity \n" +
                "   FROM (SELECT times.time_id, product, quantity \n" +
                "             FROM (inventory PARTITION BY  (product) \n" +
                "                RIGHT OUTER JOIN times ON (times.time_id = inventory.time_id)) \n" +
                "   WHERE times.time_id BETWEEN TO_DATE('01/04/01', 'DD/MM/YY') \n" +
                "      AND TO_DATE('06/04/01', 'DD/MM/YY')) \n" +
                "   ORDER BY  2,1; ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT time_id, product,\n" +
                "\tLAST_VALUE(quantity IGNORE NULLS) OVER (PARTITION BY product ORDER BY time_id) quantity\n" +
                "FROM (\n" +
                "\tSELECT times.time_id, product, quantity\n" +
                "\tFROM (inventory PARTITION BY (product)\n" +
                "\t\tRIGHT OUTER JOIN times ON (times.time_id = inventory.time_id))\n" +
                "\tWHERE times.time_id BETWEEN TO_DATE('01/04/01', 'DD/MM/YY') AND TO_DATE('06/04/01', 'DD/MM/YY')\n" +
                ")\n" +
                "ORDER BY 2, 1;", format);
    }


    @Test
    public void test9() {
        String sql = "SELECT d.department_name, v.employee_id, v.last_name\n" +
                "  FROM departments d CROSS APPLY (SELECT * FROM employees e\n" +
                "                                  WHERE e.department_id = d.department_id) v\n" +
                "  WHERE d.department_name IN ('Marketing', 'Operations', 'Public Relations')\n" +
                "  ORDER BY d.department_name, v.employee_id;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_name, v.employee_id, v.last_name\n" +
                "FROM departments d\n" +
                "\tCROSS APPLY (\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM employees e\n" +
                "\t\tWHERE e.department_id = d.department_id\n" +
                "\t) v\n" +
                "WHERE d.department_name IN ('Marketing', 'Operations', 'Public Relations')\n" +
                "ORDER BY d.department_name, v.employee_id;", format);
    }


    @Test
    public void test10() {
        String sql = "SELECT d.department_name, v.employee_id, v.last_name\n" +
                "  FROM departments d OUTER APPLY (SELECT * FROM employees e\n" +
                "                                  WHERE e.department_id = d.department_id) v\n" +
                "  WHERE d.department_name IN ('Marketing', 'Operations', 'Public Relations')\n" +
                "  ORDER by d.department_name, v.employee_id;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT d.department_name, v.employee_id, v.last_name\n" +
                "FROM departments d\n" +
                "\tOUTER APPLY (\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM employees e\n" +
                "\t\tWHERE e.department_id = d.department_id\n" +
                "\t) v\n" +
                "WHERE d.department_name IN ('Marketing', 'Operations', 'Public Relations')\n" +
                "ORDER BY d.department_name, v.employee_id;", format);
    }
}
