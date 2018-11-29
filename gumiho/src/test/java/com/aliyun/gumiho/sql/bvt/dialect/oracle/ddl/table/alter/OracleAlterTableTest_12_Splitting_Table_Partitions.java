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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterTableTest_12_Splitting_Table_Partitions {

    @Test
    public void test_0() {
        String s = "ALTER TABLE sales SPLIT PARTITION SALES_Q4_2000 \n" +
                "   AT (TO_DATE('15-NOV-2000','DD-MON-YYYY'))\n" +
                "   INTO (PARTITION SALES_Q4_2000, PARTITION SALES_Q4_2000b); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE sales\n" +
                "\tSPLIT PARTITION SALES_Q4_2000 AT (\n" +
                "\t\tTO_DATE('15-NOV-2000', 'DD-MON-YYYY')\n" +
                "\t)\n" +
                "\tINTO (\n" +
                "\t\tPARTITION SALES_Q4_2000,\n" +
                "\t\tPARTITION SALES_Q4_2000b\n" +
                "\t);", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "ALTER TABLE sales SPLIT PARTITION SALES_Q1_2002 INTO (\n" +
                " PARTITION SALES_JAN_2002 VALUES LESS THAN (TO_DATE('01-FEB-2002','DD-MON-YYYY')),\n" +
                " PARTITION SALES_FEB_2002 VALUES LESS THAN (TO_DATE('01-MAR-2002','DD-MON-YYYY')),\n" +
                " PARTITION SALES_MAR_2002); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE sales\n" +
                "\tSPLIT PARTITION SALES_Q1_2002 \n" +
                "\tINTO (\n" +
                "\t\tPARTITION SALES_JAN_2002 VALUES LESS THAN (TO_DATE('01-FEB-2002', 'DD-MON-YYYY')),\n" +
                "\t\tPARTITION SALES_FEB_2002 VALUES LESS THAN (TO_DATE('01-MAR-2002', 'DD-MON-YYYY')),\n" +
                "\t\tPARTITION SALES_MAR_2002\n" +
                "\t);", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "ALTER TABLE print_media_part\n" +
                "   SPLIT PARTITION p2 AT (150) INTO\n" +
                "   (PARTITION p2a TABLESPACE omf_ts1\n" +
                "      LOB (ad_photo, ad_composite) STORE AS (TABLESPACE omf_ts2),\n" +
                "   PARTITION p2b \n" +
                "      LOB (ad_photo, ad_composite) STORE AS (TABLESPACE omf_ts2))\n" +
                "   NESTED TABLE ad_textdocs_ntab INTO (PARTITION nt_p2a, PARTITION nt_p2b); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE print_media_part\n" +
                "\tSPLIT PARTITION p2 AT (\n" +
                "\t\t150\n" +
                "\t)\n" +
                "\tINTO (\n" +
                "\t\tPARTITION p2a\n" +
                "\t\t\tTABLESPACE omf_ts1\n" +
                "\t\t\tLOB (ad_photo, ad_composite) STORE AS (\n" +
                "\t\t\t\tTABLESPACE omf_ts2\n" +
                "\t\t\t),\n" +
                "\t\tPARTITION p2b\n" +
                "\t\t\tLOB (ad_photo, ad_composite) STORE AS (\n" +
                "\t\t\t\tTABLESPACE omf_ts2\n" +
                "\t\t\t)\n" +
                "\t)\n" +
                "\tNESTED TABLE ad_textdocs_ntab INTO (\n" +
                "\t\tPARTITION nt_p2a,\n" +
                "\t\tPARTITION nt_p2b\n" +
                "\t);", formatSQL);
    }
}
