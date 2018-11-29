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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateTableTest_0 {

    @Test
    public void test_0() {
        String s = "CREATE TABLE employees_demo\n" +
                "    ( employee_id    NUMBER(6)\n" +
                "    , first_name     VARCHAR2(20)\n" +
                "    , last_name      VARCHAR2(25) \n" +
                "         CONSTRAINT emp_last_name_nn_demo NOT NULL\n" +
                "    , email          VARCHAR2(25) \n" +
                "         CONSTRAINT emp_email_nn_demo     NOT NULL\n" +
                "    , phone_number   VARCHAR2(20)\n" +
                "    , hire_date      DATE  DEFAULT SYSDATE \n" +
                "         CONSTRAINT emp_hire_date_nn_demo  NOT NULL\n" +
                "    , job_id         VARCHAR2(10)\n" +
                "       CONSTRAINT     emp_job_nn_demo  NOT NULL\n" +
                "    , salary         NUMBER(8,2)\n" +
                "       CONSTRAINT     emp_salary_nn_demo  NOT NULL\n" +
                "    , commission_pct NUMBER(2,2)\n" +
                "    , manager_id     NUMBER(6)\n" +
                "    , department_id  NUMBER(4)\n" +
                "    , dn             VARCHAR2(300)\n" +
                "    , CONSTRAINT     emp_salary_min_demo\n" +
                "                     CHECK (salary > 0) \n" +
                "    , CONSTRAINT     emp_email_uk_demo\n" +
                "                     UNIQUE (email)\n" +
                "    ) ; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE employees_demo (\n" +
                "\temployee_id NUMBER(6),\n" +
                "\tfirst_name VARCHAR2(20),\n" +
                "\tlast_name VARCHAR2(25) CONSTRAINT emp_last_name_nn_demo NOT NULL,\n" +
                "\temail VARCHAR2(25) CONSTRAINT emp_email_nn_demo NOT NULL,\n" +
                "\tphone_number VARCHAR2(20),\n" +
                "\thire_date DATE DEFAULT SYSDATE CONSTRAINT emp_hire_date_nn_demo NOT NULL,\n" +
                "\tjob_id VARCHAR2(10) CONSTRAINT emp_job_nn_demo NOT NULL,\n" +
                "\tsalary NUMBER(8, 2) CONSTRAINT emp_salary_nn_demo NOT NULL,\n" +
                "\tcommission_pct NUMBER(2, 2),\n" +
                "\tmanager_id NUMBER(6),\n" +
                "\tdepartment_id NUMBER(4),\n" +
                "\tdn VARCHAR2(300),\n" +
                "\tCONSTRAINT emp_salary_min_demo CHECK (salary > 0),\n" +
                "\tCONSTRAINT emp_email_uk_demo UNIQUE (email)\n" +
                ");", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "CREATE TABLE \"ZS70SP5PTM\".\"T_LOB_TEST3\" \n" +
                "   (\t\"FNCLOB\" NCLOB\n" +
                "   ) SEGMENT CREATION IMMEDIATE \n" +
                "  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING\n" +
                "  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645\n" +
                "  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)\n" +
                "  TABLESPACE \"ZS70SP5PTM_STD_DATA\" \n" +
                " LOB (\"FNCLOB\") STORE AS SECUREFILE (\n" +
                "  TABLESPACE \"ZS70SP5PTM_STD_DATA\" ENABLE STORAGE IN ROW CHUNK 8192\n" +
                "  NOCACHE LOGGING  COMPRESS MEDIUM  KEEP_DUPLICATES \n" +
                "  STORAGE(INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645\n" +
                "  PCTINCREASE 0 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE \"ZS70SP5PTM\".\"T_LOB_TEST3\" (\n" +
                "\t\"FNCLOB\" NCLOB\n" +
                ")\n" +
                "SEGMENT CREATION IMMEDIATE\n" +
                "PCTFREE 10\n" +
                "PCTUSED 40\n" +
                "INITRANS 1\n" +
                "MAXTRANS 255\n" +
                "NOCOMPRESS\n" +
                "LOGGING\n" +
                "STORAGE (\n" +
                "\tINITIAL 65536,\n" +
                "\tNEXT 1048576,\n" +
                "\tMINEXTENTS 1,\n" +
                "\tMAXEXTENTS 2147483645,\n" +
                "\tPCTINCREASE 0,\n" +
                "\tFREELISTS 1,\n" +
                "\tFREELIST GROUPS 1,\n" +
                "\tBUFFER_POOL DEFAULT,\n" +
                "\tFLASH_CACHE DEFAULT,\n" +
                "\tCELL_FLASH_CACHE DEFAULT\n" +
                ")\n" +
                "TABLESPACE \"ZS70SP5PTM_STD_DATA\"\n" +
                "LOB (\"FNCLOB\") STORE AS SECUREFILE (\n" +
                "\tTABLESPACE \"ZS70SP5PTM_STD_DATA\"\n" +
                "\tENABLE STORAGE IN ROW\n" +
                "\tCHUNK 8192\n" +
                "\tNOCACHE LOGGING\n" +
                "\tCOMPRESS MEDIUM\n" +
                "\tKEEP_DUPLICATES\n" +
                "\tSTORAGE (\n" +
                "\t\tINITIAL 106496,\n" +
                "\t\tNEXT 1048576,\n" +
                "\t\tMINEXTENTS 1,\n" +
                "\t\tMAXEXTENTS 2147483645,\n" +
                "\t\tPCTINCREASE 0,\n" +
                "\t\tBUFFER_POOL DEFAULT,\n" +
                "\t\tFLASH_CACHE DEFAULT,\n" +
                "\t\tCELL_FLASH_CACHE DEFAULT\n" +
                "\t)\n" +
                ")", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "CREATE TABLE \"SMARTECAP_NUMONE_XJ\".\"TB_MISSIONMANAGER\" \n" +
                "   (\t\"PK_MM\" VARCHAR2(100) NOT NULL ENABLE, \n" +
                "\t\"MM_ADDTIME\" TIMESTAMP (6) DEFAULT NULL, \n" +
                "\t\"MM_ADDUSER\" VARCHAR2(32) DEFAULT NULL, \n" +
                "\t\"MM_FEEDBACKTIME\" TIMESTAMP (6) DEFAULT NULL, \n" +
                "\t\"FK_CM\" VARCHAR2(100) DEFAULT NULL, \n" +
                "\t\"MM_ISLOGICDELETE\" NUMBER(11,0) DEFAULT NULL, \n" +
                "\t\"MM_MODIFIER\" VARCHAR2(32) DEFAULT NULL, \n" +
                "\t\"MM_MODIFYTIME\" TIMESTAMP (6) DEFAULT NULL, \n" +
                "\t\"MM_NETTYPE\" NUMBER(11,0) DEFAULT NULL, \n" +
                "\t\"MM_ORGID\" VARCHAR2(10) DEFAULT NULL, \n" +
                "\t\"MM_STATE\" NUMBER(11,0) DEFAULT NULL, \n" +
                "\t\"MM_TYPE\" NUMBER(11,0) DEFAULT NULL, \n" +
                "\t\"MM_UCID\" VARCHAR2(32) DEFAULT NULL, \n" +
                "\t\"MM_USERORGANIZATIONID\" VARCHAR2(40) DEFAULT NULL, \n" +
                "\t\"MM_RETURNOPINION\" VARCHAR2(1536) DEFAULT NULL, \n" +
                "\t\"MM_NAME\" VARCHAR2(300) DEFAULT NULL, \n" +
                "\t\"MM_UNITNAME\" VARCHAR2(300) DEFAULT NULL, \n" +
                "\t\"MM_ADDUSERNAME\" VARCHAR2(300) DEFAULT NULL, \n" +
                "\t\"MM_USERUNITNAME\" VARCHAR2(300) DEFAULT NULL, \n" +
                "\t\"MM_MODIFIERNAME\" VARCHAR2(300) DEFAULT NULL, \n" +
                "\t\"MM_CHECKEDPERSONNELTYPE\" NUMBER(11,0) NOT NULL ENABLE\n" +
                "   ) \n" +
                "  PARTITION BY LIST (\"MM_CHECKEDPERSONNELTYPE\") \n" +
                "  SUBPARTITION BY RANGE (\"MM_ADDTIME\") \n" +
                "  SUBPARTITION TEMPLATE ( \n" +
                "    SUBPARTITION \"PP_7\" VALUES LESS THAN ( TIMESTAMP' 2017-08-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_8\" VALUES LESS THAN ( TIMESTAMP' 2017-09-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_9\" VALUES LESS THAN ( TIMESTAMP' 2017-10-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_10\" VALUES LESS THAN ( TIMESTAMP' 2017-11-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_11\" VALUES LESS THAN ( TIMESTAMP' 2017-12-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_12\" VALUES LESS THAN ( TIMESTAMP' 2018-01-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_1\" VALUES LESS THAN ( TIMESTAMP' 2018-02-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_2\" VALUES LESS THAN ( TIMESTAMP' 2018-03-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_3\" VALUES LESS THAN ( TIMESTAMP' 2018-04-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_4\" VALUES LESS THAN ( TIMESTAMP' 2018-05-01 00:00:00' ), \n" +
                "    SUBPARTITION \"PP_5\" VALUES LESS THAN ( TIMESTAMP' 2018-06-01 00:00:00' ) ) \n" +
                " (PARTITION \"P_0\"  VALUES (0) \n" +
                " ( SUBPARTITION \"P_0_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_1\"  VALUES (1) \n" +
                " ( SUBPARTITION \"P_1_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_2\"  VALUES (2) \n" +
                " ( SUBPARTITION \"P_2_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_3\"  VALUES (3) \n" +
                " ( SUBPARTITION \"P_3_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_4\"  VALUES (4) \n" +
                " ( SUBPARTITION \"P_4_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_5\"  VALUES (5) \n" +
                " ( SUBPARTITION \"P_5_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_6\"  VALUES (6) \n" +
                " ( SUBPARTITION \"P_6_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_7\"  VALUES (7) \n" +
                " ( SUBPARTITION \"P_7_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_8\"  VALUES (8) \n" +
                " ( SUBPARTITION \"P_8_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_9\"  VALUES (9) \n" +
                " ( SUBPARTITION \"P_9_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_10\"  VALUES (10) \n" +
                " ( SUBPARTITION \"P_10_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_11\"  VALUES (11) \n" +
                " ( SUBPARTITION \"P_11_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_12\"  VALUES (12) \n" +
                " ( SUBPARTITION \"P_12_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_13\"  VALUES (13) \n" +
                " ( SUBPARTITION \"P_13_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_14\"  VALUES (14) \n" +
                " ( SUBPARTITION \"P_14_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_15\"  VALUES (15) \n" +
                " ( SUBPARTITION \"P_15_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_16\"  VALUES (16) \n" +
                " ( SUBPARTITION \"P_16_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_17\"  VALUES (17) \n" +
                " ( SUBPARTITION \"P_17_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_18\"  VALUES (18) \n" +
                " ( SUBPARTITION \"P_18_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_19\"  VALUES (19) \n" +
                " ( SUBPARTITION \"P_19_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_20\"  VALUES (20) \n" +
                " ( SUBPARTITION \"P_20_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_21\"  VALUES (21) \n" +
                " ( SUBPARTITION \"P_21_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_22\"  VALUES (22) \n" +
                " ( SUBPARTITION \"P_22_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_23\"  VALUES (23) \n" +
                " ( SUBPARTITION \"P_23_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_24\"  VALUES (24) \n" +
                " ( SUBPARTITION \"P_24_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_25\"  VALUES (25) \n" +
                " ( SUBPARTITION \"P_25_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_26\"  VALUES (26) \n" +
                " ( SUBPARTITION \"P_26_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_27\"  VALUES (27) \n" +
                " ( SUBPARTITION \"P_27_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_28\"  VALUES (28) \n" +
                " ( SUBPARTITION \"P_28_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_29\"  VALUES (29) \n" +
                " ( SUBPARTITION \"P_29_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_30\"  VALUES (30) \n" +
                " ( SUBPARTITION \"P_30_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_31\"  VALUES (31) \n" +
                " ( SUBPARTITION \"P_31_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_32\"  VALUES (32) \n" +
                " ( SUBPARTITION \"P_32_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_33\"  VALUES (33) \n" +
                " ( SUBPARTITION \"P_33_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_34\"  VALUES (34) \n" +
                " ( SUBPARTITION \"P_34_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_35\"  VALUES (35) \n" +
                " ( SUBPARTITION \"P_35_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_36\"  VALUES (36) \n" +
                " ( SUBPARTITION \"P_36_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_37\"  VALUES (37) \n" +
                " ( SUBPARTITION \"P_37_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_38\"  VALUES (38) \n" +
                " ( SUBPARTITION \"P_38_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) , \n" +
                " PARTITION \"P_39\"  VALUES (39) \n" +
                " ( SUBPARTITION \"P_39_PP_70\"  VALUES LESS THAN (TIMESTAMP' 2018-09-01 00:00:00') ) ) ;\n";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE \"SMARTECAP_NUMONE_XJ\".\"TB_MISSIONMANAGER\" (\n" +
                "\t\"PK_MM\" VARCHAR2(100) NOT NULL ENABLE,\n" +
                "\t\"MM_ADDTIME\" TIMESTAMP(6) DEFAULT NULL,\n" +
                "\t\"MM_ADDUSER\" VARCHAR2(32) DEFAULT NULL,\n" +
                "\t\"MM_FEEDBACKTIME\" TIMESTAMP(6) DEFAULT NULL,\n" +
                "\t\"FK_CM\" VARCHAR2(100) DEFAULT NULL,\n" +
                "\t\"MM_ISLOGICDELETE\" NUMBER(11, 0) DEFAULT NULL,\n" +
                "\t\"MM_MODIFIER\" VARCHAR2(32) DEFAULT NULL,\n" +
                "\t\"MM_MODIFYTIME\" TIMESTAMP(6) DEFAULT NULL,\n" +
                "\t\"MM_NETTYPE\" NUMBER(11, 0) DEFAULT NULL,\n" +
                "\t\"MM_ORGID\" VARCHAR2(10) DEFAULT NULL,\n" +
                "\t\"MM_STATE\" NUMBER(11, 0) DEFAULT NULL,\n" +
                "\t\"MM_TYPE\" NUMBER(11, 0) DEFAULT NULL,\n" +
                "\t\"MM_UCID\" VARCHAR2(32) DEFAULT NULL,\n" +
                "\t\"MM_USERORGANIZATIONID\" VARCHAR2(40) DEFAULT NULL,\n" +
                "\t\"MM_RETURNOPINION\" VARCHAR2(1536) DEFAULT NULL,\n" +
                "\t\"MM_NAME\" VARCHAR2(300) DEFAULT NULL,\n" +
                "\t\"MM_UNITNAME\" VARCHAR2(300) DEFAULT NULL,\n" +
                "\t\"MM_ADDUSERNAME\" VARCHAR2(300) DEFAULT NULL,\n" +
                "\t\"MM_USERUNITNAME\" VARCHAR2(300) DEFAULT NULL,\n" +
                "\t\"MM_MODIFIERNAME\" VARCHAR2(300) DEFAULT NULL,\n" +
                "\t\"MM_CHECKEDPERSONNELTYPE\" NUMBER(11, 0) NOT NULL ENABLE\n" +
                ")\n" +
                "PARTITION BY LIST (\"MM_CHECKEDPERSONNELTYPE\")\n" +
                "SUBPARTITION BY RANGE (\"MM_ADDTIME\")\n" +
                "SUBPARTITION TEMPLATE (\n" +
                "\tSUBPARTITION \"PP_7\" VALUES LESS THAN (TIMESTAMP ' 2017-08-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_8\" VALUES LESS THAN (TIMESTAMP ' 2017-09-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_9\" VALUES LESS THAN (TIMESTAMP ' 2017-10-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_10\" VALUES LESS THAN (TIMESTAMP ' 2017-11-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_11\" VALUES LESS THAN (TIMESTAMP ' 2017-12-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_12\" VALUES LESS THAN (TIMESTAMP ' 2018-01-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_1\" VALUES LESS THAN (TIMESTAMP ' 2018-02-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_2\" VALUES LESS THAN (TIMESTAMP ' 2018-03-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_3\" VALUES LESS THAN (TIMESTAMP ' 2018-04-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_4\" VALUES LESS THAN (TIMESTAMP ' 2018-05-01 00:00:00'),\n" +
                "\tSUBPARTITION \"PP_5\" VALUES LESS THAN (TIMESTAMP ' 2018-06-01 00:00:00')\n" +
                ") (\n" +
                "\tPARTITION \"P_0\" VALUES (0) (\n" +
                "\t\tSUBPARTITION \"P_0_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_1\" VALUES (1) (\n" +
                "\t\tSUBPARTITION \"P_1_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_2\" VALUES (2) (\n" +
                "\t\tSUBPARTITION \"P_2_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_3\" VALUES (3) (\n" +
                "\t\tSUBPARTITION \"P_3_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_4\" VALUES (4) (\n" +
                "\t\tSUBPARTITION \"P_4_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_5\" VALUES (5) (\n" +
                "\t\tSUBPARTITION \"P_5_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_6\" VALUES (6) (\n" +
                "\t\tSUBPARTITION \"P_6_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_7\" VALUES (7) (\n" +
                "\t\tSUBPARTITION \"P_7_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_8\" VALUES (8) (\n" +
                "\t\tSUBPARTITION \"P_8_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_9\" VALUES (9) (\n" +
                "\t\tSUBPARTITION \"P_9_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_10\" VALUES (10) (\n" +
                "\t\tSUBPARTITION \"P_10_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_11\" VALUES (11) (\n" +
                "\t\tSUBPARTITION \"P_11_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_12\" VALUES (12) (\n" +
                "\t\tSUBPARTITION \"P_12_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_13\" VALUES (13) (\n" +
                "\t\tSUBPARTITION \"P_13_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_14\" VALUES (14) (\n" +
                "\t\tSUBPARTITION \"P_14_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_15\" VALUES (15) (\n" +
                "\t\tSUBPARTITION \"P_15_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_16\" VALUES (16) (\n" +
                "\t\tSUBPARTITION \"P_16_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_17\" VALUES (17) (\n" +
                "\t\tSUBPARTITION \"P_17_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_18\" VALUES (18) (\n" +
                "\t\tSUBPARTITION \"P_18_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_19\" VALUES (19) (\n" +
                "\t\tSUBPARTITION \"P_19_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_20\" VALUES (20) (\n" +
                "\t\tSUBPARTITION \"P_20_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_21\" VALUES (21) (\n" +
                "\t\tSUBPARTITION \"P_21_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_22\" VALUES (22) (\n" +
                "\t\tSUBPARTITION \"P_22_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_23\" VALUES (23) (\n" +
                "\t\tSUBPARTITION \"P_23_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_24\" VALUES (24) (\n" +
                "\t\tSUBPARTITION \"P_24_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_25\" VALUES (25) (\n" +
                "\t\tSUBPARTITION \"P_25_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_26\" VALUES (26) (\n" +
                "\t\tSUBPARTITION \"P_26_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_27\" VALUES (27) (\n" +
                "\t\tSUBPARTITION \"P_27_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_28\" VALUES (28) (\n" +
                "\t\tSUBPARTITION \"P_28_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_29\" VALUES (29) (\n" +
                "\t\tSUBPARTITION \"P_29_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_30\" VALUES (30) (\n" +
                "\t\tSUBPARTITION \"P_30_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_31\" VALUES (31) (\n" +
                "\t\tSUBPARTITION \"P_31_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_32\" VALUES (32) (\n" +
                "\t\tSUBPARTITION \"P_32_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_33\" VALUES (33) (\n" +
                "\t\tSUBPARTITION \"P_33_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_34\" VALUES (34) (\n" +
                "\t\tSUBPARTITION \"P_34_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_35\" VALUES (35) (\n" +
                "\t\tSUBPARTITION \"P_35_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_36\" VALUES (36) (\n" +
                "\t\tSUBPARTITION \"P_36_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_37\" VALUES (37) (\n" +
                "\t\tSUBPARTITION \"P_37_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_38\" VALUES (38) (\n" +
                "\t\tSUBPARTITION \"P_38_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t),\n" +
                "\tPARTITION \"P_39\" VALUES (39) (\n" +
                "\t\tSUBPARTITION \"P_39_PP_70\" VALUES LESS THAN (TIMESTAMP ' 2018-09-01 00:00:00')\n" +
                "\t)\n" +
                ");", formatSQL);
    }


    @Test
    public void test_100() {
        String s = "CREATE TABLE \"ZFGL\".\"PLAN\" \n" +
                "   (\t\"PLANID\" NUMBER(38,0) NOT NULL ENABLE, \n" +
                "\t\"YEAR\" NUMBER(4,0) NOT NULL ENABLE, \n" +
                "\t\"MONTH\" NUMBER(2,0) NOT NULL ENABLE, \n" +
                "\t\"INPUTDATE\" DATE NOT NULL ENABLE, \n" +
                "\t\"FILENO\" VARCHAR2(120)\n" +
                "   ) \n" +
                "  PARTITION BY RANGE (\"YEAR\") \n" +
                "  SUBPARTITION BY HASH (\"FILENO\") \n" +
                "  SUBPARTITIONS 16\n" +
                " (PARTITION \"PLAN_PART_1\"  VALUES LESS THAN (2006) \n" +
                " ( SUBPARTITION \"PART_1_SUB_1\" , \n" +
                "  SUBPARTITION \"PART_1_SUB_2\" , \n" +
                "  SUBPARTITION \"PART_1_SUB_3\" , \n" +
                "  SUBPARTITION \"PART_1_SUB_4\" \n" +
                "))\n";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE \"ZFGL\".\"PLAN\" (\n" +
                "\t\"PLANID\" NUMBER(38, 0) NOT NULL ENABLE,\n" +
                "\t\"YEAR\" NUMBER(4, 0) NOT NULL ENABLE,\n" +
                "\t\"MONTH\" NUMBER(2, 0) NOT NULL ENABLE,\n" +
                "\t\"INPUTDATE\" DATE NOT NULL ENABLE,\n" +
                "\t\"FILENO\" VARCHAR2(120)\n" +
                ")\n" +
                "PARTITION BY RANGE (\"YEAR\")\n" +
                "SUBPARTITION BY HASH (\"FILENO\")\n" +
                "SUBPARTITIONS 16 (\n" +
                "\tPARTITION \"PLAN_PART_1\" VALUES LESS THAN (2006) (\n" +
                "\t\tSUBPARTITION \"PART_1_SUB_1\",\n" +
                "\t\tSUBPARTITION \"PART_1_SUB_2\",\n" +
                "\t\tSUBPARTITION \"PART_1_SUB_3\",\n" +
                "\t\tSUBPARTITION \"PART_1_SUB_4\"\n" +
                "\t)\n" +
                ")", formatSQL);
    }

}
