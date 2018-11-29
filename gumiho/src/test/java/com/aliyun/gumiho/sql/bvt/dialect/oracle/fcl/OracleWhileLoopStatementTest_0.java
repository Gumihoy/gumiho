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
public class OracleWhileLoopStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "DECLARE\n" +
                "  done  BOOLEAN := FALSE;\n" +
                "BEGIN\n" +
                "  WHILE done LOOP\n" +
                "    DBMS_OUTPUT.PUT_LINE ('This line does not print.');\n" +
                "    done := TRUE;  -- This assignment is not made.\n" +
                "  END LOOP;\n" +
                "\n" +
                "  WHILE NOT done LOOP\n" +
                "    DBMS_OUTPUT.PUT_LINE ('Hello, world!');\n" +
                "    done := TRUE;\n" +
                "  END LOOP;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tdone BOOLEAN := FALSE;\n" +
                "BEGIN\n" +
                "\tWHILE done LOOP\n" +
                "\t\tDBMS_OUTPUT.PUT_LINE('This line does not print.');\n" +
                "\t\tdone := TRUE;\n" +
                "\tEND LOOP;\n" +
                "\tWHILE NOT done LOOP\n" +
                "\t\tDBMS_OUTPUT.PUT_LINE('Hello, world!');\n" +
                "\t\tdone := TRUE;\n" +
                "\tEND LOOP;\n" +
                "END;", format);
    }

}
