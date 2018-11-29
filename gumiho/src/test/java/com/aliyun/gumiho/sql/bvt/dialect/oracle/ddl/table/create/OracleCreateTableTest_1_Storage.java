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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateTableTest_1_Storage {

    @Test
    public void test() {
        String s = "CREATE TABLE employees_demo\n" +
                "    ( employee_id    NUMBER(6)\n" +
                "    , first_name     VARCHAR2(20)\n" +
                "    , last_name      VARCHAR2(25) \n" +
                "         CONSTRAINT emp_last_name_nn_demo NOT NULL\n" +
                "    , email          VARCHAR2(25) \n" +
                "         CONSTRAINT emp_email_nn_demo     NOT NULL\n" +
                "    , phone_number   VARCHAR2(20)\n" +
                "    , hire_date      DATE  DEFAULT SYSDATE \n" +
                "         CONSTRAINT emp_hire_date_nn_demo  NOT NULL\n" +
                "    , job_id         VARCHAR2(10)\n" +
                "       CONSTRAINT     emp_job_nn_demo  NOT NULL\n" +
                "    , salary         NUMBER(8,2)\n" +
                "       CONSTRAINT     emp_salary_nn_demo  NOT NULL\n" +
                "    , commission_pct NUMBER(2,2)\n" +
                "    , manager_id     NUMBER(6)\n" +
                "    , department_id  NUMBER(4)\n" +
                "    , dn             VARCHAR2(300)\n" +
                "    , CONSTRAINT     emp_salary_min_demo\n" +
                "                     CHECK (salary > 0) \n" +
                "    , CONSTRAINT     emp_email_uk_demo\n" +
                "                     UNIQUE (email)\n" +
                "    ) \n" +
                "   TABLESPACE example \n" +
                "   STORAGE (INITIAL 8M); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE employees_demo (\n" +
                "\temployee_id NUMBER(6),\n" +
                "\tfirst_name VARCHAR2(20),\n" +
                "\tlast_name VARCHAR2(25) CONSTRAINT emp_last_name_nn_demo NOT NULL,\n" +
                "\temail VARCHAR2(25) CONSTRAINT emp_email_nn_demo NOT NULL,\n" +
                "\tphone_number VARCHAR2(20),\n" +
                "\thire_date DATE DEFAULT SYSDATE CONSTRAINT emp_hire_date_nn_demo NOT NULL,\n" +
                "\tjob_id VARCHAR2(10) CONSTRAINT emp_job_nn_demo NOT NULL,\n" +
                "\tsalary NUMBER(8, 2) CONSTRAINT emp_salary_nn_demo NOT NULL,\n" +
                "\tcommission_pct NUMBER(2, 2),\n" +
                "\tmanager_id NUMBER(6),\n" +
                "\tdepartment_id NUMBER(4),\n" +
                "\tdn VARCHAR2(300),\n" +
                "\tCONSTRAINT emp_salary_min_demo CHECK (salary > 0),\n" +
                "\tCONSTRAINT emp_email_uk_demo UNIQUE (email)\n" +
                ")\n" +
                "TABLESPACE example\n" +
                "STORAGE (\n" +
                "\tINITIAL 8M\n" +
                ");", formatSQL);
    }
}
