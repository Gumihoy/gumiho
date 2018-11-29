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
public class OracleInsertTest_6_Substitutable_Tables_and_Columns {

    @Test
    public void test1() {
        String sql = "INSERT INTO persons VALUES (person_t('Bob', 1234));\n" +
                "INSERT INTO persons VALUES (employee_t('Joe', 32456, 12, 100000));\n" +
                "INSERT INTO persons VALUES (\n" +
                "   part_time_emp_t('Tim', 5678, 13, 1000, 20));";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO persons\n" +
                "VALUES (person_t('Bob', 1234));\n" +
                "INSERT INTO persons\n" +
                "VALUES (employee_t('Joe', 32456, 12, 100000));\n" +
                "INSERT INTO persons\n" +
                "VALUES (part_time_emp_t('Tim', 5678, 13, 1000, 20));", format);
    }


    @Test
    public void test2() {
        String sql = "INSERT INTO books VALUES (\n" +
                "   'An Autobiography', person_t('Bob', 1234));\n" +
                "INSERT INTO books VALUES (\n" +
                "   'Business Rules', employee_t('Joe', 3456, 12, 10000));\n" +
                "INSERT INTO books VALUES (\n" +
                "   'Mixing School and Work', \n" +
                "   part_time_emp_t('Tim', 5678, 13, 1000, 20));";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO books\n" +
                "VALUES ('An Autobiography', person_t('Bob', 1234));\n" +
                "INSERT INTO books\n" +
                "VALUES ('Business Rules', employee_t('Joe', 3456, 12, 10000));\n" +
                "INSERT INTO books\n" +
                "VALUES ('Mixing School and Work', part_time_emp_t('Tim', 5678, 13, 1000, 20));", format);
    }
}
