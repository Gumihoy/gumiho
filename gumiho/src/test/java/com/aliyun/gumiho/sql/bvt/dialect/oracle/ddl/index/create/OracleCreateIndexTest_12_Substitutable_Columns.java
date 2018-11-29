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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.index.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateIndexTest_12_Substitutable_Columns {

    @Test
    public void test1() {
        String s = "CREATE INDEX salary_i \n" +
                "   ON books (TREAT(author AS employee_t).salary); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX salary_i ON books (\n" +
                "\tTREAT(author AS employee_t).salary\n" +
                ");", formatSQL);
    }


    @Test
    public void test2() {
        String s = "CREATE INDEX salary_func_i ON persons p\n" +
                "   (TREAT(VALUE(p) AS part_time_emp_t).salary); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX salary_func_i ON persons p (\n" +
                "\tTREAT(VALUE(p) AS part_time_emp_t).salary\n" +
                ");", formatSQL);
    }

    @Test
    public void test3() {
        String s = "CREATE BITMAP INDEX typeid_i ON books (SYS_TYPEID(author)); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE BITMAP INDEX typeid_i ON books (\n" +
                "\tSYS_TYPEID(author)\n" +
                ");", formatSQL);
    }
}
