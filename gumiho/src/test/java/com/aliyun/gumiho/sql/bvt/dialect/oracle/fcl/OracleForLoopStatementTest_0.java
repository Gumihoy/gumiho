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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.fcl;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleForLoopStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "BEGIN\n" +
                "  FOR i IN 1..3 LOOP\n" +
                "    IF i < 3 THEN\n" +
                "      DBMS_OUTPUT.PUT_LINE (TO_CHAR(i));\n" +
                "    ELSE\n" +
                "      i := 2;\n" +
                "    END IF;\n" +
                "  END LOOP;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("BEGIN\n" +
                "\tFOR i IN 1 .. 3 LOOP\n" +
                "\t\tIF i < 3 THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE(TO_CHAR(i));\n" +
                "\t\tELSE\n" +
                "\t\t\ti := 2;\n" +
                "\t\tEND IF;\n" +
                "\tEND LOOP;\n" +
                "END;", format);
    }

    @Test
    public void test_1() {
        String sql = "BEGIN\n" +
                "  FOR i IN 1..3 LOOP\n" +
                "    DBMS_OUTPUT.PUT_LINE ('Inside loop, i is ' || TO_CHAR(i));\n" +
                "  END LOOP;\n" +
                "  \n" +
                "  DBMS_OUTPUT.PUT_LINE ('Outside loop, i is ' || TO_CHAR(i));\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("BEGIN\n" +
                "\tFOR i IN 1 .. 3 LOOP\n" +
                "\t\tDBMS_OUTPUT.PUT_LINE('Inside loop, i is ' || TO_CHAR(i));\n" +
                "\tEND LOOP;\n" +
                "\tDBMS_OUTPUT.PUT_LINE('Outside loop, i is ' || TO_CHAR(i));\n" +
                "END;", format);
    }
}
