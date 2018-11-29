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
public class OracleAlterTableTest_24_Updating_Partitioned_Indexes {

    @Test
    public void test_0() {
        String s = "ALTER TABLE costs\n" +
                "  SPLIT PARTITION costs_q4_2003 at\n" +
                "    (TO_DATE('01-Nov-2003','dd-mon-yyyy')) \n" +
                "    INTO (PARTITION c_p1, PARTITION c_p2) \n" +
                "  UPDATE INDEXES (cost_ix (PARTITION c_p1 tablespace tbs_02, \n" +
                "                           PARTITION c_p2 tablespace tbs_03));\n ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE costs\n" +
                "\tSPLIT PARTITION costs_q4_2003 AT (\n" +
                "\t\tTO_DATE('01-Nov-2003', 'dd-mon-yyyy')\n" +
                "\t)\n" +
                "\tINTO (\n" +
                "\t\tPARTITION c_p1,\n" +
                "\t\tPARTITION c_p2\n" +
                "\t)\n" +
                "\tUPDATE INDEXES (\n" +
                "\t\tcost_ix (\n" +
                "\t\t\tPARTITION c_p1\n" +
                "\t\t\t\tTABLESPACE tbs_02,\n" +
                "\t\t\tPARTITION c_p2\n" +
                "\t\t\t\tTABLESPACE tbs_03\n" +
                "\t\t)\n" +
                "\t);", formatSQL);
    }

}
