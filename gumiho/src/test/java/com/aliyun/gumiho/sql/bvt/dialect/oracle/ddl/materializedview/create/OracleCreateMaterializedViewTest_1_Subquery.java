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
public class OracleCreateMaterializedViewTest_1_Subquery {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW foreign_customers\n" +
                "   AS SELECT * FROM sh.customers@remote cu\n" +
                "   WHERE EXISTS\n" +
                "     (SELECT * FROM sh.countries@remote co\n" +
                "      WHERE co.country_id = cu.country_id); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW foreign_customers\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM sh.customers@remote cu\n" +
                "\tWHERE EXISTS (\n" +
                "\t\t\tSELECT *\n" +
                "\t\t\tFROM sh.countries@remote co\n" +
                "\t\t\tWHERE co.country_id = cu.country_id\n" +
                "\t\t);", formatSQL);
    }
}
