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
public class OracleGotoStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "DECLARE\n" +
                "  p  VARCHAR2(30);\n" +
                "  n  PLS_INTEGER := 37;\n" +
                "BEGIN\n" +
                "  FOR j in 2..ROUND(SQRT(n)) LOOP\n" +
                "    IF n MOD j = 0 THEN\n" +
                "      p := ' is not a prime number';\n" +
                "      GOTO print_now;\n" +
                "    END IF;\n" +
                "  END LOOP;\n" +
                "\n" +
                "  p := ' is a prime number';\n" +
                " \n" +
                "  <<print_now>>\n" +
                "  DBMS_OUTPUT.PUT_LINE(TO_CHAR(n) || p);\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tp VARCHAR2(30);\n" +
                "\tn PLS_INTEGER := 37;\n" +
                "BEGIN\n" +
                "\tFOR j IN 2 .. ROUND(SQRT(n)) LOOP\n" +
                "\t\tIF n MOD j = 0 THEN\n" +
                "\t\t\tp := ' is not a prime number';\n" +
                "\t\t\tGOTO print_now;\n" +
                "\t\tEND IF;\n" +
                "\tEND LOOP;\n" +
                "\tp := ' is a prime number';\n" +
                "\t<<print_now>>\n" +
                "\tDBMS_OUTPUT.PUT_LINE(TO_CHAR(n) || p);\n" +
                "END;", format);
    }

    @Test
    public void test_1() {
        String sql = "DECLARE\n" +
                "  done  BOOLEAN;\n" +
                "BEGIN\n" +
                "  FOR i IN 1..50 LOOP\n" +
                "    IF done THEN\n" +
                "       GOTO end_loop;\n" +
                "    END IF;\n" +
                "    <<end_loop>>\n" +
                "  END LOOP;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "  done  BOOLEAN;\n" +
                "BEGIN\n" +
                "  FOR i IN 1..50 LOOP\n" +
                "    IF done THEN\n" +
                "       GOTO end_loop;\n" +
                "    END IF;\n" +
                "    <<end_loop>>\n" +
                "  END LOOP;\n" +
                "END;", format);
    }
}
