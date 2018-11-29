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
public class OracleUpdateTest_2_Updating_an_Object_Partition {

    @Test
    public void test1() {
        String sql = "UPDATE people_demo1 p SET VALUE(p) =\n" +
                "   (SELECT VALUE(q) FROM people_demo2 q\n" +
                "    WHERE p.department_id = q.department_id)\n" +
                "   WHERE p.department_id = 10;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE people_demo1 p\n" +
                "SET VALUE(p) = (\n" +
                "\t\tSELECT VALUE(q)\n" +
                "\t\tFROM people_demo2 q\n" +
                "\t\tWHERE p.department_id = q.department_id\n" +
                "\t)\n" +
                "WHERE p.department_id = 10;", format);
    }

}
