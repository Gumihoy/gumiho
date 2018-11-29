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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.trigger.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class OracleCreateTriggerTest_4_Event_Repeat {

    @Test
    public void test1() {
        String s = "  CREATE OR REPLACE TRIGGER \"APP_DEV\".\"TIME_CHECK\" \n" +
                "  before update or update or delete on jobs\n" +
                "  for each row\n" +
                "begin\n" +
                "  if to_char(sysdate, 'd') = 7 then\n" +
                "    if (TO_CHAR(sysdate, 'HH24:MI') not BETWEEN '08:00' AND '12:00') then\n" +
                "      raise_application_error(-20500,'not woking time');\n" +
                "    end if;\n" +
                "  else\n" +
                "    if (TO_CHAR(sysdate, 'HH24:MI') not BETWEEN '08:00' AND '10:00') then\n" +
                "       raise_application_error(-20500,'not woking time');\n" +
                "    end if;\n" +
                "  end if;\n" +
                "end TIME_CHECK;\n" +
                "\n" +
                "ALTER TRIGGER \"APP_DEV\".\"TIME_CHECK\" ENABLE";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(formatSQL);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("\n" +
                "  CREATE OR REPLACE TRIGGER \"APP_DEV\".\"TIME_CHECK\" \n" +
                "  before update or update or delete on jobs\n" +
                "  for each row\n" +
                "begin\n" +
                "  if to_char(sysdate, 'd') = 7 then\n" +
                "    if (TO_CHAR(sysdate, 'HH24:MI') not BETWEEN '08:00' AND '12:00') then\n" +
                "      raise_application_error(-20500,'not woking time');\n" +
                "    end if;\n" +
                "  else\n" +
                "    if (TO_CHAR(sysdate, 'HH24:MI') not BETWEEN '08:00' AND '10:00') then\n" +
                "       raise_application_error(-20500,'not woking time');\n" +
                "    end if;\n" +
                "  end if;\n" +
                "end TIME_CHECK;\n" +
                "\n" +
                "ALTER TRIGGER \"APP_DEV\".\"TIME_CHECK\" ENABLE", result.targetSql);
    }


    @Test
    public void test2() {
        String s = "CREATE OR REPLACE TRIGGER employees_tr\n" +
                "  AFTER INSERT ON employees\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  -- When remote database is unavailable, compilation fails here:\n" +
                "  INSERT INTO employees@remote (\n" +
                "    employee_id, first_name, last_name, email, hire_date, job_id\n" +
                "  ) \n" +
                "  VALUES (\n" +
                "    99, 'Jane', 'Doe', 'jane.doe@example.com', SYSDATE, 'ST_MAN'\n" +
                "  );\n" +
                "EXCEPTION\n" +
                "  WHEN OTHERS THEN\n" +
                "    INSERT INTO emp_log (Emp_id, Log_date, New_salary, Action)\n" +
                "      VALUES (99, SYSDATE, NULL, 'Could not insert');\n" +
                "    RAISE;\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER employees_tr\n" +
                "  AFTER INSERT ON employees\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  -- When remote database is unavailable, compilation fails here:\n" +
                "  INSERT INTO employees@remote (\n" +
                "    employee_id, first_name, last_name, email, hire_date, job_id\n" +
                "  ) \n" +
                "  VALUES (\n" +
                "    99, 'Jane', 'Doe', 'jane.doe@example.com', SYSDATE, 'ST_MAN'\n" +
                "  );\n" +
                "EXCEPTION\n" +
                "  WHEN OTHERS THEN\n" +
                "    INSERT INTO emp_log (Emp_id, Log_date, New_salary, Action)\n" +
                "      VALUES (99, SYSDATE, NULL, 'Could not insert');\n" +
                "    RAISE;\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test3() {
        String s = "CREATE OR REPLACE TRIGGER employees_tr\n" +
                "  AFTER INSERT ON employees\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  insert_row_proc;\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER employees_tr\n" +
                "\tAFTER\n" +
                "\t\tINSERT\n" +
                "\tON employees\n" +
                "\tFOR EACH ROW\n" +
                "\tBEGIN\n" +
                "\t\tINSERT INTO employees@remote (employee_id, first_name, last_name, email, hire_date, job_id)\n" +
                "\t\tVALUES (99, 'Jane', 'Doe', 'jane.doe@example.com', SYSDATE, 'ST_MAN');\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWITH OTHERS THEN\n" +
                "\t\t\t\tINSERT INTO emp_log (Emp_id, Log_date, New_salary, Action)\n" +
                "\t\t\t\tVALUES (99, SYSDATE, NULL, 'Could not insert');\n" +
                "\t\t\t\tRAISE;\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test4() {
        String s = "CREATE OR REPLACE TRIGGER log_deletions\n" +
                "  AFTER DELETE ON employees\n" +
                "  FOR EACH ROW\n" +
                "DECLARE\n" +
                "  n INTEGER;\n" +
                "BEGIN\n" +
                "  INSERT INTO log VALUES (\n" +
                "    :OLD.employee_id,\n" +
                "    :OLD.last_name,\n" +
                "    :OLD.first_name\n" +
                "  );\n" +
                " \n" +
                "  SELECT COUNT(*) INTO n FROM employees;\n" +
                "  DBMS_OUTPUT.PUT_LINE('There are now ' || n || ' employees.');\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER log_deletions\n" +
                "  AFTER DELETE ON employees\n" +
                "  FOR EACH ROW\n" +
                "DECLARE\n" +
                "  n INTEGER;\n" +
                "BEGIN\n" +
                "  INSERT INTO log VALUES (\n" +
                "    :OLD.employee_id,\n" +
                "    :OLD.last_name,\n" +
                "    :OLD.first_name\n" +
                "  );\n" +
                " \n" +
                "  SELECT COUNT(*) INTO n FROM employees;\n" +
                "  DBMS_OUTPUT.PUT_LINE('There are now ' || n || ' employees.');\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test5() {
        String s = "CREATE TRIGGER pt\n" +
                "  AFTER UPDATE ON p\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  UPDATE f SET f1 = :NEW.p1 WHERE f1 = :OLD.p1;\n" +
                "END;\n" +
                "/";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TRIGGER pt\n" +
                "  AFTER UPDATE ON p\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  UPDATE f SET f1 = :NEW.p1 WHERE f1 = :OLD.p1;\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test6() {
        String s = "CREATE OR REPLACE TRIGGER Emp_count\n" +
                "  AFTER DELETE ON employees\n" +
                "DECLARE\n" +
                "  n  INTEGER;\n" +
                "BEGIN\n" +
                "  SELECT COUNT(*) INTO n FROM employees;\n" +
                "  DBMS_OUTPUT.PUT_LINE('There are now ' || n || ' employees.');\n" +
                "END;\n" +
                "/";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER Emp_count\n" +
                "  AFTER DELETE ON employees\n" +
                "DECLARE\n" +
                "  n  INTEGER;\n" +
                "BEGIN\n" +
                "  SELECT COUNT(*) INTO n FROM employees;\n" +
                "  DBMS_OUTPUT.PUT_LINE('There are now ' || n || ' employees.');\n" +
                "END;\n" +
                "/", formatSQL);
    }
}
