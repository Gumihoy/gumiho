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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.insert;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleInsertTest_2_Error_Logging {

    @Test
    public void test1() {
        String sql = "INSERT INTO raises\n" +
                "   SELECT employee_id, salary*1.1 FROM employees\n" +
                "   WHERE commission_pct > .2\n" +
                "   LOG ERRORS INTO errlog ('my_bad') REJECT LIMIT 10;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO raises\n" +
                "SELECT employee_id, salary * 1.1\n" +
                "FROM employees\n" +
                "WHERE commission_pct > .2\n" +
                "LOG ERRORS INTO errlog ('my_bad') REJECT LIMIT 10;", format);
    }


}
