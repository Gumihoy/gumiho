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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class Oracle2PPASCreateTableTest_1_Partition {

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
                " PARTITION \"WM_INV_LOT_P16\" ) ;\n";

        String format = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE YAJWMS.WM_INV_LOT (\n" +
                "\tJOB_ID NUMBER NOT NULL,\n" +
                "\tPROJECT_ID VARCHAR2(32),\n" +
                "\tLOT_NUM VARCHAR2(32) NOT NULL,\n" +
                "\tOWNER_CODE VARCHAR2(32) NOT NULL,\n" +
                "\tSKU_CODE VARCHAR2(32) NOT NULL,\n" +
                "\tQTY NUMBER(18, 8) DEFAULT 0 NOT NULL,\n" +
                "\tQTY_HOLD NUMBER(18, 8) DEFAULT 0 NOT NULL,\n" +
                "\tQTY_PREALLOC NUMBER(18, 8) DEFAULT 0 NOT NULL,\n" +
                "\tQTY_ALLOC NUMBER(18, 8) DEFAULT 0 NOT NULL,\n" +
                "\tQTY_PK NUMBER(18, 8) DEFAULT 0 NOT NULL,\n" +
                "\tREC_VER NUMBER(12, 0) NOT NULL,\n" +
                "\tCREATOR VARCHAR2(64) NOT NULL,\n" +
                "\tCREATE_TIME DATE NOT NULL,\n" +
                "\tMODIFIER VARCHAR2(64) NOT NULL,\n" +
                "\tMODIFY_TIME DATE NOT NULL,\n" +
                "\tREC_STATUS NUMBER(1, 0) DEFAULT 0 NOT NULL,\n" +
                "\tTIME_ZONE VARCHAR2(20) NOT NULL,\n" +
                "\tORG_ID VARCHAR2(32),\n" +
                "\tWH_CODE VARCHAR2(32) NOT NULL,\n" +
                "\tSITE_CODE VARCHAR2(32) NOT NULL,\n" +
                "\tCOMPANY_CODE VARCHAR2(32) NOT NULL\n" +
                ")\n" +
                "PARTITION BY HASH (LOT_NUM) (\n" +
                "\tPARTITION WM_INV_LOT_P01,\n" +
                "\tPARTITION WM_INV_LOT_P02,\n" +
                "\tPARTITION WM_INV_LOT_P03,\n" +
                "\tPARTITION WM_INV_LOT_P04,\n" +
                "\tPARTITION WM_INV_LOT_P05,\n" +
                "\tPARTITION WM_INV_LOT_P06,\n" +
                "\tPARTITION WM_INV_LOT_P07,\n" +
                "\tPARTITION WM_INV_LOT_P08,\n" +
                "\tPARTITION WM_INV_LOT_P09,\n" +
                "\tPARTITION WM_INV_LOT_P10,\n" +
                "\tPARTITION WM_INV_LOT_P11,\n" +
                "\tPARTITION WM_INV_LOT_P12,\n" +
                "\tPARTITION WM_INV_LOT_P13,\n" +
                "\tPARTITION WM_INV_LOT_P14,\n" +
                "\tPARTITION WM_INV_LOT_P15,\n" +
                "\tPARTITION WM_INV_LOT_P16\n" +
                ");", result.targetSql);
    }


}
