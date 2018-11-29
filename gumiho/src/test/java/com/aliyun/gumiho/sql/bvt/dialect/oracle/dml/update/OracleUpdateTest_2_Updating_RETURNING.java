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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.update;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleUpdateTest_2_Updating_RETURNING {

    @Test
    public void test1() {
        String sql = "UPDATE employees\n" +
                "  SET job_id ='SA_MAN', salary = salary + 1000, department_id = 140\n" +
                "  WHERE last_name = 'Jones'\n" +
                "  RETURNING salary*0.25, last_name, department_id\n" +
                "    INTO :bnd1, :bnd2, :bnd3;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees\n" +
                "SET job_id = 'SA_MAN', salary = salary + 1000, department_id = 140\n" +
                "WHERE last_name = 'Jones'\n" +
                "RETURNING salary * 0.25, last_name, department_id INTO :bnd1, :bnd2, :bnd3;", format);
    }



    @Test
    public void test2() {
        String sql = "UPDATE employees\n" +
                "   SET salary = salary * 1.1\n" +
                "   WHERE department_id = 100\n" +
                "   RETURNING SUM(salary) INTO :bnd1;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE employees\n" +
                "SET salary = salary * 1.1\n" +
                "WHERE department_id = 100\n" +
                "RETURNING SUM(salary) INTO :bnd1;", format);
    }
}
