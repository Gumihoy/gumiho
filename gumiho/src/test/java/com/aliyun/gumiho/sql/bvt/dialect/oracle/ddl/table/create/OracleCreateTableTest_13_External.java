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
public class OracleCreateTableTest_13_External {

    @Test
    public void test() {
        String s = "CREATE TABLE dept_external (\n" +
                "   deptno     NUMBER(6),\n" +
                "   dname      VARCHAR2(20),\n" +
                "   loc        VARCHAR2(25) \n" +
                ")\n" +
                "ORGANIZATION EXTERNAL\n" +
                "(TYPE oracle_loader\n" +
                " DEFAULT DIRECTORY admin\n" +
                " ACCESS PARAMETERS\n" +
                " (\n" +
                "  'RECORDS DELIMITED BY newline\n" +
                "  BADFILE 'ulcase1.bad'\n" +
                "  DISCARDFILE 'ulcase1.dis'\n" +
                "  LOGFILE 'ulcase1.log'\n" +
                "  SKIP 20\n" +
                "  FIELDS TERMINATED BY \",\"  OPTIONALLY ENCLOSED BY '\"'\n" +
                "  (\n" +
                "   deptno     INTEGER EXTERNAL(6),\n" +
                "   dname      CHAR(20),\n" +
                "   loc        CHAR(25)\n" +
                "  )'\n" +
                " )\n" +
                " LOCATION ('ulcase1.ctl')\n" +
                ")\n" +
                "REJECT LIMIT UNLIMITED; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals(s, formatSQL);
    }
}
