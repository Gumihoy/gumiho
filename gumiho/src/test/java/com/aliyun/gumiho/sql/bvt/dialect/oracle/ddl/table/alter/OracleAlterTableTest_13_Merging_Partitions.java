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
public class OracleAlterTableTest_13_Merging_Partitions {

    @Test
    public void test_0() {
        String s = "ALTER TABLE sales \n" +
                "   MERGE PARTITIONS sales_q4_2000, sales_q4_2000b\n" +
                "   INTO PARTITION sales_q4_2000; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE sales\n" +
                "\tMERGE PARTITIONS sales_q4_2000, sales_q4_2000b\n" +
                "\tINTO PARTITION sales_q4_2000;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "ALTER TABLE print_media_part \n" +
                "   MERGE PARTITIONS p2a, p2b INTO PARTITION p2ab TABLESPACE example\n" +
                "   NESTED TABLE ad_textdocs_ntab STORE AS nt_p2ab; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE print_media_part\n" +
                "\tMERGE PARTITIONS p2a, p2b\n" +
                "\tINTO PARTITION p2ab\n" +
                "\t\tTABLESPACE example\n" +
                "\t\tNESTED TABLE ad_textdocs_ntab\n" +
                "\t\tSTORE AS nt_p2ab;", formatSQL);
    }


    @Test
    public void test_2() {
        String s = "ALTER TABLE sales\n" +
                "  MERGE PARTITIONS sales_q1_2000 TO sales_q4_2000\n" +
                "  INTO PARTITION sales_all_2000; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE sales\n" +
                "\tMERGE PARTITIONS sales_q1_2000 TO sales_q4_2000\n" +
                "\tINTO PARTITION sales_all_2000;", formatSQL);
    }
}
