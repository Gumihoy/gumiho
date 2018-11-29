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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.synonym.alter;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterSynonymTest_0 {

    @Test
    public void test1() {
        String s = "ALTER SYNONYM offices COMPILE; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER SYNONYM offices COMPILE;", format);
    }

    @Test
    public void test2() {
        String s = "ALTER PUBLIC SYNONYM emp_table COMPILE; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER PUBLIC SYNONYM emp_table COMPILE;", format);
    }

    @Test
    public void test3() {
        String s = "ALTER SYNONYM offices NONEDITIONABLE; ";

        String format = OracleUtils.format(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER SYNONYM offices NONEDITIONABLE;", format);
    }
}
