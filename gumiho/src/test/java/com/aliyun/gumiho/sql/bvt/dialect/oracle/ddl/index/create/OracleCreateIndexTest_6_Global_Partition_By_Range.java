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
public class OracleCreateIndexTest_6_Global_Partition_By_Range {

    @Test
    public void test1() {
        String s = "CREATE INDEX cost_ix ON sales (amount_sold)\n" +
                "   GLOBAL PARTITION BY RANGE (amount_sold)\n" +
                "      (PARTITION p1 VALUES LESS THAN (1000),\n" +
                "       PARTITION p2 VALUES LESS THAN (2500),\n" +
                "       PARTITION p3 VALUES LESS THAN (MAXVALUE)); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX cost_ix ON sales (\n" +
                "\tamount_sold\n" +
                ")\n" +
                "GLOBAL PARTITION BY RANGE (\n" +
                "\tamount_sold\n" +
                ") (\n" +
                "\tPARTITION p1 VALUES LESS THAN (1000),\n" +
                "\tPARTITION p2 VALUES LESS THAN (2500),\n" +
                "\tPARTITION p3 VALUES LESS THAN (MAXVALUE)\n" +
                ");", formatSQL);
    }


}
