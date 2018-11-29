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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.insert;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleInsertTest_5_Bind_Variables {

    @Test
    public void test1() {
        String sql = "INSERT INTO employees \n" +
                "      (employee_id, last_name, email, hire_date, job_id, salary)\n" +
                "   VALUES \n" +
                "   (employees_seq.nextval, 'Doe', 'john.doe@example.com', \n" +
                "       SYSDATE, 'SH_CLERK', 2400) \n" +
                "   RETURNING salary*12, job_id INTO :bnd1, :bnd2;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO employees (employee_id, last_name, email, hire_date, job_id, salary)\n" +
                "VALUES (employees_seq.NEXTVAL, 'Doe', 'john.doe@example.com', SYSDATE, 'SH_CLERK', 2400)\n" +
                "RETURNING salary * 12, job_id INTO :bnd1, :bnd2;", format);
    }


}
