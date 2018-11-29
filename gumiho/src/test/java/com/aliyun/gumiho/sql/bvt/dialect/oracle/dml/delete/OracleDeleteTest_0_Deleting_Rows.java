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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.delete;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleDeleteTest_0_Deleting_Rows {

    @Test
    public void test1() {
        String sql = "DELETE FROM employees\n" +
                "   WHERE job_id = 'SA_REP'\n" +
                "   AND commission_pct < .2;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("DELETE FROM employees\n" +
                "WHERE job_id = 'SA_REP' AND commission_pct < .2;", format);
    }


    @Test
    public void test2() {
        String sql = "DELETE FROM (SELECT * FROM employees)\n" +
                "   WHERE job_id = 'SA_REP'\n" +
                "   AND commission_pct < .2;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("DELETE FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM employees\n" +
                ")\n" +
                "WHERE job_id = 'SA_REP' AND commission_pct < .2;", format);
    }

    @Test
    public void test3() {
        String sql = "DELETE product_price_history partition (p1); ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("DELETE product_price_history PARTITION (p1);", format);
    }
}
