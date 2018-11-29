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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.packages.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreatePackageTest_0 {

    @Test
    public void test() {
        String s = "CREATE OR REPLACE PACKAGE emp_mgmt AS \n" +
                "   FUNCTION hire (last_name VARCHAR2, job_id VARCHAR2, \n" +
                "      manager_id NUMBER, salary NUMBER, \n" +
                "      commission_pct NUMBER, department_id NUMBER) \n" +
                "      RETURN NUMBER; \n" +
                "   FUNCTION create_dept(department_id NUMBER, location_id NUMBER) \n" +
                "      RETURN NUMBER; \n" +
                "   PROCEDURE remove_emp(employee_id NUMBER); \n" +
                "   PROCEDURE remove_dept(department_id NUMBER); \n" +
                "   PROCEDURE increase_sal(employee_id NUMBER, salary_incr NUMBER); \n" +
                "   PROCEDURE increase_comm(employee_id NUMBER, comm_incr NUMBER); \n" +
                "   no_comm EXCEPTION; \n" +
                "   no_sal EXCEPTION; \n" +
                "END emp_mgmt; ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE PACKAGE emp_mgmt\n" +
                "AS\n" +
                "\tFUNCTION hire (\n" +
                "\t\tlast_name VARCHAR2,\n" +
                "\t\tjob_id VARCHAR2,\n" +
                "\t\tmanager_id NUMBER,\n" +
                "\t\tsalary NUMBER,\n" +
                "\t\tcommission_pct NUMBER,\n" +
                "\t\tdepartment_id NUMBER\n" +
                "\t) RETURN NUMBER;\n" +
                "\tFUNCTION create_dept (\n" +
                "\t\tdepartment_id NUMBER,\n" +
                "\t\tlocation_id NUMBER\n" +
                "\t) RETURN NUMBER;\n" +
                "\tPROCEDURE remove_emp (\n" +
                "\t\temployee_id NUMBER\n" +
                "\t);\n" +
                "\tPROCEDURE remove_dept (\n" +
                "\t\tdepartment_id NUMBER\n" +
                "\t);\n" +
                "\tPROCEDURE increase_sal (\n" +
                "\t\temployee_id NUMBER,\n" +
                "\t\tsalary_incr NUMBER\n" +
                "\t);\n" +
                "\tPROCEDURE increase_comm (\n" +
                "\t\temployee_id NUMBER,\n" +
                "\t\tcomm_incr NUMBER\n" +
                "\t);\n" +
                "\tno_comm EXCEPTION;\n" +
                "\tno_sal EXCEPTION;\n" +
                "END emp_mgmt;", formatSQL);
    }
}
