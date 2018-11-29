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
public class OracleCreateIndexTest_0 {

    @Test
    public void test_0() {
        String s = "CREATE INDEX ord_customer_ix\n" +
                "   ON orders (customer_id); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX ord_customer_ix ON orders (\n" +
                "\tcustomer_id\n" +
                ");", formatSQL);
    }

    @Test
    public void test_1() {
        String s =  "CREATE UNIQUE INDEX \"FINANCE\".\"PK_POS_SEND_UNIQUE\" ON \"FINANCE\".\"POS_SEND_UNIQUE\" (\"SETTLE_ID\", \"PHASE\") REVERSE \n" +
                "  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS \n" +
                "  STORAGE(INITIAL 1048576 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645\n" +
                "  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)\n" +
                "  TABLESPACE \"ZHIFB_INDX\" ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE UNIQUE INDEX \"FINANCE\".\"PK_POS_SEND_UNIQUE\" ON \"FINANCE\".\"POS_SEND_UNIQUE\" (\n" +
                "\t\"SETTLE_ID\",\n" +
                "\t\"PHASE\"\n" +
                ")\n" +
                "REVERSE\n" +
                "PCTFREE 10\n" +
                "INITRANS 2\n" +
                "MAXTRANS 255\n" +
                "COMPUTE STATISTICS\n" +
                "STORAGE (\n" +
                "\tINITIAL 1048576,\n" +
                "\tNEXT 1048576,\n" +
                "\tMINEXTENTS 1,\n" +
                "\tMAXEXTENTS 2147483645,\n" +
                "\tPCTINCREASE 0,\n" +
                "\tFREELISTS 1,\n" +
                "\tFREELIST GROUPS 1,\n" +
                "\tBUFFER_POOL DEFAULT,\n" +
                "\tFLASH_CACHE DEFAULT,\n" +
                "\tCELL_FLASH_CACHE DEFAULT\n" +
                ")\n" +
                "TABLESPACE \"ZHIFB_INDX\"", formatSQL);
    }

}
