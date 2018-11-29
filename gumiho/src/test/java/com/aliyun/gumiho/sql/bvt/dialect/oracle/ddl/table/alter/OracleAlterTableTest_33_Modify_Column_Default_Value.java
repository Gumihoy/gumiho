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
public class OracleAlterTableTest_33_Modify_Column_Default_Value {

    @Test
    public void test_1() {
        String s = "ALTER TABLE product_information\n" +
                "  MODIFY (min_price DEFAULT 10); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE product_information\n" +
                "\tMODIFY (min_price DEFAULT 10);", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "ALTER TABLE product_information\n" +
                "   MODIFY (min_price DEFAULT NULL); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE product_information\n" +
                "\tMODIFY (min_price DEFAULT NULL);", formatSQL);
    }


    @Test
    public void test_3() {
        String s = "ALTER TABLE t1 ADD (id NUMBER DEFAULT ON NULL s1.NEXTVAL NOT NULL); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("ALTER TABLE t1\n" +
                "\tADD (id NUMBER DEFAULT ON NULL s1.NEXTVAL NOT NULL);", formatSQL);
    }
}
