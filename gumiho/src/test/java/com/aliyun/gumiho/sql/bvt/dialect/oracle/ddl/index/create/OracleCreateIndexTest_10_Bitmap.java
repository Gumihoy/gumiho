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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.index.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateIndexTest_10_Bitmap {

    @Test
    public void test1() {
        String s = "CREATE BITMAP INDEX product_bm_ix\n" +
                "   ON hash_products(list_price)\n" +
                "   FROM hash_products h, sales_quota s\n" +
                "   WHERE h.product_id = s.product_id\n" +
                "   LOCAL(PARTITION ix_p1 TABLESPACE example,\n" +
                "         PARTITION ix_p2,\n" +
                "         PARTITION ix_p3 TABLESPACE example,\n" +
                "         PARTITION ix_p4,\n" +
                "         PARTITION ix_p5 TABLESPACE example)\n" +
                "   TABLESPACE example; ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE BITMAP INDEX product_bm_ix ON hash_products (\n" +
                "\tlist_price\n" +
                ")\n" +
                "FROM hash_products h, sales_quota s\n" +
                "WHERE h.product_id = s.product_id\n" +
                "LOCAL (\n" +
                "\tPARTITION ix_p1\n" +
                "\t\tTABLESPACE example,\n" +
                "\tPARTITION ix_p2,\n" +
                "\tPARTITION ix_p3\n" +
                "\t\tTABLESPACE example,\n" +
                "\tPARTITION ix_p4,\n" +
                "\tPARTITION ix_p5\n" +
                "\t\tTABLESPACE example\n" +
                ")\n" +
                "TABLESPACE example;", formatSQL);
    }

}
