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
public class OracleCreateTableTest_20_Partitioned_Table_with_LOB_Columns {

    @Test
    public void test() {
        String s = "CREATE TABLE print_media_demo\n" +
                "   ( product_id NUMBER(6)\n" +
                "   , ad_id NUMBER(6)\n" +
                "   , ad_composite BLOB\n" +
                "   , ad_sourcetext CLOB\n" +
                "   , ad_finaltext CLOB\n" +
                "   , ad_fltextn NCLOB\n" +
                "   , ad_textdocs_ntab textdoc_tab\n" +
                "   , ad_photo BLOB\n" +
                "   , ad_graphic BFILE\n" +
                "   , ad_header adheader_typ\n" +
                "   ) NESTED TABLE ad_textdocs_ntab STORE AS textdocs_nestedtab_demo\n" +
                "      LOB (ad_composite, ad_photo, ad_finaltext)\n" +
                "      STORE AS(STORAGE (INITIAL 20M))\n" +
                "   PARTITION BY RANGE (product_id)\n" +
                "      (PARTITION p1 VALUES LESS THAN (3000) TABLESPACE tbs_01\n" +
                "         LOB (ad_composite, ad_photo)\n" +
                "         STORE AS (TABLESPACE tbs_02 STORAGE (INITIAL 10M))\n" +
                "         NESTED TABLE ad_textdocs_ntab STORE AS nt_p1 (TABLESPACE example),\n" +
                "       PARTITION P2 VALUES LESS THAN (MAXVALUE)\n" +
                "         LOB (ad_composite, ad_finaltext)\n" +
                "         STORE AS SECUREFILE (TABLESPACE auto_seg_ts)\n" +
                "         NESTED TABLE ad_textdocs_ntab STORE AS nt_p2\n" +
                "       ) ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE print_media_demo (\n" +
                "\tproduct_id NUMBER(6),\n" +
                "\tad_id NUMBER(6),\n" +
                "\tad_composite BLOB,\n" +
                "\tad_sourcetext CLOB,\n" +
                "\tad_finaltext CLOB,\n" +
                "\tad_fltextn NCLOB,\n" +
                "\tad_textdocs_ntab textdoc_tab,\n" +
                "\tad_photo BLOB,\n" +
                "\tad_graphic BFILE,\n" +
                "\tad_header adheader_typ\n" +
                ")\n" +
                "NESTED TABLE ad_textdocs_ntab\n" +
                "STORE AS textdocs_nestedtab_demo\n" +
                "LOB (ad_composite, ad_photo, ad_finaltext) STORE AS (\n" +
                "\tSTORAGE (\n" +
                "\t\tINITIAL 20M\n" +
                "\t)\n" +
                ")\n" +
                "PARTITION BY RANGE (product_id) (\n" +
                "\tPARTITION p1 VALUES LESS THAN (3000)\n" +
                "\t\tTABLESPACE tbs_01\n" +
                "\t\tLOB (ad_composite, ad_photo) STORE AS (\n" +
                "\t\t\tTABLESPACE tbs_02\n" +
                "\t\t\tSTORAGE (\n" +
                "\t\t\t\tINITIAL 10M\n" +
                "\t\t\t)\n" +
                "\t\t)\n" +
                "\t\tNESTED TABLE ad_textdocs_ntab\n" +
                "\t\tSTORE AS nt_p1 (\n" +
                "\t\t\tTABLESPACE example\n" +
                "\t\t),\n" +
                "\tPARTITION P2 VALUES LESS THAN (MAXVALUE)\n" +
                "\t\tLOB (ad_composite, ad_finaltext) STORE AS SECUREFILE (\n" +
                "\t\t\tTABLESPACE auto_seg_ts\n" +
                "\t\t)\n" +
                "\t\tNESTED TABLE ad_textdocs_ntab\n" +
                "\t\tSTORE AS nt_p2\n" +
                ")", formatSQL);
    }
}
