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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.index.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateIndexTest_7_Global_Partition_By_Hash {

    @Test
    public void test1() {
        String s = "CREATE INDEX cust_last_name_ix ON customers (cust_last_name)\n" +
                "  GLOBAL PARTITION BY HASH (cust_last_name)\n" +
                "  PARTITIONS 4 ;";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX cust_last_name_ix ON customers (\n" +
                "\tcust_last_name\n" +
                ")\n" +
                "GLOBAL PARTITION BY HASH (\n" +
                "\tcust_last_name\n" +
                ")\n" +
                "PARTITIONS 4;", formatSQL);
    }

}
