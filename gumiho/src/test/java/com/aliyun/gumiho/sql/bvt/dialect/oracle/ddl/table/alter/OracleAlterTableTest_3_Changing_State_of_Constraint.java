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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterTableTest_3_Changing_State_of_Constraint {

    @Test
    public void test_1() {
        String s = "ALTER TABLE employees\n" +
                "   ENABLE VALIDATE CONSTRAINT emp_manager_fk\n" +
                "   EXCEPTIONS INTO exceptions; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tENABLE VALIDATE CONSTRAINT emp_manager_fk\n" +
                "\tEXCEPTIONS INTO exceptions;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "ALTER TABLE employees\n" +
                "   ENABLE NOVALIDATE PRIMARY KEY\n" +
                "   ENABLE NOVALIDATE CONSTRAINT emp_last_name_nn; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tENABLE NOVALIDATE PRIMARY KEY\n" +
                "\tENABLE NOVALIDATE CONSTRAINT emp_last_name_nn;", formatSQL);
    }


    @Test
    public void test_3() {
        String s = "ALTER TABLE locations\n" +
                "   MODIFY PRIMARY KEY DISABLE CASCADE; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE locations\n" +
                "\tMODIFY PRIMARY KEY DISABLE CASCADE;", formatSQL);
    }
}
