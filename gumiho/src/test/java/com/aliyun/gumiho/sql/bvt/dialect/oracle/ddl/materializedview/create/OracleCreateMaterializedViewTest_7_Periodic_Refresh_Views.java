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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.materializedview.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateMaterializedViewTest_7_Periodic_Refresh_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW emp_data \n" +
                "   PCTFREE 5 PCTUSED 60 \n" +
                "   TABLESPACE example \n" +
                "   STORAGE (INITIAL 50K)\n" +
                "   REFRESH FAST NEXT sysdate + 7 \n" +
                "   AS SELECT * FROM employees;  ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW emp_data\n" +
                "PCTFREE 5\n" +
                "PCTUSED 60\n" +
                "TABLESPACE example\n" +
                "STORAGE (\n" +
                "\tINITIAL 50K\n" +
                ")\n" +
                "REFRESH FAST NEXT sysdate + 7\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM employees;", formatSQL);
    }
}
