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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.dml.select;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class Oracle2MySQLSelectTest_15_PIVOT_UNPIVOT {

    @Test
    public void test_0() {
        String sql = "SELECT * FROM\n" +
                "(SELECT EXTRACT(YEAR FROM order_date) year, order_mode, order_total FROM orders)\n" +
                "PIVOT\n" +
                "(SUM(order_total) FOR order_mode IN ('direct' AS Store, 'online' AS Internet));";
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM (\n" +
                "\tSELECT EXTRACT(YEAR FROM order_date) year, order_mode, order_total\n" +
                "\tFROM orders\n" +
                ")\n" +
                "PIVOT (\n" +
                "\tSUM(order_total)\n" +
                "\tFOR order_mode\n" +
                "\tIN (\n" +
                "\t\t'direct' AS Store,\n" +
                "\t\t'online' AS Internet\n" +
                "\t)\n" +
                ");", result.targetSql);
    }


    @Test
    public void test_1() {
        String sql = "SELECT * FROM pivot_table\n" +
                "  UNPIVOT INCLUDE NULLS \n" +
                "    (yearly_total FOR order_mode IN (store AS 'direct', internet AS 'online'))\n" +
                "  ORDER BY year, order_mode;";
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM pivot_table\n" +
                "\tUNPIVOT INCLUDE NULLS (\n" +
                "\t\tyearly_total\n" +
                "\t\tFOR order_mode\n" +
                "\t\tIN (\n" +
                "\t\t\tstore AS 'direct',\n" +
                "\t\t\tinternet AS 'online'\n" +
                "\t\t)\n" +
                "\t)\n" +
                "ORDER BY year, order_mode;", result.targetSql);
    }
}
