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
public class OracleCaseStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "DECLARE\n" +
                "  grade CHAR(1);\n" +
                "BEGIN\n" +
                "  grade := 'B';\n" +
                "\n" +
                "  CASE grade\n" +
                "    WHEN 'A' THEN DBMS_OUTPUT.PUT_LINE('Excellent');\n" +
                "    WHEN 'B' THEN DBMS_OUTPUT.PUT_LINE('Very Good');\n" +
                "    WHEN 'C' THEN DBMS_OUTPUT.PUT_LINE('Good');\n" +
                "    WHEN 'D' THEN DBMS_OUTPUT.PUT_LINE('Fair');\n" +
                "    WHEN 'F' THEN DBMS_OUTPUT.PUT_LINE('Poor');\n" +
                "    ELSE DBMS_OUTPUT.PUT_LINE('No such grade');\n" +
                "  END CASE;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tgrade CHAR(1);\n" +
                "BEGIN\n" +
                "\tgrade := 'B';\n" +
                "\tCASE grade\n" +
                "\t\tWHEN 'A' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Excellent');\n" +
                "\t\tWHEN 'B' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Very Good');\n" +
                "\t\tWHEN 'C' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Good');\n" +
                "\t\tWHEN 'D' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Fair');\n" +
                "\t\tWHEN 'F' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Poor');\n" +
                "\t\tELSE\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('No such grade');;\n" +
                "\tEND CASE;\n" +
                "END;", format);
    }

    @Test
    public void test_1() {
        String sql = "DECLARE\n" +
                "  grade CHAR(1);\n" +
                "BEGIN\n" +
                "  grade := 'B';\n" +
                "  \n" +
                "  CASE\n" +
                "    WHEN grade = 'A' THEN DBMS_OUTPUT.PUT_LINE('Excellent');\n" +
                "    WHEN grade = 'B' THEN DBMS_OUTPUT.PUT_LINE('Very Good');\n" +
                "    WHEN grade = 'C' THEN DBMS_OUTPUT.PUT_LINE('Good');\n" +
                "    WHEN grade = 'D' THEN DBMS_OUTPUT.PUT_LINE('Fair');\n" +
                "    WHEN grade = 'F' THEN DBMS_OUTPUT.PUT_LINE('Poor');\n" +
                "    ELSE DBMS_OUTPUT.PUT_LINE('No such grade');\n" +
                "  END CASE;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tgrade CHAR(1);\n" +
                "BEGIN\n" +
                "\tgrade := 'B';\n" +
                "\tCASE\n" +
                "\t\tWHEN grade = 'A' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Excellent');\n" +
                "\t\tWHEN grade = 'B' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Very Good');\n" +
                "\t\tWHEN grade = 'C' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Good');\n" +
                "\t\tWHEN grade = 'D' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Fair');\n" +
                "\t\tWHEN grade = 'F' THEN\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Poor');\n" +
                "\t\tELSE\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('No such grade');;\n" +
                "\tEND CASE;\n" +
                "END;", format);
    }
}
