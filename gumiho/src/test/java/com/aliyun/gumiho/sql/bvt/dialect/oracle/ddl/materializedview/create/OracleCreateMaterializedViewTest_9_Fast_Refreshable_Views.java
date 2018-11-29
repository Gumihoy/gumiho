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
public class OracleCreateMaterializedViewTest_9_Fast_Refreshable_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW warranty_orders REFRESH FAST AS\n" +
                "  SELECT order_id, line_item_id, product_id FROM order_items o\n" +
                "    WHERE EXISTS\n" +
                "    (SELECT * FROM inventories i WHERE o.product_id = i.product_id\n" +
                "      AND i.quantity_on_hand IS NOT NULL)\n" +
                "  UNION\n" +
                "    SELECT order_id, line_item_id, product_id FROM order_items\n" +
                "    WHERE quantity > 5; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW warranty_orders\n" +
                "REFRESH FAST\n" +
                "AS\n" +
                "\tSELECT order_id, line_item_id, product_id\n" +
                "\tFROM order_items o\n" +
                "\tWHERE EXISTS (\n" +
                "\t\t\tSELECT *\n" +
                "\t\t\tFROM inventories i\n" +
                "\t\t\tWHERE o.product_id = i.product_id AND i.quantity_on_hand IS NOT NULL\n" +
                "\t\t)\n" +
                "\tUNION\n" +
                "\tSELECT order_id, line_item_id, product_id\n" +
                "\tFROM order_items\n" +
                "\tWHERE quantity > 5;", formatSQL);
    }
}
