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
public class OracleExistStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "DECLARE\n" +
                "  x NUMBER := 0;\n" +
                "BEGIN\n" +
                "  LOOP\n" +
                "    DBMS_OUTPUT.PUT_LINE ('Inside loop:  x = ' || TO_CHAR(x));\n" +
                "    x := x + 1;\n" +
                "    IF x > 3 THEN\n" +
                "      EXIT;\n" +
                "    END IF;\n" +
                "  END LOOP;\n" +
                "  -- After EXIT, control resumes here\n" +
                "  DBMS_OUTPUT.PUT_LINE(' After loop:  x = ' || TO_CHAR(x));\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tx NUMBER := 0;\n" +
                "BEGIN\n" +
                "\tLOOP\n" +
                "\t\tDBMS_OUTPUT.PUT_LINE('Inside loop:  x = ' || TO_CHAR(x));\n" +
                "\t\tx := x + 1;\n" +
                "\t\tIF x > 3 THEN\n" +
                "\t\t\tEXIT;\n" +
                "\t\tEND IF;\n" +
                "\tEND LOOP;\n" +
                "\tDBMS_OUTPUT.PUT_LINE(' After loop:  x = ' || TO_CHAR(x));\n" +
                "END;", format);
    }

    @Test
    public void test_1() {
        String sql = "DECLARE\n" +
                "  x NUMBER := 0;\n" +
                "BEGIN\n" +
                "  LOOP\n" +
                "    DBMS_OUTPUT.PUT_LINE('Inside loop:  x = ' || TO_CHAR(x));\n" +
                "    x := x + 1;  -- prevents infinite loop\n" +
                "    EXIT WHEN x > 3;\n" +
                "  END LOOP;\n" +
                "  -- After EXIT statement, control resumes here\n" +
                "  DBMS_OUTPUT.PUT_LINE('After loop:  x = ' || TO_CHAR(x));\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tx NUMBER := 0;\n" +
                "BEGIN\n" +
                "\tLOOP\n" +
                "\t\tDBMS_OUTPUT.PUT_LINE('Inside loop:  x = ' || TO_CHAR(x));\n" +
                "\t\tx := x + 1;\n" +
                "\t\tEXIT WHEN x > 3;\n" +
                "\tEND LOOP;\n" +
                "\tDBMS_OUTPUT.PUT_LINE('After loop:  x = ' || TO_CHAR(x));\n" +
                "END;", format);
    }
}
