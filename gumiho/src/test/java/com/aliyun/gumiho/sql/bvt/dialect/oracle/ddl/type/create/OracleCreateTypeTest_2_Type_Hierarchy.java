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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.type.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateTypeTest_2_Type_Hierarchy {

    @Test
    public void test1() {
        String s = "CREATE TYPE person_t AS OBJECT (name VARCHAR2(100), ssn NUMBER) \n" +
                "   NOT FINAL;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE person_t AS OBJECT (\n" +
                "\tname VARCHAR2(100),\n" +
                "\tssn NUMBER\n" +
                ")\n" +
                "NOT FINAL;", formatSQL);
    }

    @Test
    public void test2() {
        String s = "CREATE TYPE employee_t UNDER person_t \n" +
                "   (department_id NUMBER, salary NUMBER) NOT FINAL;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE employee_t UNDER person_t (\n" +
                "\tdepartment_id NUMBER,\n" +
                "\tsalary NUMBER\n" +
                ")\n" +
                "NOT FINAL;", formatSQL);
    }

    @Test
    public void test3() {
        String s = "CREATE TYPE part_time_emp_t UNDER employee_t (num_hrs NUMBER);";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE part_time_emp_t UNDER employee_t (\n" +
                "\tnum_hrs NUMBER\n" +
                ");", formatSQL);
    }
}
