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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.materializedview.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateMaterializedViewTest_8_Automatic_Refresh_Times_Views {

    @Test
    public void test() {
        String s = "CREATE MATERIALIZED VIEW all_customers\n" +
                "   PCTFREE 5 PCTUSED 60 \n" +
                "   TABLESPACE example \n" +
                "   STORAGE (INITIAL 50K) \n" +
                "   USING INDEX STORAGE (INITIAL 25K)\n" +
                "   REFRESH START WITH ROUND(SYSDATE + 1) + 11/24 \n" +
                "   NEXT NEXT_DAY(TRUNC(SYSDATE), 'MONDAY') + 15/24 \n" +
                "   AS SELECT * FROM sh.customers@remote \n" +
                "         UNION\n" +
                "      SELECT * FROM sh.customers@local;  ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);

        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE MATERIALIZED VIEW all_customers\n" +
                "PCTFREE 5\n" +
                "PCTUSED 60\n" +
                "TABLESPACE example\n" +
                "STORAGE (\n" +
                "\tINITIAL 50K\n" +
                ")\n" +
                "USING INDEX\n" +
                "\tSTORAGE (\n" +
                "\t\tINITIAL 25K\n" +
                "\t)\n" +
                "REFRESH START WITH ROUND(SYSDATE + 1) + 11 / 24 \n" +
                "\tNEXT NEXT_DAY(TRUNC(SYSDATE), 'MONDAY') + 15 / 24\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM sh.customers@remote\n" +
                "\tUNION\n" +
                "\tSELECT *\n" +
                "\tFROM sh.customers@local;", formatSQL);
    }
}
