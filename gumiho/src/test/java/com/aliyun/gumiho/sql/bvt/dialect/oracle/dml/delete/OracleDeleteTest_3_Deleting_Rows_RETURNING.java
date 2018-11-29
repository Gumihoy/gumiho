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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.delete;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleDeleteTest_3_Deleting_Rows_RETURNING {

    @Test
    public void test1() {
        String sql = "DELETE FROM employees\n" +
                "   WHERE job_id = 'SA_REP' \n" +
                "   AND hire_date + TO_YMINTERVAL('01-00') < SYSDATE \n" +
                "   RETURNING salary INTO :bnd1;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("DELETE FROM employees\n" +
                "WHERE job_id = 'SA_REP'\n" +
                "\tAND hire_date + TO_YMINTERVAL('01-00') < SYSDATE\n" +
                "RETURNING salary INTO :bnd1;", format);
    }

}
