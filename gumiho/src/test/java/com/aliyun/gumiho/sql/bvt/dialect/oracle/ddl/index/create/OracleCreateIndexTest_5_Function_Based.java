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
public class OracleCreateIndexTest_5_Function_Based {

    @Test
    public void test1() {
        String s = "CREATE INDEX upper_ix ON employees (UPPER(last_name)); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX upper_ix ON employees (\n" +
                "\tUPPER(last_name)\n" +
                ");", formatSQL);
    }

    @Test
    public void test2() {
        String s = "CREATE INDEX income_ix \n" +
                "   ON employees(salary + (salary*commission_pct)); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX income_ix ON employees (\n" +
                "\tsalary + (salary * commission_pct)\n" +
                ");", formatSQL);
    }

    @Test
    public void test3() {
        String s = "CREATE INDEX area_idx ON rect_tab x (x.area());  ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE INDEX area_idx ON rect_tab x (\n" +
                "\tx.area()\n" +
                ");", formatSQL);
    }

    @Test
    public void test4() {
        String s = "CREATE UNIQUE INDEX promo_ix ON orders\n" +
                "   (CASE WHEN promotion_id =2 THEN customer_id ELSE NULL END,\n" +
                "    CASE WHEN promotion_id = 2 THEN promotion_id ELSE NULL END); ";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE UNIQUE INDEX promo_ix ON orders (\n" +
                "\tCASE\n" +
                "\t\tWHEN promotion_id = 2 THEN customer_id\n" +
                "\t\tELSE NULL\n" +
                "\tEND,\n" +
                "\tCASE\n" +
                "\t\tWHEN promotion_id = 2 THEN promotion_id\n" +
                "\t\tELSE NULL\n" +
                "\tEND\n" +
                ");", formatSQL);
    }
}
