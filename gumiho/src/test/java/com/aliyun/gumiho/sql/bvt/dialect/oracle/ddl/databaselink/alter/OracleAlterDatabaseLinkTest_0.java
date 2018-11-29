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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.databaselink.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterDatabaseLinkTest_0 {

    @Test
    public void test_0() {
        String s = "ALTER DATABASE LINK private_link \n" +
                "  CONNECT TO hr IDENTIFIED BY hr_new_password;\n" +
                "\n" +
                "ALTER PUBLIC DATABASE LINK public_link\n" +
                "  CONNECT TO scott IDENTIFIED BY scott_new_password;\n" +
                "\n" +
                "ALTER SHARED PUBLIC DATABASE LINK shared_pub_link\n" +
                "  CONNECT TO scott IDENTIFIED BY scott_new_password\n" +
                "  AUTHENTICATED BY hr IDENTIFIED BY hr_new_password;\n" +
                "\n" +
                "ALTER SHARED DATABASE LINK shared_pub_link\n" +
                "  CONNECT TO scott IDENTIFIED BY scott_new_password;";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER DATABASE LINK private_link\n" +
                "\tCONNECT TO hr IDENTIFIED BY hr_new_password;\n" +
                "ALTER PUBLIC DATABASE LINK public_link\n" +
                "\tCONNECT TO scott IDENTIFIED BY scott_new_password;\n" +
                "ALTER SHARED PUBLIC DATABASE LINK shared_pub_link\n" +
                "\tCONNECT TO scott IDENTIFIED BY scott_new_password\n" +
                "\tAUTHENTICATED BY hr IDENTIFIED BY hr_new_password;\n" +
                "ALTER SHARED DATABASE LINK shared_pub_link\n" +
                "\tCONNECT TO scott IDENTIFIED BY scott_new_password;", formatSQL);
    }
}
