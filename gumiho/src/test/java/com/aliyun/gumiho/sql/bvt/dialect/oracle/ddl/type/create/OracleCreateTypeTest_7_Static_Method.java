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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.type.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateTypeTest_7_Static_Method {

    @Test
    public void test1() {
        String s = "CREATE OR REPLACE TYPE department_t AS OBJECT (\n" +
                "   deptno number(10),\n" +
                "   dname CHAR(30));\n" +
                "\n" +
                "CREATE OR REPLACE TYPE employee_t AS OBJECT(\n" +
                "   empid RAW(16),\n" +
                "   ename CHAR(31),\n" +
                "   dept REF department_t,\n" +
                "      STATIC function construct_emp\n" +
                "      (name VARCHAR2, dept REF department_t)\n" +
                "      RETURN employee_t\n" +
                ");";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TYPE department_t AS OBJECT (\n" +
                "\tdeptno NUMBER(10),\n" +
                "\tdname CHAR(30)\n" +
                ");\n" +
                "CREATE OR REPLACE TYPE employee_t AS OBJECT (\n" +
                "\tempid RAW(16),\n" +
                "\tename CHAR(31),\n" +
                "\tdept REF department_t,\n" +
                "\tSTATIC FUNCTION construct_emp (\n" +
                "\t\tname VARCHAR2,\n" +
                "\t\tdept REF department_t\n" +
                "\t) RETURN employee_t\n" +
                ");", formatSQL);
    }
    
}
