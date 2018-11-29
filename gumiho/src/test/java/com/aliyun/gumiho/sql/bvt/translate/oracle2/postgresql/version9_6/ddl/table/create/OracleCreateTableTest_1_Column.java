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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class OracleCreateTableTest_1_Column {

    @Test
    public void test1() {
        String s = "CREATE TABLE \"KJHS\".\"GLEDGER\" \n" +
                "   (\t\"SETID\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"YEAR\" NUMBER(4,0) NOT NULL ENABLE, \n" +
                "\t\"MONTH\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"VOUCHERNO\" NUMBER(10,0) NOT NULL ENABLE, \n" +
                "\t\"ID\" NUMBER(6,0) NOT NULL ENABLE, \n" +
                "\t\"VOUENTERGUID\" NUMBER(6,0), \n" +
                "\t\"NUMBER_C\" NUMBER(10,0), \n" +
                "\t\"DAY\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"SUMMARY\" VARCHAR2(200), \n" +
                "\t\"SOURCEGUID\" VARCHAR2(6), \n" +
                "\t\"ENTERGUID\" NUMBER(6,0), \n" +
                "\t\"DEBMONEY\" NUMBER(16,2) DEFAULT 0.00, \n" +
                "\t\"CREMONEY\" NUMBER(16,2) DEFAULT 0.00, \n" +
                "\t\"ENTERINCODE\" VARCHAR2(60), \n" +
                "\t\"ENTERPRISEINCODE\" VARCHAR2(60)\n" +
                "   ) \n" +
                "  PARTITION BY RANGE (\"YEAR\") \n" +
                "  SUBPARTITION BY LIST (\"MONTH\") \n" +
                " (PARTITION \"GLEDGER_PART_1\"  VALUES LESS THAN (2006) \n" +
                " ( SUBPARTITION \"PART_1_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_1_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_1_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_1_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_1_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_1_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_1_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_1_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_1_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_1_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_1_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_1_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_1_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_2\"  VALUES LESS THAN (2007) \n" +
                " ( SUBPARTITION \"PART_2_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_2_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_2_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_2_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_2_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_2_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_2_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_2_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_2_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_2_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_2_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_2_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_2_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_3\"  VALUES LESS THAN (2008) \n" +
                " ( SUBPARTITION \"PART_3_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_3_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_3_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_3_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_3_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_3_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_3_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_3_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_3_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_3_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_3_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_3_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_3_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_4\"  VALUES LESS THAN (2009) \n" +
                " ( SUBPARTITION \"PART_4_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_4_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_4_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_4_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_4_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_4_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_4_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_4_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_4_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_4_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_4_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_4_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_4_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_5\"  VALUES LESS THAN (2010) \n" +
                " ( SUBPARTITION \"PART_5_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_5_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_5_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_5_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_5_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_5_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_5_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_5_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_5_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_5_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_5_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_5_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_5_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_6\"  VALUES LESS THAN (2011) \n" +
                " ( SUBPARTITION \"PART_6_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_6_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_6_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_6_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_6_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_6_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_6_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_6_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_6_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_6_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_6_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_6_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_6_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_7\"  VALUES LESS THAN (2012) \n" +
                " ( SUBPARTITION \"PART_7_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_7_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_7_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_7_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_7_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_7_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_7_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_7_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_7_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_7_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_7_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_7_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_7_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_8\"  VALUES LESS THAN (2013) \n" +
                " ( SUBPARTITION \"PART_8_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_8_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_8_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_8_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_8_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_8_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_8_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_8_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_8_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_8_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_8_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_8_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_8_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_9\"  VALUES LESS THAN (2014) \n" +
                " ( SUBPARTITION \"PART_9_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_9_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_9_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_9_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_9_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_9_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_9_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_9_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_9_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_9_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_9_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_9_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_9_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_10\"  VALUES LESS THAN (2015) \n" +
                " ( SUBPARTITION \"PART_10_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_10_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_10_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_10_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_10_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_10_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_10_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_10_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_10_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_10_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_10_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_10_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_10_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_MAX\"  VALUES LESS THAN (MAXVALUE) \n" +
                " ( SUBPARTITION \"PART_M_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_M_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_M_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_M_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_M_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_M_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_M_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_M_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_M_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_M_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_M_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_M_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_M_SUB_13\"  VALUES (13) ) ) ;\n" +
                "  ALTER TABLE \"KJHS\".\"GLEDGER\" ADD CONSTRAINT \"GLEDGER_PK\" PRIMARY KEY (\"SETID\", \"YEAR\", \"MONTH\", \"VOUCHERNO\", \"ID\") ENABLE;\n" +
                "  ALTER TABLE \"KJHS\".\"GLEDGER\" ADD SUPPLEMENTAL LOG GROUP \"GGS_126134\" (\"SETID\", \"YEAR\", \"MONTH\", \"VOUCHERNO\", \"ID\") ALWAYS;";

        String format = SQLUtils.format(s, DBType.Oracle);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE \"KJHS\".\"GLEDGER\" \n" +
                "   (\t\"SETID\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"YEAR\" NUMBER(4,0) NOT NULL ENABLE, \n" +
                "\t\"MONTH\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"VOUCHERNO\" NUMBER(10,0) NOT NULL ENABLE, \n" +
                "\t\"ID\" NUMBER(6,0) NOT NULL ENABLE, \n" +
                "\t\"VOUENTERGUID\" NUMBER(6,0), \n" +
                "\t\"NUMBER_C\" NUMBER(10,0), \n" +
                "\t\"DAY\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"SUMMARY\" VARCHAR2(200), \n" +
                "\t\"SOURCEGUID\" VARCHAR2(6), \n" +
                "\t\"ENTERGUID\" NUMBER(6,0), \n" +
                "\t\"DEBMONEY\" NUMBER(16,2) DEFAULT 0.00, \n" +
                "\t\"CREMONEY\" NUMBER(16,2) DEFAULT 0.00, \n" +
                "\t\"ENTERINCODE\" VARCHAR2(60), \n" +
                "\t\"ENTERPRISEINCODE\" VARCHAR2(60)\n" +
                "   ) \n" +
                "  PARTITION BY RANGE (\"YEAR\") \n" +
                "  SUBPARTITION BY LIST (\"MONTH\") \n" +
                " (PARTITION \"GLEDGER_PART_1\"  VALUES LESS THAN (2006) \n" +
                " ( SUBPARTITION \"PART_1_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_1_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_1_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_1_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_1_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_1_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_1_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_1_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_1_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_1_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_1_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_1_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_1_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_2\"  VALUES LESS THAN (2007) \n" +
                " ( SUBPARTITION \"PART_2_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_2_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_2_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_2_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_2_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_2_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_2_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_2_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_2_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_2_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_2_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_2_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_2_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_3\"  VALUES LESS THAN (2008) \n" +
                " ( SUBPARTITION \"PART_3_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_3_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_3_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_3_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_3_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_3_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_3_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_3_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_3_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_3_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_3_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_3_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_3_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_4\"  VALUES LESS THAN (2009) \n" +
                " ( SUBPARTITION \"PART_4_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_4_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_4_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_4_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_4_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_4_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_4_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_4_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_4_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_4_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_4_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_4_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_4_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_5\"  VALUES LESS THAN (2010) \n" +
                " ( SUBPARTITION \"PART_5_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_5_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_5_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_5_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_5_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_5_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_5_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_5_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_5_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_5_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_5_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_5_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_5_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_6\"  VALUES LESS THAN (2011) \n" +
                " ( SUBPARTITION \"PART_6_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_6_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_6_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_6_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_6_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_6_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_6_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_6_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_6_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_6_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_6_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_6_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_6_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_7\"  VALUES LESS THAN (2012) \n" +
                " ( SUBPARTITION \"PART_7_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_7_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_7_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_7_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_7_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_7_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_7_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_7_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_7_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_7_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_7_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_7_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_7_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_8\"  VALUES LESS THAN (2013) \n" +
                " ( SUBPARTITION \"PART_8_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_8_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_8_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_8_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_8_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_8_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_8_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_8_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_8_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_8_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_8_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_8_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_8_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_9\"  VALUES LESS THAN (2014) \n" +
                " ( SUBPARTITION \"PART_9_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_9_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_9_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_9_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_9_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_9_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_9_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_9_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_9_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_9_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_9_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_9_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_9_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_10\"  VALUES LESS THAN (2015) \n" +
                " ( SUBPARTITION \"PART_10_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_10_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_10_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_10_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_10_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_10_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_10_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_10_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_10_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_10_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_10_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_10_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_10_SUB_13\"  VALUES (13) ) , \n" +
                " PARTITION \"GLEDGER_PART_MAX\"  VALUES LESS THAN (MAXVALUE) \n" +
                " ( SUBPARTITION \"PART_M_SUB_1\"  VALUES (1) , \n" +
                "  SUBPARTITION \"PART_M_SUB_2\"  VALUES (2) , \n" +
                "  SUBPARTITION \"PART_M_SUB_3\"  VALUES (3) , \n" +
                "  SUBPARTITION \"PART_M_SUB_4\"  VALUES (4) , \n" +
                "  SUBPARTITION \"PART_M_SUB_5\"  VALUES (5) , \n" +
                "  SUBPARTITION \"PART_M_SUB_6\"  VALUES (6) , \n" +
                "  SUBPARTITION \"PART_M_SUB_7\"  VALUES (7) , \n" +
                "  SUBPARTITION \"PART_M_SUB_8\"  VALUES (8) , \n" +
                "  SUBPARTITION \"PART_M_SUB_9\"  VALUES (9) , \n" +
                "  SUBPARTITION \"PART_M_SUB_10\"  VALUES (10) , \n" +
                "  SUBPARTITION \"PART_M_SUB_11\"  VALUES (11) , \n" +
                "  SUBPARTITION \"PART_M_SUB_12\"  VALUES (12) , \n" +
                "  SUBPARTITION \"PART_M_SUB_13\"  VALUES (13) ) ) ;\n" +
                "  ALTER TABLE \"KJHS\".\"GLEDGER\" ADD CONSTRAINT \"GLEDGER_PK\" PRIMARY KEY (\"SETID\", \"YEAR\", \"MONTH\", \"VOUCHERNO\", \"ID\") ENABLE;\n" +
                "  ALTER TABLE \"KJHS\".\"GLEDGER\" ADD SUPPLEMENTAL LOG GROUP \"GGS_126134\" (\"SETID\", \"YEAR\", \"MONTH\", \"VOUCHERNO\", \"ID\") ALWAYS;", result.targetSql);
    }


}
