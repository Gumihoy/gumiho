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
public class OracleAlterTableTest_36_LOB_Columns {

    @Test
    public void test_1() {
        String s = "ALTER TABLE employees ADD (resume CLOB)\n" +
                "  LOB (resume) STORE AS resume_seg (TABLESPACE example); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tADD (resume CLOB)\n" +
                "\tLOB (resume) STORE AS resume_seg (\n" +
                "\t\tTABLESPACE example\n" +
                "\t);", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "ALTER TABLE employees MODIFY LOB (resume) (CACHE);  ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tMODIFY LOB (resume) (\n" +
                "\t\tCACHE\n" +
                "\t);", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "ALTER TABLE employees ADD (resume CLOB)\n" +
                "LOB (resume) STORE AS SECUREFILE resume_seg (TABLESPACE auto_seg_ts); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tADD (resume CLOB)\n" +
                "\tLOB (resume) STORE AS SECUREFILE resume_seg (\n" +
                "\t\tTABLESPACE auto_seg_ts\n" +
                "\t);", formatSQL);
    }

    @Test
    public void test_4() {
        String s = "ALTER TABLE employees MODIFY LOB (resume) (NOCACHE); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE employees\n" +
                "\tMODIFY LOB (resume) (\n" +
                "\t\tNOCACHE\n" +
                "\t);", formatSQL);
    }
}
