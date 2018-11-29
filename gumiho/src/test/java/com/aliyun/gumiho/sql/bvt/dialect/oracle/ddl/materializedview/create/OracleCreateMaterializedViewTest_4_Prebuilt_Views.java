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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.materializedview.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateMaterializedViewTest_4_Prebuilt_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW sales_sum_table\n" +
                "   ON PREBUILT TABLE WITH REDUCED PRECISION\n" +
                "   ENABLE QUERY REWRITE\n" +
                "   AS SELECT t.calendar_month_desc AS month, \n" +
                "             c.cust_state_province AS state,\n" +
                "             SUM(s.amount_sold) AS sales\n" +
                "      FROM times t, customers c, sales s\n" +
                "      WHERE s.time_id = t.time_id AND s.cust_id = c.cust_id\n" +
                "      GROUP BY t.calendar_month_desc, c.cust_state_province;\n";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW sales_sum_table\n" +
                "ON PREBUILT TABLE WITH REDUCED PRECISION\n" +
                "ENABLE QUERY REWRITE\n" +
                "AS\n" +
                "\tSELECT t.calendar_month_desc AS month, c.cust_state_province AS state,\n" +
                "\t\tSUM(s.amount_sold) AS sales\n" +
                "\tFROM times t, customers c, sales s\n" +
                "\tWHERE s.time_id = t.time_id AND s.cust_id = c.cust_id\n" +
                "\tGROUP BY t.calendar_month_desc, c.cust_state_province;", formatSQL);
    }
}
