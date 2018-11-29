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
public class Oracle2PPASAlterTableTest_1_Create_Table_Partition_Add_Constraint {

    @Test
    public void test_0() {
        String s = "CREATE TABLE \"YAJWMS\".\"WM_INV_LOT\" \n" +
                "   (\t\"JOB_ID\" NUMBER NOT NULL ENABLE, \n" +
                "\t\"PROJECT_ID\" VARCHAR2(32), \n" +
                "\t\"LOT_NUM\" VARCHAR2(32) NOT NULL ENABLE, \n" +
                "\t\"OWNER_CODE\" VARCHAR2(32) NOT NULL ENABLE, \n" +
                "\t\"SKU_CODE\" VARCHAR2(32) NOT NULL ENABLE, \n" +
                "\t\"QTY\" NUMBER(18,8) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"QTY_HOLD\" NUMBER(18,8) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"QTY_PREALLOC\" NUMBER(18,8) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"QTY_ALLOC\" NUMBER(18,8) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"QTY_PK\" NUMBER(18,8) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"REC_VER\" NUMBER(12,0) NOT NULL ENABLE, \n" +
                "\t\"CREATOR\" VARCHAR2(64) NOT NULL ENABLE, \n" +
                "\t\"CREATE_TIME\" DATE NOT NULL ENABLE, \n" +
                "\t\"MODIFIER\" VARCHAR2(64) NOT NULL ENABLE, \n" +
                "\t\"MODIFY_TIME\" DATE NOT NULL ENABLE, \n" +
                "\t\"REC_STATUS\" NUMBER(1,0) DEFAULT 0 NOT NULL ENABLE, \n" +
                "\t\"TIME_ZONE\" VARCHAR2(20) NOT NULL ENABLE, \n" +
                "\t\"ORG_ID\" VARCHAR2(32), \n" +
                "\t\"WH_CODE\" VARCHAR2(32) NOT NULL ENABLE, \n" +
                "\t\"SITE_CODE\" VARCHAR2(32) NOT NULL ENABLE, \n" +
                "\t\"COMPANY_CODE\" VARCHAR2(32) NOT NULL ENABLE\n" +
                "   ) \n" +
                "  PARTITION BY HASH (\"LOT_NUM\") \n" +
                " (PARTITION \"WM_INV_LOT_P01\" , \n" +
                " PARTITION \"WM_INV_LOT_P02\" , \n" +
                " PARTITION \"WM_INV_LOT_P03\" , \n" +
                " PARTITION \"WM_INV_LOT_P04\" , \n" +
                " PARTITION \"WM_INV_LOT_P05\" , \n" +
                " PARTITION \"WM_INV_LOT_P06\" , \n" +
                " PARTITION \"WM_INV_LOT_P07\" , \n" +
                " PARTITION \"WM_INV_LOT_P08\" , \n" +
                " PARTITION \"WM_INV_LOT_P09\" , \n" +
                " PARTITION \"WM_INV_LOT_P10\" , \n" +
                " PARTITION \"WM_INV_LOT_P11\" , \n" +
                " PARTITION \"WM_INV_LOT_P12\" , \n" +
                " PARTITION \"WM_INV_LOT_P13\" , \n" +
                " PARTITION \"WM_INV_LOT_P14\" , \n" +
                " PARTITION \"WM_INV_LOT_P15\" , \n" +
                " PARTITION \"WM_INV_LOT_P16\" ) ;\n" +
                "  ALTER TABLE \"YAJWMS\".\"WM_INV_LOT\" ADD CONSTRAINT \"UNQ_WM_INV_LOT\" UNIQUE (\"LOT_NUM\", \"WH_CODE\")\n" +
                "  USING INDEX  ENABLE;\n" +
                "  ALTER TABLE \"YAJWMS\".\"WM_INV_LOT\" ADD CONSTRAINT \"PK_WM_INV_LOT\" PRIMARY KEY (\"JOB_ID\")\n" +
                "  USING INDEX  ENABLE;\n";

        String format = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }



}
