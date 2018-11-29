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
public class OracleSelectTest_11_Row_Limiting {

    @Test
    public void test1() {
        String sql = "SELECT employee_id, last_name\n" +
                "  FROM employees\n" +
                "  ORDER BY employee_id\n" +
                "  FETCH FIRST 5 ROWS ONLY;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name\n" +
                "FROM employees\n" +
                "ORDER BY employee_id\n" +
                "FETCH FIRST 5 ROWS ONLY;", format);
    }


    @Test
    public void test2() {
        String sql = "SELECT employee_id, last_name\n" +
                "  FROM employees\n" +
                "  ORDER BY employee_id\n" +
                "  OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name\n" +
                "FROM employees\n" +
                "ORDER BY employee_id\n" +
                "OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY;", format);
    }


    @Test
    public void test3() {
        String sql = "SELECT employee_id, last_name, salary\n" +
                "  FROM employees\n" +
                "  ORDER BY salary\n" +
                "  FETCH FIRST 5 PERCENT ROWS ONLY;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name, salary\n" +
                "FROM employees\n" +
                "ORDER BY salary\n" +
                "FETCH FIRST 5 PERCENT ROWS ONLY;", format);
    }

    @Test
    public void test4() {
        String sql = "SELECT employee_id, last_name, salary\n" +
                "  FROM employees\n" +
                "  ORDER BY salary\n" +
                "  FETCH FIRST 5 PERCENT ROWS WITH TIES;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name, salary\n" +
                "FROM employees\n" +
                "ORDER BY salary\n" +
                "FETCH FIRST 5 PERCENT ROWS WITH TIES;", format);
    }
}
