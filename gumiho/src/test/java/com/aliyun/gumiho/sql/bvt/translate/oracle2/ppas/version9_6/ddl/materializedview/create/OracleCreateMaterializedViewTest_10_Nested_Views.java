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
public class OracleCreateMaterializedViewTest_10_Nested_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW my_warranty_orders\n" +
                "   AS SELECT w.order_id, w.line_item_id, o.order_date\n" +
                "   FROM warranty_orders w, orders o\n" +
                "   WHERE o.order_id = o.order_id\n" +
                "   AND o.sales_rep_id = 165; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW my_warranty_orders\n" +
                "AS\n" +
                "\tSELECT w.order_id, w.line_item_id, o.order_date\n" +
                "\tFROM warranty_orders w, orders o\n" +
                "\tWHERE o.order_id = o.order_id AND o.sales_rep_id = 165;", formatSQL);
    }
}
