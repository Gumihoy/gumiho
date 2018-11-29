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
public class OracleSelectTest_22_Row_Pattern_Matching {

    @Test
    public void test1() {
        String sql = "SELECT *\n" +
                "FROM Ticker MATCH_RECOGNIZE (\n" +
                "     PARTITION BY symbol\n" +
                "     ORDER BY tstamp\n" +
                "     MEASURES STRT.tstamp AS start_tstamp,\n" +
                "              LAST(DOWN.tstamp) AS bottom_tstamp,\n" +
                "              LAST(UP.tstamp) AS end_tstamp\n" +
                "     ONE ROW PER MATCH\n" +
                "     AFTER MATCH SKIP TO LAST UP\n" +
                "     PATTERN (STRT DOWN+ UP+)\n" +
                "     DEFINE\n" +
                "        DOWN AS DOWN.price < PREV(DOWN.price),\n" +
                "        UP AS UP.price > PREV(UP.price)\n" +
                "     ) MR\n" +
                "ORDER BY MR.symbol, MR.start_tstamp;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM Ticker MATCH_RECOGNIZE (\n" +
                "     PARTITION BY symbol\n" +
                "     ORDER BY tstamp\n" +
                "     MEASURES STRT.tstamp AS start_tstamp,\n" +
                "              LAST(DOWN.tstamp) AS bottom_tstamp,\n" +
                "              LAST(UP.tstamp) AS end_tstamp\n" +
                "     ONE ROW PER MATCH\n" +
                "     AFTER MATCH SKIP TO LAST UP\n" +
                "     PATTERN (STRT DOWN+ UP+)\n" +
                "     DEFINE\n" +
                "        DOWN AS DOWN.price < PREV(DOWN.price),\n" +
                "        UP AS UP.price > PREV(UP.price)\n" +
                "     ) MR\n" +
                "ORDER BY MR.symbol, MR.start_tstamp;", format);
    }


}
