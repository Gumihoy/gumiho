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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.view.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateViewTest_3_Updatable {

    @Test
    public void test1() {
        String s = "CREATE VIEW clerk AS\n" +
                "   SELECT employee_id, last_name, department_id, job_id \n" +
                "   FROM employees\n" +
                "   WHERE job_id = 'PU_CLERK' \n" +
                "      or job_id = 'SH_CLERK' \n" +
                "      or job_id = 'ST_CLERK'\n" +
                "   WITH CHECK OPTION; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE VIEW clerk\n" +
                "AS\n" +
                "\tSELECT employee_id, last_name, department_id, job_id\n" +
                "\tFROM employees\n" +
                "\tWHERE job_id = 'PU_CLERK' OR job_id = 'SH_CLERK' OR job_id = 'ST_CLERK'\n" +
                "WITH CHECK OPTION;", formatSQL);
    }


}
