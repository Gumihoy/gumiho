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
public class OracleCreateTableTest_17_Range_Partitioning_Live_SQL {

    @Test
    public void test() {
        String s = "CREATE TABLE empl_h  \n" +
                "  (  \n" +
                "     employee_id  NUMBER(6) PRIMARY KEY,  \n" +
                "     first_name   VARCHAR2(20),  \n" +
                "     last_name    VARCHAR2(25),  \n" +
                "     email        VARCHAR2(25),  \n" +
                "     phone_number VARCHAR2(20),  \n" +
                "     hire_date    DATE DEFAULT SYSDATE,  \n" +
                "     job_id       VARCHAR2(10),  \n" +
                "     salary       NUMBER(8, 2),  \n" +
                "     part_name    VARCHAR2(25)  \n" +
                "  ) PARTITION BY RANGE (hire_date) (  \n" +
                "PARTITION hire_q1 VALUES less than(to_date('01-APR-2014', 'DD-MON-YYYY')),   \n" +
                "PARTITION hire_q2 VALUES less than(to_date('01-JUL-2014', 'DD-MON-YYYY')),   \n" +
                "PARTITION hire_q3 VALUES less than(to_date('01-OCT-2014', 'DD-MON-YYYY')),   \n" +
                "PARTITION hire_q4 VALUES less than(to_date('01-JAN-2015', 'DD-MON-YYYY'))  \n" +
                "); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE empl_h (\n" +
                "\temployee_id NUMBER(6) PRIMARY KEY,\n" +
                "\tfirst_name VARCHAR2(20),\n" +
                "\tlast_name VARCHAR2(25),\n" +
                "\temail VARCHAR2(25),\n" +
                "\tphone_number VARCHAR2(20),\n" +
                "\thire_date DATE DEFAULT SYSDATE,\n" +
                "\tjob_id VARCHAR2(10),\n" +
                "\tsalary NUMBER(8, 2),\n" +
                "\tpart_name VARCHAR2(25)\n" +
                ")\n" +
                "PARTITION BY RANGE (hire_date) (\n" +
                "\tPARTITION hire_q1 VALUES LESS THAN (to_date('01-APR-2014', 'DD-MON-YYYY')),\n" +
                "\tPARTITION hire_q2 VALUES LESS THAN (to_date('01-JUL-2014', 'DD-MON-YYYY')),\n" +
                "\tPARTITION hire_q3 VALUES LESS THAN (to_date('01-OCT-2014', 'DD-MON-YYYY')),\n" +
                "\tPARTITION hire_q4 VALUES LESS THAN (to_date('01-JAN-2015', 'DD-MON-YYYY'))\n" +
                ");", formatSQL);
    }
}
