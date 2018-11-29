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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.materializedview.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateMaterializedViewTest_2_Aggregate_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW sales_mv\n" +
                "   BUILD IMMEDIATE\n" +
                "   REFRESH FAST ON COMMIT\n" +
                "   AS SELECT t.calendar_year, p.prod_id, \n" +
                "      SUM(s.amount_sold) AS sum_sales\n" +
                "      FROM times t, products p, sales s\n" +
                "      WHERE t.time_id = s.time_id AND p.prod_id = s.prod_id\n" +
                "      GROUP BY t.calendar_year, p.prod_id; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW sales_mv\n" +
                "BUILD IMMEDIATE\n" +
                "REFRESH FAST ON COMMIT\n" +
                "AS\n" +
                "\tSELECT t.calendar_year, p.prod_id, SUM(s.amount_sold) AS sum_sales\n" +
                "\tFROM times t, products p, sales s\n" +
                "\tWHERE t.time_id = s.time_id AND p.prod_id = s.prod_id\n" +
                "\tGROUP BY t.calendar_year, p.prod_id;", formatSQL);
    }
}
