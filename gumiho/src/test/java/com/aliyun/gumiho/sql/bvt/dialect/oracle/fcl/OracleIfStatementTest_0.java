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
public class OracleIfStatementTest_0 {

    @Test
    public void test_0() {
        String sql = "DECLARE\n" +
                "  PROCEDURE p (\n" +
                "    sales  NUMBER,\n" +
                "    quota  NUMBER,\n" +
                "    emp_id NUMBER\n" +
                "  )\n" +
                "  IS\n" +
                "    bonus    NUMBER := 0;\n" +
                "    updated  VARCHAR2(3) := 'No';\n" +
                "  BEGIN\n" +
                "    IF sales > (quota + 200) THEN\n" +
                "      bonus := (sales - quota)/4;\n" +
                " \n" +
                "      UPDATE employees\n" +
                "      SET salary = salary + bonus \n" +
                "      WHERE employee_id = emp_id;\n" +
                " \n" +
                "      updated := 'Yes';\n" +
                "    END IF;\n" +
                " \n" +
                "    DBMS_OUTPUT.PUT_LINE (\n" +
                "      'Table updated?  ' || updated || ', ' || \n" +
                "      'bonus = ' || bonus || '.'\n" +
                "    );\n" +
                "  END p;\n" +
                "BEGIN\n" +
                "  p(10100, 10000, 120);\n" +
                "  p(10500, 10000, 121);\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tPROCEDURE p (\n" +
                "\t\tsales NUMBER,\n" +
                "\t\tquota NUMBER,\n" +
                "\t\temp_id NUMBER\n" +
                "\t) IS\n" +
                "\t\tbonus NUMBER := 0;\n" +
                "\t\tupdated VARCHAR2(3) := 'No';\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF sales > (quota + 200) THEN\n" +
                "\t\t\t\tbonus := (sales - quota) / 4;\n" +
                "\t\t\t\tUPDATE employees\n" +
                "\t\t\t\tSET salary = salary + bonus\n" +
                "\t\t\t\tWHERE employee_id = emp_id;\n" +
                "\t\t\t\tupdated := 'Yes';\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tDBMS_OUTPUT.PUT_LINE('Table updated?  ' || updated || ', ' || 'bonus = ' || bonus || '.');\n" +
                "\t\tEND p;\n" +
                "BEGIN\n" +
                "\tp(10100, 10000, 120);\n" +
                "\tp(10500, 10000, 121);\n" +
                "END;", format);
    }

}
