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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.packagebody.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreatePackageBodyTest_0 {

    @Test
    public void test() {
        String s = "CREATE OR REPLACE PACKAGE BODY emp_mgmt AS \n" +
                "   tot_emps NUMBER; \n" +
                "   tot_depts NUMBER; \n" +
                "FUNCTION hire \n" +
                "   (last_name VARCHAR2, job_id VARCHAR2, \n" +
                "    manager_id NUMBER, salary NUMBER, \n" +
                "    commission_pct NUMBER, department_id NUMBER) \n" +
                "   RETURN NUMBER IS new_empno NUMBER; \n" +
                "BEGIN \n" +
                "   SELECT employees_seq.NEXTVAL \n" +
                "      INTO new_empno \n" +
                "      FROM DUAL; \n" +
                "   INSERT INTO employees \n" +
                "      VALUES (new_empno, 'First', 'Last','first.example@example.com',\n" +
                "              '(415)555-0100',\n" +
                "              TO_DATE('18-JUN-2002','DD-MON-YYYY'),\n" +
                "              'IT_PROG',90000000,00, 100,110);\n" +
                "      tot_emps := tot_emps + 1; \n" +
                "   RETURN(new_empno); \n" +
                "END; \n" +
                "FUNCTION create_dept(department_id NUMBER, location_id NUMBER) \n" +
                "   RETURN NUMBER IS \n" +
                "      new_deptno NUMBER; \n" +
                "   BEGIN \n" +
                "      SELECT departments_seq.NEXTVAL \n" +
                "         INTO new_deptno \n" +
                "         FROM dual; \n" +
                "      INSERT INTO departments \n" +
                "         VALUES (new_deptno, 'department name', 100, 1700); \n" +
                "      tot_depts := tot_depts + 1; \n" +
                "      RETURN(new_deptno); \n" +
                "   END; \n" +
                "PROCEDURE remove_emp (employee_id NUMBER) IS \n" +
                "   BEGIN \n" +
                "      DELETE FROM employees \n" +
                "      WHERE employees.employee_id = remove_emp.employee_id; \n" +
                "      tot_emps := tot_emps - 1; \n" +
                "   END; \n" +
                "PROCEDURE remove_dept(department_id NUMBER) IS \n" +
                "   BEGIN \n" +
                "      DELETE FROM departments \n" +
                "      WHERE departments.department_id = remove_dept.department_id; \n" +
                "      tot_depts := tot_depts - 1; \n" +
                "      SELECT COUNT(*) INTO tot_emps FROM employees; \n" +
                "   END; \n" +
                "PROCEDURE increase_sal(employee_id NUMBER, salary_incr NUMBER) IS \n" +
                "   curr_sal NUMBER; \n" +
                "   BEGIN \n" +
                "      SELECT salary INTO curr_sal FROM employees \n" +
                "      WHERE employees.employee_id = increase_sal.employee_id; \n" +
                "      IF curr_sal IS NULL \n" +
                "         THEN RAISE no_sal; \n" +
                "      ELSE \n" +
                "         UPDATE employees \n" +
                "         SET salary = salary + salary_incr \n" +
                "         WHERE employee_id = employee_id; \n" +
                "      END IF; \n" +
                "   END; \n" +
                "PROCEDURE increase_comm(employee_id NUMBER, comm_incr NUMBER) IS \n" +
                "   curr_comm NUMBER; \n" +
                "   BEGIN \n" +
                "      SELECT commission_pct \n" +
                "      INTO curr_comm \n" +
                "      FROM employees \n" +
                "      WHERE employees.employee_id = increase_comm.employee_id; \n" +
                "      IF curr_comm IS NULL \n" +
                "         THEN RAISE no_comm; \n" +
                "      ELSE \n" +
                "         UPDATE employees \n" +
                "         SET commission_pct = commission_pct + comm_incr; \n" +
                "      END IF; \n" +
                "   END; \n" +
                "END emp_mgmt;";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE PACKAGE BODY emp_mgmt\n" +
                "AS\n" +
                "\ttot_emps NUMBER;\n" +
                "\ttot_depts NUMBER;\n" +
                "\tFUNCTION hire (\n" +
                "\t\tlast_name VARCHAR2,\n" +
                "\t\tjob_id VARCHAR2,\n" +
                "\t\tmanager_id NUMBER,\n" +
                "\t\tsalary NUMBER,\n" +
                "\t\tcommission_pct NUMBER,\n" +
                "\t\tdepartment_id NUMBER\n" +
                "\t) RETURN NUMBER IS\n" +
                "\t\tnew_empno NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT employees_seq.NEXTVAL\n" +
                "\t\t\tINTO new_empno\n" +
                "\t\t\tFROM DUAL;\n" +
                "\t\t\tINSERT INTO employees\n" +
                "\t\t\tVALUES (new_empno, 'First', 'Last', 'first.example@example.com', '(415)555-0100', TO_DATE('18-JUN-2002', 'DD-MON-YYYY'), 'IT_PROG', 90000000, 00, 100, 110);\n" +
                "\t\t\ttot_emps := tot_emps + 1;\n" +
                "\t\t\tRETURN(new_empno);\n" +
                "\t\tEND;\n" +
                "\tFUNCTION create_dept (\n" +
                "\t\tdepartment_id NUMBER,\n" +
                "\t\tlocation_id NUMBER\n" +
                "\t) RETURN NUMBER IS\n" +
                "\t\tnew_deptno NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT departments_seq.NEXTVAL\n" +
                "\t\t\tINTO new_deptno\n" +
                "\t\t\tFROM dual;\n" +
                "\t\t\tINSERT INTO departments\n" +
                "\t\t\tVALUES (new_deptno, 'department name', 100, 1700);\n" +
                "\t\t\ttot_depts := tot_depts + 1;\n" +
                "\t\t\tRETURN(new_deptno);\n" +
                "\t\tEND;\n" +
                "\tPROCEDURE remove_emp (\n" +
                "\t\temployee_id NUMBER\n" +
                "\t) IS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tDELETE FROM employees\n" +
                "\t\t\tWHERE employees.employee_id = remove_emp.employee_id;\n" +
                "\t\t\ttot_emps := tot_emps - 1;\n" +
                "\t\tEND;\n" +
                "\tPROCEDURE remove_dept (\n" +
                "\t\tdepartment_id NUMBER\n" +
                "\t) IS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tDELETE FROM departments\n" +
                "\t\t\tWHERE departments.department_id = remove_dept.department_id;\n" +
                "\t\t\ttot_depts := tot_depts - 1;\n" +
                "\t\t\tSELECT COUNT(*)\n" +
                "\t\t\tINTO tot_emps\n" +
                "\t\t\tFROM employees;\n" +
                "\t\tEND;\n" +
                "\tPROCEDURE increase_sal (\n" +
                "\t\temployee_id NUMBER,\n" +
                "\t\tsalary_incr NUMBER\n" +
                "\t) IS\n" +
                "\t\tcurr_sal NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT salary\n" +
                "\t\t\tINTO curr_sal\n" +
                "\t\t\tFROM employees\n" +
                "\t\t\tWHERE employees.employee_id = increase_sal.employee_id;\n" +
                "\t\t\tIF curr_sal IS NULL THEN\n" +
                "\t\t\t\tRAISE no_sal;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tUPDATE employees\n" +
                "\t\t\t\tSET salary = salary + salary_incr\n" +
                "\t\t\t\tWHERE employee_id = employee_id;\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tPROCEDURE increase_comm (\n" +
                "\t\temployee_id NUMBER,\n" +
                "\t\tcomm_incr NUMBER\n" +
                "\t) IS\n" +
                "\t\tcurr_comm NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT commission_pct\n" +
                "\t\t\tINTO curr_comm\n" +
                "\t\t\tFROM employees\n" +
                "\t\t\tWHERE employees.employee_id = increase_comm.employee_id;\n" +
                "\t\t\tIF curr_comm IS NULL THEN\n" +
                "\t\t\t\tRAISE no_comm;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tUPDATE employees\n" +
                "\t\t\t\tSET commission_pct = commission_pct + comm_incr;\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "END emp_mgmt;", formatSQL);
    }



}
