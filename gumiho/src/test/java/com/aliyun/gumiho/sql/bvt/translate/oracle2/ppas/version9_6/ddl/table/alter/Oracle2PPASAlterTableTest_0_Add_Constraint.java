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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.table.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class Oracle2PPASAlterTableTest_0_Add_Constraint {

    @Test
    public void test_0() {
        String s = "ALTER TABLE \"YAJWMS\".\"WM_INV_LOT\" ADD CONSTRAINT \"PK_WM_INV_LOT\" PRIMARY KEY (\"JOB_ID\")\n" +
                "  USING INDEX  ENABLE; ";

        String format = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("ALTER TABLE YAJWMS.WM_INV_LOT\n" +
                "\tADD CONSTRAINT PK_WM_INV_LOT PRIMARY KEY (JOB_ID);", result.targetSql);
    }

    @Test
    public void test_1() {
        String s = "ALTER TABLE \"YAJWMS\".\"WM_INV_LOT\" ADD CONSTRAINT \"UNQ_WM_INV_LOT\" UNIQUE (\"LOT_NUM\", \"WH_CODE\")\n" +
                "  USING INDEX  ENABLE;\n";

        String format = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("ALTER TABLE YAJWMS.WM_INV_LOT\n" +
                "\tADD CONSTRAINT UNQ_WM_INV_LOT UNIQUE (LOT_NUM, WH_CODE);", result.targetSql);
    }


}
