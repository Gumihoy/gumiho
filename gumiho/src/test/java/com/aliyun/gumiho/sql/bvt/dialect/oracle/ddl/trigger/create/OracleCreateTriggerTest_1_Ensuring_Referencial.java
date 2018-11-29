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
public class OracleCreateTriggerTest_1_Ensuring_Referencial {

    @Test
    public void test_0() {
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
                "\tBEFORE\n" +
                "\t\tINSERT OR\n" +
                "\t\tUPDATE OF Deptno\n" +
                "\tON emp\n" +
                "\tFOR EACH ROW\n" +
                "\tWHEN (NEW.Deptno IS NOT NULL)\n" +
                "\tDECLARE\n" +
                "\t\tDummy INTEGER;\n" +
                "\t\tInvalid_department EXCEPTION;\n" +
                "\t\tValid_department EXCEPTION;\n" +
                "\t\tMutating_table EXCEPTION;\n" +
                "\t\tPRAGMA EXCEPTION_INIT(Invalid_department, -4093);\n" +
                "\t\tPRAGMA EXCEPTION_INIT(Valid_department, -4092);\n" +
                "\t\tPRAGMA EXCEPTION_INIT(Mutating_table, -4091);\n" +
                "\t\tCURSOR Dummy_cursor (\n" +
                "\t\t\tDn NUMBER\n" +
                "\t\t) IS\n" +
                "\t\t\tSELECT Deptno\n" +
                "\t\t\tFROM dept\n" +
                "\t\t\tWHERE Deptno = Dn\n" +
                "\t\t\tFOR UPDATE OF Deptno;\n" +
                "\tBEGIN\n" +
                "\t\tOPEN Dummy_cursor (\n" +
                "\t\t\t:NEW.Deptno\n" +
                "\t\t);\n" +
                "\t\tFETCH Dummy_cursor INTO Dummy;\n" +
                "\t\tIF Dummy_cursor%NOTFOUND THEN\n" +
                "\t\t\tRAISE Invalid_department;\n" +
                "\t\tELSE\n" +
                "\t\t\tRAISE Valid_department;\n" +
                "\t\tEND IF;\n" +
                "\t\tCLOSE Dummy_cursor;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN Invalid_department THEN\n" +
                "\t\t\t\tCLOSE Dummy_cursor;\n" +
                "\t\t\t\tRaise_application_error(-20000, 'Invalid Department' || ' Number' || TO_CHAR(:NEW.deptno));\n" +
                "\t\t\tWHEN Valid_department THEN\n" +
                "\t\t\t\tCLOSE Dummy_cursor;\n" +
                "\t\t\tWHEN Mutating_table THEN\n" +
                "\t\t\t\tNULL;\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_1() {
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
                "\tBEFORE\n" +
                "\t\tDELETE OR\n" +
                "\t\tUPDATE OF Deptno\n" +
                "\tON dept\n" +
                "\tFOR EACH ROW\n" +
                "\tDECLARE\n" +
                "\t\tDummy INTEGER;\n" +
                "\t\temployees_present EXCEPTION;\n" +
                "\t\temployees_not_present EXCEPTION;\n" +
                "\t\tPRAGMA EXCEPTION_INIT(employees_present, -4094);\n" +
                "\t\tPRAGMA EXCEPTION_INIT(employees_not_present, -4095);\n" +
                "\t\tCURSOR Dummy_cursor (\n" +
                "\t\t\tDn NUMBER\n" +
                "\t\t) IS\n" +
                "\t\t\tSELECT Deptno\n" +
                "\t\t\tFROM emp\n" +
                "\t\t\tWHERE Deptno = Dn;\n" +
                "\tBEGIN\n" +
                "\t\tOPEN Dummy_cursor (\n" +
                "\t\t\t:OLD.Deptno\n" +
                "\t\t);\n" +
                "\t\tFETCH Dummy_cursor INTO Dummy;\n" +
                "\t\tIF Dummy_cursor%FOUND THEN\n" +
                "\t\t\tRAISE employees_present;\n" +
                "\t\tELSE\n" +
                "\t\t\tRAISE employees_not_present;\n" +
                "\t\tEND IF;\n" +
                "\t\tCLOSE Dummy_cursor;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN employees_present THEN\n" +
                "\t\t\t\tCLOSE Dummy_cursor;\n" +
                "\t\t\t\tRaise_application_error(-20001, 'Employees Present in' || ' Department ' || TO_CHAR(:OLD.DEPTNO));\n" +
                "\t\t\tWHEN employees_not_present THEN\n" +
                "\t\t\t\tCLOSE Dummy_cursor;\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_2() {
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
                "\tAFTER\n" +
                "\t\tDELETE OR\n" +
                "\t\tUPDATE OF Deptno\n" +
                "\tON dept\n" +
                "\tFOR EACH ROW\n" +
                "\tBEGIN\n" +
                "\t\tIF UPDATING AND :OLD.Deptno != :NEW.Deptno OR DELETING THEN\n" +
                "\t\t\tUPDATE emp\n" +
                "\t\t\tSET emp.Deptno = NULL\n" +
                "\t\t\tWHERE emp.Deptno = :OLD.Deptno;\n" +
                "\t\tEND IF;\n" +
                "\tEND;", formatSQL);
    }
}
