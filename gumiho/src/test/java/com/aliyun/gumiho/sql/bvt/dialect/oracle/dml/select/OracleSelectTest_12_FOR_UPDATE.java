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
public class OracleSelectTest_12_FOR_UPDATE {

    @Test
    public void test1() {
        String sql = "SELECT e.employee_id, e.salary, e.commission_pct\n" +
                "   FROM employees e, departments d\n" +
                "   WHERE job_id = 'SA_REP'\n" +
                "   AND e.department_id = d.department_id\n" +
                "   AND location_id = 2500\n" +
                "   ORDER BY e.employee_id\n" +
                "   FOR UPDATE;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT e.employee_id, e.salary, e.commission_pct\n" +
                "FROM employees e, departments d\n" +
                "WHERE job_id = 'SA_REP' AND e.department_id = d.department_id\n" +
                "\tAND location_id = 2500\n" +
                "ORDER BY e.employee_id\n" +
                "FOR UPDATE;", format);
    }


    @Test
    public void test2() {
        String sql = "SELECT e.employee_id, e.salary, e.commission_pct\n" +
                "   FROM employees e JOIN departments d\n" +
                "   USING (department_id)\n" +
                "   WHERE job_id = 'SA_REP'\n" +
                "   AND location_id = 2500\n" +
                "   ORDER BY e.employee_id\n" +
                "   FOR UPDATE OF e.salary;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT e.employee_id, e.salary, e.commission_pct\n" +
                "FROM employees e\n" +
                "\tJOIN departments d USING (department_id)\n" +
                "WHERE job_id = 'SA_REP' AND location_id = 2500\n" +
                "ORDER BY e.employee_id\n" +
                "FOR UPDATE OF e.salary;", format);
    }



}
