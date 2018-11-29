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
public class OracleSelectTest_17_Semijoins {

    @Test
    public void test1() {
        String sql = "SELECT * FROM departments \n" +
                "   WHERE EXISTS \n" +
                "   (SELECT * FROM employees \n" +
                "       WHERE departments.department_id = employees.department_id \n" +
                "       AND employees.salary > 2500)\n" +
                "   ORDER BY department_name;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM departments\n" +
                "WHERE EXISTS (\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE departments.department_id = employees.department_id\n" +
                "\t\t\tAND employees.salary > 2500\n" +
                "\t)\n" +
                "ORDER BY department_name;", format);
    }


}
