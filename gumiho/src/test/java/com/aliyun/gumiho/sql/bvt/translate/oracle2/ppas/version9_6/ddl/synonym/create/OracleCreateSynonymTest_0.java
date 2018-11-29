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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.synonym.create;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateSynonymTest_0 {

    @Test
    public void test1() {
        String s = "CREATE SYNONYM offices \n" +
                "   FOR hr.locations; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE SYNONYM offices FOR hr.locations;", format);
    }

    @Test
    public void test2() {
        String s = "CREATE PUBLIC SYNONYM emp_table \n" +
                "   FOR hr.employees@remote.us.example.com; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE PUBLIC SYNONYM emp_table FOR hr.employees@remote.us.example.com;", format);
    }

    @Test
    public void test3() {
        String s = "CREATE PUBLIC SYNONYM customers FOR oe.customers; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE PUBLIC SYNONYM customers FOR oe.customers;", format);
    }
}
