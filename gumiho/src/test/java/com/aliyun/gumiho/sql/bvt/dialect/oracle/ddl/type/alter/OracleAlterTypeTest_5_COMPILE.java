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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.type.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleAlterTypeTest_5_COMPILE {

    @Test
    public void test_0() {
        String s = "ALTER TYPE cust_address_typ2 COMPILE; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TYPE cust_address_typ2\n" +
                "\tCOMPILE;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "ALTER TYPE link2 COMPILE SPECIFICATION; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TYPE link2\n" +
                "\tCOMPILE SPECIFICATION;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "ALTER TYPE link2 COMPILE BODY; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TYPE link2\n" +
                "\tCOMPILE BODY;", formatSQL);
    }


}
