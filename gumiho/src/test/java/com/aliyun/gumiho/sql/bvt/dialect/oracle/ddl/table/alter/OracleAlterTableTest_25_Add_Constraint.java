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
public class OracleAlterTableTest_25_Add_Constraint {

    @Test
    public void test_0() {
        String s = "ALTER TABLE dept ADD CONSTRAINT mgr_cons FOREIGN KEY (mgr_ref)\n" +
                "   REFERENCES emp; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE dept\n" +
                "\tADD CONSTRAINT mgr_cons FOREIGN KEY (mgr_ref) REFERENCES emp;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "ALTER TABLE dept ADD sr_mgr REF emp_t REFERENCES emp; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE dept ADD sr_mgr REF emp_t REFERENCES emp; ", formatSQL);
    }

    @Test
    public void test_2_0() {
        String s = "ALTER TABLE \"SMARTECAP_NUMONE_XJ\".\"TB_MISSIONMANAGER\" ADD PRIMARY KEY (\"PK_MM\") ENABLE;";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE \"SMARTECAP_NUMONE_XJ\".\"TB_MISSIONMANAGER\"\n" +
                "\tADD PRIMARY KEY (\"PK_MM\") ENABLE;", formatSQL);
    }

    @Test
    public void test_2_1() {
        String s = "ALTER TABLE xwarehouses \n" +
                "   ADD (PRIMARY KEY(XMLDATA.\"WarehouseID\")); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE xwarehouses\n" +
                "\tADD (PRIMARY KEY (XMLDATA.\"WarehouseID\"));", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "ALTER TABLE client_tab ADD UNIQUE (pet_id); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE client_tab\n" +
                "\tADD UNIQUE (pet_id);", formatSQL);
    }

    @Test
    public void test_4() {
        String s = "ALTER TABLE deptemps ADD (SCOPE FOR (COLUMN_VALUE) IS emptab);  ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE deptemps\n" +
                "\tADD (SCOPE FOR(COLUMN_VALUE) IS emptab);", formatSQL);
    }

    @Test
    public void test_5() {
        String s = "ALTER TABLE deptemps ADD (REF(column_value) WITH ROWID); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE deptemps\n" +
                "\tADD (REF(COLUMN_VALUE) WITH ROWID);", formatSQL);
    }
}
