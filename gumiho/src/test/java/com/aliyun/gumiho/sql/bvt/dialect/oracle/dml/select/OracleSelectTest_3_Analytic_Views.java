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
public class OracleSelectTest_3_Analytic_Views {

    @Test
    public void test1() {
        String sql = "SELECT time_hier.member_name as TIME,\n" +
                " sales,\n" +
                " units\n" +
                "FROM\n" +
                " sales_av HIERARCHIES(time_hier)\n" +
                "WHERE time_hier.level_name = 'YEAR'\n" +
                "ORDER BY time_hier.hier_order;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT time_hier.member_name AS TIME, sales, units\n" +
                "FROM sales_av HIERARCHIES (time_hier)\n" +
                "WHERE time_hier.level_name = 'YEAR'\n" +
                "ORDER BY time_hier.hier_order;", format);
    }


    @Test
    public void test2() {
        String sql = "WITH\n" +
                "  my_av ANALYTIC VIEW AS (\n" +
                "    USING sales_av HIERARCHIES (time_hier)\n" +
                "    FILTER FACT (\n" +
                "      time_hier TO quarter_of_year IN (1, 2) \n" +
                "        AND year_name IN ('CY2011', 'CY2012')\n" +
                "    )\n" +
                "  )\n" +
                "SELECT time_hier.member_name time, sales\n" +
                "  FROM my_av HIERARCHIES (time_hier)\n" +
                "  WHERE time_hier.level_name IN ('YEAR', 'QUARTER')\n" +
                "  ORDER BY time_hier.hier_order;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\tmy_av ANALYTIC VIEW AS (\n" +
                "\t\tUSING sales_av HIERARCHIES (time_hier)\n" +
                "\t\tFILTER FACT (\n" +
                "\t\t\ttime_hier TO quarter_of_year IN (1, 2) AND year_name IN ('CY2011', 'CY2012')\n" +
                "\t\t)\n" +
                "\t)\n" +
                "SELECT time_hier.member_name time, sales\n" +
                "FROM my_av HIERARCHIES (time_hier)\n" +
                "WHERE time_hier.level_name IN ('YEAR', 'QUARTER')\n" +
                "ORDER BY time_hier.hier_order;", format);
    }

}
