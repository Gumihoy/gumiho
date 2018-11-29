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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.pluggabledatabase.create;

import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreatePluggableDatabaseTest_0 {

    @Test
    public void test() {
        String s = "CREATE DATABASE sample\n" +
                "   CONTROLFILE REUSE \n" +
                "   LOGFILE\n" +
                "      GROUP 1 ('diskx:log1.log', 'disky:log1.log') SIZE 50K, \n" +
                "      GROUP 2 ('diskx:log2.log', 'disky:log2.log') SIZE 50K \n" +
                "   MAXLOGFILES 5 \n" +
                "   MAXLOGHISTORY 100 \n" +
                "   MAXDATAFILES 10 \n" +
                "   MAXINSTANCES 2 \n" +
                "   ARCHIVELOG \n" +
                "   CHARACTER SET AL32UTF8\n" +
                "   NATIONAL CHARACTER SET AL16UTF16\n" +
                "   DATAFILE  \n" +
                "      'disk1:df1.dbf' AUTOEXTEND ON,\n" +
                "      'disk2:df2.dbf' AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED\n" +
                "   DEFAULT TEMPORARY TABLESPACE temp_ts\n" +
                "   UNDO TABLESPACE undo_ts \n" +
                "   SET TIME_ZONE = '+02:00';";

        System.out.println(s);

//        String formatSQL = SQLUtils.format(s, DBType.ORACLE);
        System.out.println("------------------");

//        System.out.printlnAndPrint(formatSQL);
//        Assert.assertEquals("", formatSQL);
    }
}
