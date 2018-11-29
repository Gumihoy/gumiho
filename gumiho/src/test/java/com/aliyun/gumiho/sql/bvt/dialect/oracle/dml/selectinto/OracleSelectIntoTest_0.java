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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.selectinto;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectIntoTest_0 {

    @Test
    public void test1() {
        String sql = "SELECT salary * 0.10 INTO bonus\n" +
                "  FROM employees\n" +
                "  WHERE employee_id = 100;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT salary * 0.10\n" +
                "INTO bonus\n" +
                "FROM employees\n" +
                "WHERE employee_id = 100;", format);
    }

    @Test
    public void test2() {
        String sql = " SELECT first_name, last_name, hire_date\n" +
                "    BULK COLLECT INTO stock_managers\n" +
                "    FROM employees\n" +
                "    WHERE job_id = 'ST_MAN'\n" +
                "    ORDER BY hire_date;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT first_name, last_name, hire_date\n" +
                "BULK COLLECT INTO stock_managers\n" +
                "FROM employees\n" +
                "WHERE job_id = 'ST_MAN'\n" +
                "ORDER BY hire_date;", format);
    }

    @Test
    public void test3() {
        String sql = "SELECT salary BULK COLLECT INTO sals FROM employees\n" +
                "    FETCH FIRST 50 ROWS ONLY;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT salary\n" +
                "BULK COLLECT INTO sals\n" +
                "FROM employees\n" +
                "FETCH FIRST 50 ROWS ONLY;", format);
    }
}
