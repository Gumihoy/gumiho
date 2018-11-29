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
public class OracleCreateTableTest_10_Multilevel_Collection {

    @Test
    public void test() {
        String s = "CREATE TABLE business_contacts (\n" +
                "   company_name VARCHAR2(25),\n" +
                "   company_reps customer_list)\n" +
                "   NESTED TABLE company_reps STORE AS outer_ntab\n" +
                "   (NESTED TABLE phones STORE AS inner_ntab); ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE business_contacts (\n" +
                "\tcompany_name VARCHAR2(25),\n" +
                "\tcompany_reps customer_list\n" +
                ")\n" +
                "NESTED TABLE company_reps\n" +
                "STORE AS outer_ntab (\n" +
                "\tNESTED TABLE phones\n" +
                "\tSTORE AS inner_ntab\n" +
                ");", formatSQL);
    }
}
