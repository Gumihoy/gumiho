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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.trigger.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class OracleCreateTriggerTest_3_System_Triggers {

    @Test
    public void test_0() {
        String s = "CREATE OR REPLACE TRIGGER drop_trigger\n" +
                "  BEFORE DROP ON hr.SCHEMA\n" +
                "  BEGIN\n" +
                "    RAISE_APPLICATION_ERROR (\n" +
                "      num => -20000,\n" +
                "      msg => 'Cannot drop object');\n" +
                "  END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER drop_trigger\n" +
                "\tBEFORE\n" +
                "\t\tDROP\n" +
                "\tON hr.SCHEMA\n" +
                "\tBEGIN\n" +
                "\t\tRAISE_APPLICATION_ERROR(num => -20000, msg => 'Cannot drop object');\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "CREATE TRIGGER log_errors\n" +
                "  AFTER SERVERERROR ON DATABASE\n" +
                "  BEGIN\n" +
                "    IF (IS_SERVERERROR (1017)) THEN\n" +
                "      NULL;  -- (substitute code that processes logon error)\n" +
                "    ELSE\n" +
                "      NULL;  -- (substitute code that logs error code)\n" +
                "    END IF;\n" +
                "  END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TRIGGER log_errors\n" +
                "\tAFTER\n" +
                "\t\tSERVERERROR\n" +
                "\tON DATABASE\n" +
                "\tBEGIN\n" +
                "\t\tIF (IS_SERVERERROR(1017)) THEN\n" +
                "\t\t\tNULL;\n" +
                "\t\tELSE\n" +
                "\t\t\tNULL;\n" +
                "\t\tEND IF;\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_2() {
        String s = "CREATE OR REPLACE TRIGGER check_user\n" +
                "  AFTER LOGON ON DATABASE\n" +
                "  BEGIN\n" +
                "    check_user;\n" +
                "  EXCEPTION\n" +
                "    WHEN OTHERS THEN\n" +
                "      RAISE_APPLICATION_ERROR\n" +
                "        (-20000, 'Unexpected error: '|| DBMS_Utility.Format_Error_Stack);\n" +
                " END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER check_user\n" +
                "\tAFTER\n" +
                "\t\tLOGON\n" +
                "\tON DATABASE\n" +
                "\tBEGIN\n" +
                "\t\tcheck_user;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\tRAISE_APPLICATION_ERROR(-20000, 'Unexpected error: ' || DBMS_Utility.Format_Error_Stack);\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_3() {
        String s = "CREATE OR REPLACE TRIGGER t\n" +
                "  INSTEAD OF CREATE ON SCHEMA\n" +
                "  BEGIN\n" +
                "    EXECUTE IMMEDIATE 'CREATE TABLE T (n NUMBER, m NUMBER)';\n" +
                "  END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER t\n" +
                "\tINSTEAD OF\n" +
                "\t\tCREATE\n" +
                "\tON SCHEMA\n" +
                "\tBEGIN\n" +
                "\t\tEXECUTE IMMEDIATE 'CREATE TABLE T (n NUMBER, m NUMBER)';\n" +
                "\tEND;", formatSQL);
    }
}
