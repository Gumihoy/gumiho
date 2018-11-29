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
public class OracleCreateIndexTest_9_Composite_Partitioned_Table {

    @Test
    public void test1() {
        String s = "CREATE INDEX sales_ix ON composite_sales(time_id, prod_id)\n" +
                "   STORAGE (INITIAL 1M)\n" +
                "   LOCAL\n" +
                "   (PARTITION q1_1998,\n" +
                "    PARTITION q2_1998,\n" +
                "    PARTITION q3_1998,\n" +
                "    PARTITION q4_1998,\n" +
                "    PARTITION q1_1999,\n" +
                "    PARTITION q2_1999,\n" +
                "    PARTITION q3_1999,\n" +
                "    PARTITION q4_1999,\n" +
                "    PARTITION q1_2000,\n" +
                "    PARTITION q2_2000\n" +
                "      (SUBPARTITION pq2001, SUBPARTITION pq2002, \n" +
                "       SUBPARTITION pq2003, SUBPARTITION pq2004,\n" +
                "       SUBPARTITION pq2005, SUBPARTITION pq2006, \n" +
                "       SUBPARTITION pq2007, SUBPARTITION pq2008),\n" +
                "    PARTITION q3_2000\n" +
                "      (SUBPARTITION c1 TABLESPACE tbs_02, \n" +
                "       SUBPARTITION c2 TABLESPACE tbs_02, \n" +
                "       SUBPARTITION c3 TABLESPACE tbs_02,\n" +
                "       SUBPARTITION c4 TABLESPACE tbs_02,\n" +
                "       SUBPARTITION c5 TABLESPACE tbs_02),\n" +
                "    PARTITION q4_2000\n" +
                "      (SUBPARTITION pq4001 TABLESPACE tbs_03, \n" +
                "       SUBPARTITION pq4002 TABLESPACE tbs_03,\n" +
                "       SUBPARTITION pq4003 TABLESPACE tbs_03,\n" +
                "       SUBPARTITION pq4004 TABLESPACE tbs_03)\n" +
                "); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX sales_ix ON composite_sales (\n" +
                "\ttime_id,\n" +
                "\tprod_id\n" +
                ")\n" +
                "STORAGE (\n" +
                "\tINITIAL 1M\n" +
                ")\n" +
                "LOCAL (\n" +
                "\tPARTITION q1_1998,\n" +
                "\tPARTITION q2_1998,\n" +
                "\tPARTITION q3_1998,\n" +
                "\tPARTITION q4_1998,\n" +
                "\tPARTITION q1_1999,\n" +
                "\tPARTITION q2_1999,\n" +
                "\tPARTITION q3_1999,\n" +
                "\tPARTITION q4_1999,\n" +
                "\tPARTITION q1_2000,\n" +
                "\tPARTITION q2_2000 (\n" +
                "\t\tSUBPARTITION pq2001,\n" +
                "\t\tSUBPARTITION pq2002,\n" +
                "\t\tSUBPARTITION pq2003,\n" +
                "\t\tSUBPARTITION pq2004,\n" +
                "\t\tSUBPARTITION pq2005,\n" +
                "\t\tSUBPARTITION pq2006,\n" +
                "\t\tSUBPARTITION pq2007,\n" +
                "\t\tSUBPARTITION pq2008\n" +
                "\t),\n" +
                "\tPARTITION q3_2000 (\n" +
                "\t\tSUBPARTITION c1\n" +
                "\t\t\tTABLESPACE tbs_02,\n" +
                "\t\tSUBPARTITION c2\n" +
                "\t\t\tTABLESPACE tbs_02,\n" +
                "\t\tSUBPARTITION c3\n" +
                "\t\t\tTABLESPACE tbs_02,\n" +
                "\t\tSUBPARTITION c4\n" +
                "\t\t\tTABLESPACE tbs_02,\n" +
                "\t\tSUBPARTITION c5\n" +
                "\t\t\tTABLESPACE tbs_02\n" +
                "\t),\n" +
                "\tPARTITION q4_2000 (\n" +
                "\t\tSUBPARTITION pq4001\n" +
                "\t\t\tTABLESPACE tbs_03,\n" +
                "\t\tSUBPARTITION pq4002\n" +
                "\t\t\tTABLESPACE tbs_03,\n" +
                "\t\tSUBPARTITION pq4003\n" +
                "\t\t\tTABLESPACE tbs_03,\n" +
                "\t\tSUBPARTITION pq4004\n" +
                "\t\t\tTABLESPACE tbs_03\n" +
                "\t)\n" +
                ");", formatSQL);
    }

}
