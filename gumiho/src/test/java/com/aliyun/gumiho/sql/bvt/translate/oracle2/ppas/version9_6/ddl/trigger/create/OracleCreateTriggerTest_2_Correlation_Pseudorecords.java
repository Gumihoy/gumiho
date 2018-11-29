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
public class OracleCreateTriggerTest_2_Correlation_Pseudorecords {

    @Test
    public void test1() {
        String s = "CREATE OR REPLACE TRIGGER log_salary_increase\n" +
                "  AFTER UPDATE OF salary ON employees\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  INSERT INTO Emp_log (Emp_id, Log_date, New_salary, Action)\n" +
                "  VALUES (:NEW.employee_id, SYSDATE, :NEW.salary, 'New Salary');\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER log_salary_increase\n" +
                "  AFTER UPDATE OF salary ON employees\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  INSERT INTO Emp_log (Emp_id, Log_date, New_salary, Action)\n" +
                "  VALUES (:NEW.employee_id, SYSDATE, :NEW.salary, 'New Salary');\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test2() {
        String s = "CREATE OR REPLACE TRIGGER print_salary_changes\n" +
                "  BEFORE DELETE OR INSERT OR UPDATE ON employees\n" +
                "  FOR EACH ROW\n" +
                "  WHEN (NEW.job_id <> 'AD_PRES')  -- do not print information about President\n" +
                "DECLARE\n" +
                "  sal_diff  NUMBER;\n" +
                "BEGIN\n" +
                "  sal_diff  := :NEW.salary  - :OLD.salary;\n" +
                "  DBMS_OUTPUT.PUT(:NEW.last_name || ': ');\n" +
                "  DBMS_OUTPUT.PUT('Old salary = ' || :OLD.salary || ', ');\n" +
                "  DBMS_OUTPUT.PUT('New salary = ' || :NEW.salary || ', ');\n" +
                "  DBMS_OUTPUT.PUT_LINE('Difference: ' || sal_diff);\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER print_salary_changes\n" +
                "  BEFORE DELETE OR INSERT OR UPDATE ON employees\n" +
                "  FOR EACH ROW\n" +
                "  WHEN (NEW.job_id <> 'AD_PRES')  -- do not print information about President\n" +
                "DECLARE\n" +
                "  sal_diff  NUMBER;\n" +
                "BEGIN\n" +
                "  sal_diff  := :NEW.salary  - :OLD.salary;\n" +
                "  DBMS_OUTPUT.PUT(:NEW.last_name || ': ');\n" +
                "  DBMS_OUTPUT.PUT('Old salary = ' || :OLD.salary || ', ');\n" +
                "  DBMS_OUTPUT.PUT('New salary = ' || :NEW.salary || ', ');\n" +
                "  DBMS_OUTPUT.PUT_LINE('Difference: ' || sal_diff);\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test3() {
        String s = "CREATE OR REPLACE TRIGGER trg1\n" +
                "  BEFORE UPDATE ON tab1\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  DBMS_OUTPUT.PUT_LINE('Old value of CLOB column: '||:OLD.c1);\n" +
                "  DBMS_OUTPUT.PUT_LINE('Proposed new value of CLOB column: '||:NEW.c1);\n" +
                "\n" +
                "  :NEW.c1 := :NEW.c1 || TO_CLOB('<hr><p>Standard footer paragraph.');\n" +
                "\n" +
                "  DBMS_OUTPUT.PUT_LINE('Final value of CLOB column: '||:NEW.c1);\n" +
                "END;\n" +
                "/ ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER trg1\n" +
                "  BEFORE UPDATE ON tab1\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  DBMS_OUTPUT.PUT_LINE('Old value of CLOB column: '||:OLD.c1);\n" +
                "  DBMS_OUTPUT.PUT_LINE('Proposed new value of CLOB column: '||:NEW.c1);\n" +
                "\n" +
                "  :NEW.c1 := :NEW.c1 || TO_CLOB('<hr><p>Standard footer paragraph.');\n" +
                "\n" +
                "  DBMS_OUTPUT.PUT_LINE('Final value of CLOB column: '||:NEW.c1);\n" +
                "END;\n" +
                "/ ", formatSQL);
    }


    @Test
    public void test4() {
        String s = "CREATE OR REPLACE TRIGGER Print_salary_changes\n" +
                "BEFORE UPDATE ON new\n" +
                "REFERENCING new AS Newest\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "  :Newest.Field2 := TO_CHAR (:newest.field1);\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER Print_salary_changes\n" +
                "BEFORE UPDATE ON new\n" +
                "REFERENCING new AS Newest\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "  :Newest.Field2 := TO_CHAR (:newest.field1);\n" +
                "END;\n" +
                "/", formatSQL);
    }
}
