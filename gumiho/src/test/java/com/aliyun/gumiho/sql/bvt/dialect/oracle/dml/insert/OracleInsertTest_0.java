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
public class OracleInsertTest_0 {

    @Test
    public void test1() {
        String sql = "INSERT INTO departments\n" +
                "   VALUES (280, 'Recreation', 121, 1700);";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO departments\n" +
                "VALUES (280, 'Recreation', 121, 1700);", format);
    }


    @Test
    public void test2() {
        String sql = "INSERT INTO departments\n" +
                "   VALUES (280, 'Recreation', DEFAULT, 1700);";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO departments\n" +
                "VALUES (280, 'Recreation', DEFAULT, 1700);", format);
    }

    @Test
    public void test3() {
        String sql = "INSERT INTO employees (employee_id, last_name, email, \n" +
                "      hire_date, job_id, salary, commission_pct) \n" +
                "   VALUES (207, 'Gregory', 'pgregory@example.com', \n" +
                "      sysdate, 'PU_CLERK', 1.2E3, NULL);";


        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO employees (employee_id, last_name, email, hire_date, job_id, salary, commission_pct)\n" +
                "VALUES (207, 'Gregory', 'pgregory@example.com', sysdate, 'PU_CLERK', 1.2E3, NULL);", format);
    }

    @Test
    public void test4() {
        String sql = "INSERT INTO \n" +
                "   (SELECT employee_id, last_name, email, hire_date, job_id, \n" +
                "      salary, commission_pct FROM employees) \n" +
                "   VALUES (207, 'Gregory', 'pgregory@example.com', \n" +
                "      sysdate, 'PU_CLERK', 1.2E3, NULL);";


        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO (\n" +
                "\tSELECT employee_id, last_name, email, hire_date, job_id, salary, commission_pct\n" +
                "\tFROM employees\n" +
                ")\n" +
                "VALUES (207, 'Gregory', 'pgregory@example.com', sysdate, 'PU_CLERK', 1.2E3, NULL);", format);
    }
}
