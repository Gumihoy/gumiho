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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateTableTest_22_Reference_Partitioning {

    @Test
    public void test() {
        String s = "CREATE TABLE part_order_items (\n" +
                "    order_id        NUMBER(12) PRIMARY KEY,\n" +
                "    line_item_id    NUMBER(3),\n" +
                "    product_id      NUMBER(6) NOT NULL,\n" +
                "    unit_price      NUMBER(8,2),\n" +
                "    quantity        NUMBER(8),\n" +
                "    CONSTRAINT product_id_fk\n" +
                "    FOREIGN KEY (product_id) REFERENCES hash_products(product_id))\n" +
                " PARTITION BY REFERENCE (product_id_fk); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE part_order_items (\n" +
                "\torder_id NUMBER(12) PRIMARY KEY,\n" +
                "\tline_item_id NUMBER(3),\n" +
                "\tproduct_id NUMBER(6) NOT NULL,\n" +
                "\tunit_price NUMBER(8, 2),\n" +
                "\tquantity NUMBER(8),\n" +
                "\tCONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES hash_products(product_id)\n" +
                ")\n" +
                "PARTITION BY REFERENCE (product_id_fk);", formatSQL);
    }
}
