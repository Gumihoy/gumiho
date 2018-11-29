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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.view.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateViewTest_5_Object {

    @Test
    public void test1() {
        String s = "CREATE OR REPLACE VIEW oc_inventories OF inventory_typ\n" +
                " WITH OBJECT ID (product_id)\n" +
                " AS SELECT i.product_id,\n" +
                "           warehouse_typ(w.warehouse_id, w.warehouse_name, w.location_id),\n" +
                "           i.quantity_on_hand\n" +
                "    FROM inventories i, warehouses w\n" +
                "    WHERE i.warehouse_id=w.warehouse_id; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE VIEW oc_inventories OF inventory_typ\n" +
                "WITH OBJECT ID (product_id)\n" +
                "AS\n" +
                "\tSELECT i.product_id,\n" +
                "\t\twarehouse_typ(w.warehouse_id, w.warehouse_name, w.location_id),\n" +
                "\t\ti.quantity_on_hand\n" +
                "\tFROM inventories i, warehouses w\n" +
                "\tWHERE i.warehouse_id = w.warehouse_id;", formatSQL);
    }


}
