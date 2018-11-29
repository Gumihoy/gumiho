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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.procedure.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateProcedureTest_0 {

    @Test
    public void test() {
        String s = "CREATE PROCEDURE remove_emp (employee_id NUMBER) AS\n" +
                "   tot_emps NUMBER;\n" +
                "   BEGIN\n" +
                "      DELETE FROM employees\n" +
                "      WHERE employees.employee_id = remove_emp.employee_id;\n" +
                "   tot_emps := tot_emps - 1;\n" +
                "   END;\n" +
                "/";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE PROCEDURE remove_emp (\n" +
                "\temployee_id NUMBER\n" +
                ")\n" +
                "AS\n" +
                "\ttot_emps NUMBER;\n" +
                "\tBEGIN\n" +
                "\t\tDELETE FROM employees\n" +
                "\t\tWHERE employees.employee_id = remove_emp.employee_id;\n" +
                "\t\ttot_emps := tot_emps - 1;\n" +
                "\tEND;", formatSQL);
    }
}
