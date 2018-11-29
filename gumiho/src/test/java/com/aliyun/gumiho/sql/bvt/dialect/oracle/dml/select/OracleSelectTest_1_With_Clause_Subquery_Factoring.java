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
public class OracleSelectTest_1_With_Clause_Subquery_Factoring {

    @Test
    public void test1() {
        String sql = "WITH \n" +
                "   dept_costs AS (\n" +
                "      SELECT department_name, SUM(salary) dept_total\n" +
                "         FROM employees e, departments d\n" +
                "         WHERE e.department_id = d.department_id\n" +
                "      GROUP BY department_name),\n" +
                "   avg_cost AS (\n" +
                "      SELECT SUM(dept_total)/COUNT(*) avg\n" +
                "      FROM dept_costs)\n" +
                "SELECT * FROM dept_costs\n" +
                "   WHERE dept_total >\n" +
                "      (SELECT avg FROM avg_cost) OR A = 1\n" +
                "      ORDER BY department_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\tdept_costs AS (\n" +
                "\t\tSELECT department_name, SUM(salary) dept_total\n" +
                "\t\tFROM employees e, departments d\n" +
                "\t\tWHERE e.department_id = d.department_id\n" +
                "\t\tGROUP BY department_name\n" +
                "\t),\n" +
                "\tavg_cost AS (\n" +
                "\t\tSELECT SUM(dept_total) / COUNT(*) avg\n" +
                "\t\tFROM dept_costs\n" +
                "\t)\n" +
                "SELECT *\n" +
                "FROM dept_costs\n" +
                "WHERE dept_total > (\n" +
                "\t\tSELECT avg\n" +
                "\t\tFROM avg_cost\n" +
                "\t) OR A = 1\n" +
                "ORDER BY department_name;", format);
    }
}
