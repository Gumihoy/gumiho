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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.trigger.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class OracleCreateTriggerTest_1_Ensuring_Referencial {

    @Test
    public void test1() {
        String s = "CREATE OR REPLACE TRIGGER emp_dept_check\n" +
                "  BEFORE INSERT OR UPDATE OF Deptno ON emp\n" +
                "  FOR EACH ROW WHEN (NEW.Deptno IS NOT NULL)\n" +
                "\n" +
                "  -- Before row is inserted or DEPTNO is updated in emp table,\n" +
                "  -- fire this trigger to verify that new foreign key value (DEPTNO)\n" +
                "  -- is present in dept table.\n" +
                "DECLARE\n" +
                "  Dummy               INTEGER;  -- Use for cursor fetch\n" +
                "  Invalid_department  EXCEPTION;\n" +
                "  Valid_department    EXCEPTION;\n" +
                "  Mutating_table      EXCEPTION;\n" +
                "  PRAGMA EXCEPTION_INIT (Invalid_department, -4093);\n" +
                "  PRAGMA EXCEPTION_INIT (Valid_department, -4092);\n" +
                "  PRAGMA EXCEPTION_INIT (Mutating_table, -4091);\n" +
                "\n" +
                "  -- Cursor used to verify parent key value exists.\n" +
                "  -- If present, lock parent key's row so it cannot be deleted\n" +
                "  -- by another transaction until this transaction is\n" +
                "  -- committed or rolled back.\n" +
                "\n" +
                "  CURSOR Dummy_cursor (Dn NUMBER) IS\n" +
                "    SELECT Deptno FROM dept\n" +
                "    WHERE Deptno = Dn\n" +
                "    FOR UPDATE OF Deptno;\n" +
                "BEGIN\n" +
                "  OPEN Dummy_cursor (:NEW.Deptno);\n" +
                "  FETCH Dummy_cursor INTO Dummy;\n" +
                "\n" +
                "  -- Verify parent key.\n" +
                "  -- If not found, raise user-specified error code and message.\n" +
                "  -- If found, close cursor before allowing triggering statement to complete:\n" +
                "\n" +
                "  IF Dummy_cursor%NOTFOUND THEN\n" +
                "    RAISE Invalid_department;\n" +
                "  ELSE\n" +
                "    RAISE Valid_department;\n" +
                "  END IF;\n" +
                "  CLOSE Dummy_cursor;\n" +
                "EXCEPTION\n" +
                "  WHEN Invalid_department THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "    Raise_application_error(-20000, 'Invalid Department'\n" +
                "      || ' Number' || TO_CHAR(:NEW.deptno));\n" +
                "  WHEN Valid_department THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "  WHEN Mutating_table THEN\n" +
                "    NULL;\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER emp_dept_check\n" +
                "  BEFORE INSERT OR UPDATE OF Deptno ON emp\n" +
                "  FOR EACH ROW WHEN (NEW.Deptno IS NOT NULL)\n" +
                "\n" +
                "  -- Before row is inserted or DEPTNO is updated in emp table,\n" +
                "  -- fire this trigger to verify that new foreign key value (DEPTNO)\n" +
                "  -- is present in dept table.\n" +
                "DECLARE\n" +
                "  Dummy               INTEGER;  -- Use for cursor fetch\n" +
                "  Invalid_department  EXCEPTION;\n" +
                "  Valid_department    EXCEPTION;\n" +
                "  Mutating_table      EXCEPTION;\n" +
                "  PRAGMA EXCEPTION_INIT (Invalid_department, -4093);\n" +
                "  PRAGMA EXCEPTION_INIT (Valid_department, -4092);\n" +
                "  PRAGMA EXCEPTION_INIT (Mutating_table, -4091);\n" +
                "\n" +
                "  -- Cursor used to verify parent key value exists.\n" +
                "  -- If present, lock parent key's row so it cannot be deleted\n" +
                "  -- by another transaction until this transaction is\n" +
                "  -- committed or rolled back.\n" +
                "\n" +
                "  CURSOR Dummy_cursor (Dn NUMBER) IS\n" +
                "    SELECT Deptno FROM dept\n" +
                "    WHERE Deptno = Dn\n" +
                "    FOR UPDATE OF Deptno;\n" +
                "BEGIN\n" +
                "  OPEN Dummy_cursor (:NEW.Deptno);\n" +
                "  FETCH Dummy_cursor INTO Dummy;\n" +
                "\n" +
                "  -- Verify parent key.\n" +
                "  -- If not found, raise user-specified error code and message.\n" +
                "  -- If found, close cursor before allowing triggering statement to complete:\n" +
                "\n" +
                "  IF Dummy_cursor%NOTFOUND THEN\n" +
                "    RAISE Invalid_department;\n" +
                "  ELSE\n" +
                "    RAISE Valid_department;\n" +
                "  END IF;\n" +
                "  CLOSE Dummy_cursor;\n" +
                "EXCEPTION\n" +
                "  WHEN Invalid_department THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "    Raise_application_error(-20000, 'Invalid Department'\n" +
                "      || ' Number' || TO_CHAR(:NEW.deptno));\n" +
                "  WHEN Valid_department THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "  WHEN Mutating_table THEN\n" +
                "    NULL;\n" +
                "END;\n" +
                "/", formatSQL);
    }


    @Test
    public void test2() {
        String s = "CREATE OR REPLACE TRIGGER dept_restrict\n" +
                "  BEFORE DELETE OR UPDATE OF Deptno ON dept\n" +
                "  FOR EACH ROW\n" +
                "\n" +
                "  -- Before row is deleted from dept or primary key (DEPTNO) of dept is updated,\n" +
                "  -- check for dependent foreign key values in emp;\n" +
                "  -- if any are found, roll back.\n" +
                "\n" +
                "DECLARE\n" +
                "  Dummy                  INTEGER;  -- Use for cursor fetch\n" +
                "  employees_present      EXCEPTION;\n" +
                "  employees_not_present  EXCEPTION;\n" +
                "  PRAGMA EXCEPTION_INIT (employees_present, -4094);\n" +
                "  PRAGMA EXCEPTION_INIT (employees_not_present, -4095);\n" +
                "\n" +
                "  -- Cursor used to check for dependent foreign key values.\n" +
                "  CURSOR Dummy_cursor (Dn NUMBER) IS\n" +
                "    SELECT Deptno FROM emp WHERE Deptno = Dn;\n" +
                "\n" +
                "BEGIN\n" +
                "  OPEN Dummy_cursor (:OLD.Deptno);\n" +
                "  FETCH Dummy_cursor INTO Dummy;\n" +
                "\n" +
                "  -- If dependent foreign key is found, raise user-specified\n" +
                "  -- error code and message. If not found, close cursor\n" +
                "  -- before allowing triggering statement to complete.\n" +
                "\n" +
                "  IF Dummy_cursor%FOUND THEN\n" +
                "    RAISE employees_present;     -- Dependent rows exist\n" +
                "  ELSE\n" +
                "    RAISE employees_not_present; -- No dependent rows exist\n" +
                "  END IF;\n" +
                "  CLOSE Dummy_cursor;\n" +
                "\n" +
                "EXCEPTION\n" +
                "  WHEN employees_present THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "    Raise_application_error(-20001, 'Employees Present in'\n" +
                "      || ' Department ' || TO_CHAR(:OLD.DEPTNO));\n" +
                "  WHEN employees_not_present THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "END;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER dept_restrict\n" +
                "  BEFORE DELETE OR UPDATE OF Deptno ON dept\n" +
                "  FOR EACH ROW\n" +
                "\n" +
                "  -- Before row is deleted from dept or primary key (DEPTNO) of dept is updated,\n" +
                "  -- check for dependent foreign key values in emp;\n" +
                "  -- if any are found, roll back.\n" +
                "\n" +
                "DECLARE\n" +
                "  Dummy                  INTEGER;  -- Use for cursor fetch\n" +
                "  employees_present      EXCEPTION;\n" +
                "  employees_not_present  EXCEPTION;\n" +
                "  PRAGMA EXCEPTION_INIT (employees_present, -4094);\n" +
                "  PRAGMA EXCEPTION_INIT (employees_not_present, -4095);\n" +
                "\n" +
                "  -- Cursor used to check for dependent foreign key values.\n" +
                "  CURSOR Dummy_cursor (Dn NUMBER) IS\n" +
                "    SELECT Deptno FROM emp WHERE Deptno = Dn;\n" +
                "\n" +
                "BEGIN\n" +
                "  OPEN Dummy_cursor (:OLD.Deptno);\n" +
                "  FETCH Dummy_cursor INTO Dummy;\n" +
                "\n" +
                "  -- If dependent foreign key is found, raise user-specified\n" +
                "  -- error code and message. If not found, close cursor\n" +
                "  -- before allowing triggering statement to complete.\n" +
                "\n" +
                "  IF Dummy_cursor%FOUND THEN\n" +
                "    RAISE employees_present;     -- Dependent rows exist\n" +
                "  ELSE\n" +
                "    RAISE employees_not_present; -- No dependent rows exist\n" +
                "  END IF;\n" +
                "  CLOSE Dummy_cursor;\n" +
                "\n" +
                "EXCEPTION\n" +
                "  WHEN employees_present THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "    Raise_application_error(-20001, 'Employees Present in'\n" +
                "      || ' Department ' || TO_CHAR(:OLD.DEPTNO));\n" +
                "  WHEN employees_not_present THEN\n" +
                "    CLOSE Dummy_cursor;\n" +
                "END;", formatSQL);
    }


    @Test
    public void test3() {
        String s = "CREATE OR REPLACE TRIGGER dept_set_null\n" +
                "  AFTER DELETE OR UPDATE OF Deptno ON dept\n" +
                "  FOR EACH ROW\n" +
                "\n" +
                "  -- Before row is deleted from dept or primary key (DEPTNO) of dept is updated,\n" +
                "  -- set all corresponding dependent foreign key values in emp to NULL:\n" +
                "\n" +
                "BEGIN\n" +
                "  IF UPDATING AND :OLD.Deptno != :NEW.Deptno OR DELETING THEN\n" +
                "    UPDATE emp SET emp.Deptno = NULL\n" +
                "    WHERE emp.Deptno = :OLD.Deptno;\n" +
                "  END IF;\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER dept_set_null\n" +
                "  AFTER DELETE OR UPDATE OF Deptno ON dept\n" +
                "  FOR EACH ROW\n" +
                "\n" +
                "  -- Before row is deleted from dept or primary key (DEPTNO) of dept is updated,\n" +
                "  -- set all corresponding dependent foreign key values in emp to NULL:\n" +
                "\n" +
                "BEGIN\n" +
                "  IF UPDATING AND :OLD.Deptno != :NEW.Deptno OR DELETING THEN\n" +
                "    UPDATE emp SET emp.Deptno = NULL\n" +
                "    WHERE emp.Deptno = :OLD.Deptno;\n" +
                "  END IF;\n" +
                "END;\n" +
                "/", formatSQL);
    }
}
