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
public class OracleAlterTableTest_14_Adding_Partition_And_Nested_Table {

    @Test
    public void test_0() {
        String s = "ALTER TABLE print_media_part ADD PARTITION p3 VALUES LESS THAN (400)\n" +
                "  LOB(ad_photo, ad_composite) STORE AS (TABLESPACE omf_ts1)\n" +
                "  LOB(ad_sourcetext, ad_finaltext) STORE AS (TABLESPACE omf_ts2)\n" +
                "  NESTED TABLE ad_textdocs_ntab STORE AS nt_p3; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE print_media_part\n" +
                "\tADD\n" +
                "\t\tPARTITION p3 VALUES LESS THAN (400)\n" +
                "\t\t\tLOB (ad_photo, ad_composite) STORE AS (\n" +
                "\t\t\t\tTABLESPACE omf_ts1\n" +
                "\t\t\t)\n" +
                "\t\t\tLOB (ad_sourcetext, ad_finaltext) STORE AS (\n" +
                "\t\t\t\tTABLESPACE omf_ts2\n" +
                "\t\t\t)\n" +
                "\t\t\tNESTED TABLE ad_textdocs_ntab\n" +
                "\t\t\tSTORE AS nt_p3;", formatSQL);
    }

}
