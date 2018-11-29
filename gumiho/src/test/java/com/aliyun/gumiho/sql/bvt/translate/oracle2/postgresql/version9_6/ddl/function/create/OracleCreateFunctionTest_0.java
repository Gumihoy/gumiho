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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.function.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateFunctionTest_0 {

    @Test
    public void test() {
        String s = "CREATE FUNCTION get_bal(acc_no IN NUMBER) \n" +
                "   RETURN NUMBER \n" +
                "   IS acc_bal NUMBER(11,2);\n" +
                "   BEGIN \n" +
                "      SELECT order_total \n" +
                "      INTO acc_bal \n" +
                "      FROM orders \n" +
                "      WHERE customer_id = acc_no; \n" +
                "      RETURN(acc_bal); \n" +
                "    END;\n" +
                "/";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE FUNCTION get_bal (\n" +
                "\tacc_no IN NUMBER\n" +
                ") RETURN NUMBER\n" +
                "IS\n" +
                "\tacc_bal NUMBER(11, 2);\n" +
                "\tBEGIN\n" +
                "\t\tSELECT order_total\n" +
                "\t\tINTO acc_bal\n" +
                "\t\tFROM orders\n" +
                "\t\tWHERE customer_id = acc_no;\n" +
                "\t\tRETURN(acc_bal);\n" +
                "\tEND;", formatSQL);
    }
}
