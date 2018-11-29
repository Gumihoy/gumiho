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
public class OracleCreateTriggerTest_0_DML_Triggers {

    @Test
    public void test_0() {
        String s = "CREATE OR REPLACE TRIGGER t\n" +
                "  BEFORE\n" +
                "    INSERT OR\n" +
                "    UPDATE OF salary, department_id OR\n" +
                "    DELETE\n" +
                "  ON employees\n" +
                "BEGIN\n" +
                "  CASE\n" +
                "    WHEN INSERTING THEN\n" +
                "      DBMS_OUTPUT.PUT_LINE('Inserting');\n" +
                "    WHEN UPDATING('salary') THEN\n" +
                "      DBMS_OUTPUT.PUT_LINE('Updating salary');\n" +
                "    WHEN UPDATING('department_id') THEN\n" +
                "      DBMS_OUTPUT.PUT_LINE('Updating department ID');\n" +
                "    WHEN DELETING THEN\n" +
                "      DBMS_OUTPUT.PUT_LINE('Deleting');\n" +
                "  END CASE;\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER t\n" +
                "\tBEFORE\n" +
                "\t\tINSERT OR\n" +
                "\t\tUPDATE OF salary, department_id OR\n" +
                "\t\tDELETE\n" +
                "\tON employees\n" +
                "\tBEGIN\n" +
                "\t\tCASE\n" +
                "\t\t\tWHEN INSERTING THEN\n" +
                "\t\t\t\tDBMS_OUTPUT.PUT_LINE('Inserting');\n" +
                "\t\t\tWHEN UPDATING('salary') THEN\n" +
                "\t\t\t\tDBMS_OUTPUT.PUT_LINE('Updating salary');\n" +
                "\t\t\tWHEN UPDATING('department_id') THEN\n" +
                "\t\t\t\tDBMS_OUTPUT.PUT_LINE('Updating department ID');\n" +
                "\t\t\tWHEN DELETING THEN\n" +
                "\t\t\t\tDBMS_OUTPUT.PUT_LINE('Deleting');\n" +
                "\t\tEND CASE;\n" +
                "\tEND;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "CREATE OR REPLACE TRIGGER order_info_insert\n" +
                "   INSTEAD OF INSERT ON order_info\n" +
                "   DECLARE\n" +
                "     duplicate_info EXCEPTION;\n" +
                "     PRAGMA EXCEPTION_INIT (duplicate_info, -00001);\n" +
                "   BEGIN\n" +
                "     INSERT INTO customers\n" +
                "       (customer_id, cust_last_name, cust_first_name)\n" +
                "     VALUES (\n" +
                "     :customer_id,\n" +
                "     :new.cust_last_name,\n" +
                "     :new.cust_first_name);\n" +
                "   INSERT INTO orders (order_id, order_date, customer_id)\n" +
                "   VALUES (\n" +
                "     :new.order_id,\n" +
                "     :new.order_date,\n" +
                "     :new.customer_id);\n" +
                "   EXCEPTION\n" +
                "     WHEN duplicate_info THEN\n" +
                "       RAISE_APPLICATION_ERROR (\n" +
                "         num=> -20107,\n" +
                "         msg=> 'Duplicate customer or order ID');\n" +
                "   END order_info_insert;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER order_info_insert\n" +
                "\tINSTEAD OF\n" +
                "\t\tINSERT\n" +
                "\tON order_info\n" +
                "\tDECLARE\n" +
                "\t\tduplicate_info EXCEPTION;\n" +
                "\t\tPRAGMA EXCEPTION_INIT(duplicate_info, -00001);\n" +
                "\tBEGIN\n" +
                "\t\tINSERT INTO customers (customer_id, cust_last_name, cust_first_name)\n" +
                "\t\tVALUES (:customer_id, :NEW.cust_last_name, :NEW.cust_first_name);\n" +
                "\t\tINSERT INTO orders (order_id, order_date, customer_id)\n" +
                "\t\tVALUES (:NEW.order_id, :NEW.order_date, :NEW.customer_id);\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN duplicate_info THEN\n" +
                "\t\t\t\tRAISE_APPLICATION_ERROR(num => -20107, msg => 'Duplicate customer or order ID');\n" +
                "\tEND order_info_insert;", formatSQL);
    }


    @Test
    public void test_2() {
        String s = "CREATE OR REPLACE TRIGGER dept_emplist_tr\n" +
                "  INSTEAD OF INSERT ON NESTED TABLE emplist OF dept_view\n" +
                "  REFERENCING NEW AS Employee\n" +
                "              PARENT AS Department\n" +
                "  FOR EACH ROW\n" +
                "BEGIN\n" +
                "  -- Insert on nested table translates to insert on base table:\n" +
                "  INSERT INTO employees (\n" +
                "    employee_id,\n" +
                "    last_name,\n" +
                "    email,\n" +
                "    hire_date,\n" +
                "    job_id,\n" +
                "    salary,\n" +
                "    department_id\n" +
                "  )\n" +
                "  VALUES (\n" +
                "    :Employee.emp_id,                      -- employee_id\n" +
                "    :Employee.lastname,                    -- last_name\n" +
                "    :Employee.lastname || '@company.com',  -- email\n" +
                "    SYSDATE,                               -- hire_date\n" +
                "    :Employee.job,                         -- job_id\n" +
                "    :Employee.sal,                         -- salary\n" +
                "    :Department.department_id              -- department_id\n" +
                "  );\n" +
                "END;\n" +
                "/";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TRIGGER dept_emplist_tr\n" +
                "\tINSTEAD OF\n" +
                "\t\tINSERT\n" +
                "\tON NESTED TABLE emplist OF dept_view\n" +
                "\tREFERENCING NEW AS Employee\n" +
                "\t\tPARENT AS Department\n" +
                "\tFOR EACH ROW\n" +
                "\tBEGIN\n" +
                "\t\tINSERT INTO employees (employee_id, last_name, email, hire_date, job_id, salary, department_id)\n" +
                "\t\tVALUES (:Employee.emp_id, :Employee.lastname, :Employee.lastname || '@company.com', SYSDATE, :Employee.job, :Employee.sal, :Department.department_id);\n" +
                "\tEND;", formatSQL);
    }
}
