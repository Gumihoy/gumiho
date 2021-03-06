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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.database.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterDatabaseTest_14_Clearing_Log_File {

    @Test
    public void test_0() {
        String sql = "ALTER DATABASE  \n" +
                "    CLEAR LOGFILE 'diskc:log3.log'; ";

        String formatSQL = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(formatSQL);
//        Assert.assertEquals("ALTER DATABASE  \n" +
//                "    CLEAR LOGFILE 'diskc:log3.log';", formatSQL);
    }

}
