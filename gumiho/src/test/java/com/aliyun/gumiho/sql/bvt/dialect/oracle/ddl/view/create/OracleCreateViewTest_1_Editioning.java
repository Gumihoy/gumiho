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
public class OracleCreateViewTest_1_Editioning {

    @Test
    public void test1() {
        String s = "CREATE EDITIONING VIEW ed_orders_view (o_id, o_date, o_status)\n" +
                "  AS SELECT order_id, order_date, order_status FROM orders\n" +
                "  WITH READ ONLY; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE EDITIONING VIEW ed_orders_view (\n" +
                "\to_id,\n" +
                "\to_date,\n" +
                "\to_status\n" +
                ")\n" +
                "AS\n" +
                "\tSELECT order_id, order_date, order_status\n" +
                "\tFROM orders\n" +
                "WITH READ ONLY;", formatSQL);
    }


}
