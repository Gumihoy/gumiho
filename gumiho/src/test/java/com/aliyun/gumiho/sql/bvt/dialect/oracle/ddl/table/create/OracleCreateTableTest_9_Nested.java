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
public class OracleCreateTableTest_9_Nested {

    @Test
    public void test() {
        String s = "CREATE TABLE print_media\n" +
                "    ( product_id        NUMBER(6)\n" +
                "    , ad_id             NUMBER(6)\n" +
                "    , ad_composite      BLOB\n" +
                "    , ad_sourcetext     CLOB\n" +
                "    , ad_finaltext      CLOB\n" +
                "    , ad_fltextn        NCLOB\n" +
                "    , ad_textdocs_ntab  textdoc_tab\n" +
                "    , ad_photo          BLOB\n" +
                "    , ad_graphic        BFILE\n" +
                "    , ad_header         adheader_typ\n" +
                "    ) NESTED TABLE ad_textdocs_ntab STORE AS textdocs_nestedtab; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE print_media (\n" +
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
                "STORE AS textdocs_nestedtab;", formatSQL);
    }
}
