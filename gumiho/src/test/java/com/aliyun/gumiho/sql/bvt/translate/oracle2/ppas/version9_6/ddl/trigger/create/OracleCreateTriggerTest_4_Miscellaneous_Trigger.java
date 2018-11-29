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
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class OracleCreateTriggerTest_4_Miscellaneous_Trigger {

    @Test
    public void test1() {
        String s = "CREATE OR REPLACE TRIGGER Pre_del_trigger BEFORE DELETE ON Tab \n" +
                "FOR EACH ROW\n" +
                "CALL Before_delete (:OLD.Id, :OLD.Ename)\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER Pre_del_trigger\n" +
                "\tBEFORE\n" +
                "\t\tDELETE\n" +
                "\tON Tab\n" +
                "\tFOR EACH ROW\n" +
                "\tCALL Before_delete(:OLD.Id, :OLD.Ename)", formatSQL);
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
