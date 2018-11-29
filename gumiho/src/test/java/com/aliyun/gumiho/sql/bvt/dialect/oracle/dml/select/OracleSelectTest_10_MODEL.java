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
public class OracleSelectTest_10_MODEL {

    @Test
    public void test1() {
        String sql = "SELECT country,prod,year,s\n" +
                "  FROM sales_view_ref\n" +
                "  MODEL\n" +
                "    PARTITION BY (country)\n" +
                "    DIMENSION BY (prod, year)\n" +
                "    MEASURES (sale s)\n" +
                "    IGNORE NAV\n" +
                "    UNIQUE DIMENSION\n" +
                "    RULES UPSERT SEQUENTIAL ORDER\n" +
                "    (\n" +
                "      s[prod='Mouse Pad', year=2001] =\n" +
                "        s['Mouse Pad', 1999] + s['Mouse Pad', 2000],\n" +
                "      s['Standard Mouse', 2002] = s['Standard Mouse', 2001]\n" +
                "    )\n" +
                "  ORDER BY country, prod, year;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT country, prod, year, s\n" +
                "FROM sales_view_ref\n" +
                "MODEL\n" +
                "\tPARTITION BY (country)\n" +
                "\tDIMENSION BY (prod, year)\n" +
                "\tMEASURES (sale s)\n" +
                "\tIGNORE NAV UNIQUE DIMENSION\n" +
                "\tRULES UPSERT SEQUENTIAL ORDER (\n" +
                "\t\ts[prod = 'Mouse Pad', year = 2001] = s['Mouse Pad', 1999] + s['Mouse Pad', 2000],\n" +
                "\t\ts['Standard Mouse', 2002] = s['Standard Mouse', 2001]\n" +
                "\t)\n" +
                "ORDER BY country, prod, year;", format);
    }


}
