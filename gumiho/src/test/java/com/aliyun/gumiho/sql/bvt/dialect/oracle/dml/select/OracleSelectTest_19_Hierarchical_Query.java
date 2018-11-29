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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_19_Hierarchical_Query {

    @Test
    public void test1() {
        String sql = "SELECT LPAD(' ',2*(LEVEL-1)) || last_name org_chart, \n" +
                "        employee_id, manager_id, job_id\n" +
                "    FROM employees\n" +
                "    START WITH job_id = 'AD_VP' \n" +
                "    CONNECT BY PRIOR employee_id = manager_id; ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LPAD(' ', 2 * (LEVEL - 1)) || last_name org_chart, employee_id,\n" +
                "\tmanager_id, job_id\n" +
                "FROM employees\n" +
                "START WITH job_id = 'AD_VP'\n" +
                "CONNECT BY PRIOR employee_id = manager_id;", format);
    }


    @Test
    public void test2() {
        String sql = "SELECT LPAD(' ',2*(LEVEL-1)) || last_name org_chart, \n" +
                "employee_id, manager_id, job_id \n" +
                "    FROM employees\n" +
                "    START WITH job_id = 'AD_PRES' \n" +
                "    CONNECT BY PRIOR employee_id = manager_id AND LEVEL <= 2;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LPAD(' ', 2 * (LEVEL - 1)) || last_name org_chart, employee_id,\n" +
                "\tmanager_id, job_id\n" +
                "FROM employees\n" +
                "START WITH job_id = 'AD_PRES'\n" +
                "CONNECT BY PRIOR employee_id = manager_id AND LEVEL <= 2;", format);
    }
}
