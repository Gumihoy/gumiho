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
public class OracleSelectTest_18_Table_Function_Table_Reference {

    @Test
    public void test_0() {
        String sql = "SELECT t1.department_id, t2.* FROM hr_info t1, TABLE(t1.people) t2\n" +
                "   WHERE t2.department_id = t1.department_id;\n";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT t1.department_id, t2.*\n" +
                "FROM hr_info t1, TABLE(t1.people) t2\n" +
                "WHERE t2.department_id = t1.department_id;", format);
    }


    @Test
    public void test_1() {
        String sql = "SELECT t1.department_id, t2.* \n" +
                "   FROM hr_info t1, TABLE(CAST(MULTISET(\n" +
                "      SELECT t3.last_name, t3.department_id, t3.salary \n" +
                "         FROM people t3\n" +
                "      WHERE t3.department_id = t1.department_id)\n" +
                "      AS people_tab_typ)) t2;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT t1.department_id, t2.*\n" +
                "FROM hr_info t1, TABLE(CAST(MULTISET(\n" +
                "\tSELECT t3.last_name, t3.department_id, t3.salary\n" +
                "\tFROM people t3\n" +
                "\tWHERE t3.department_id = t1.department_id\n" +
                ") AS people_tab_typ)) t2;", format);
    }


}
