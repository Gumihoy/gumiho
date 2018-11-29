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
package com.aliyun.gumiho.sql.bvt.dialect.oracle;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleTest {

    @Test
    public void test() throws Exception {
        String oracleSql = " CREATE OR REPLACE FUNCTION \"WEB_GLPTNEW\".\"F_SSDZ_GET_SXFLMC\" \n" +
                "/*****\n" +
                "  编制人: caojian\n" +
                "  编制日期: 2016-06-28\n" +
                "  -------------------------------------------------\n" +
                "  名称: F_SSDZ_GET_SXFLMC\n" +
                "  -------------------------------------------------\n" +
                "  功能: 查询事项分类名称（层级）\n" +
                "  -------------------------------------------------\n" +
                "  输入: AS_SXFL(事项分类)\n" +
                "  -------------------------------------------------\n" +
                "  输出: RS_MSG(出错信息)\n" +
                "  -------------------------------------------------\n" +
                "  修改：\n" +
                "  *****/\n" +
                "(AS_SXFL IN VARCHAR2)\n" +
                "  RETURN VARCHAR2 IS\n" +
                "  RS_MSG      VARCHAR2(200);\n" +
                "  LS_PROCNAME VARCHAR2(30) := 'F_SSDZ_GET_SXFLMC';\n" +
                "\n" +
                "  LS_SWJG VARCHAR2(20);\n" +
                "\n" +
                "BEGIN\n" +
                "  RS_MSG := '';\n" +
                "\n" +
                "  IF AS_SXFL IS NULL THEN\n" +
                "    RS_MSG := '输入参数[事项分类]不能为空:' || LS_PROCNAME;\n" +
                "    DBMS_OUTPUT.PUT_LINE(RS_MSG);\n" +
                "    RETURN '';\n" +
                "  END IF;\n" +
                "\n" +
                "  SELECT LISTAGG(SXFLMC,'\\') WITHIN GROUP(ORDER BY LEVEL DESC)\n" +
                "    INTO RS_MSG\n" +
                "    FROM SSDZ_DM_SXFL\n" +
                "   WHERE YXBZ = 'Y'\n" +
                "     AND SJFLDM <> '0'\n" +
                "   START WITH SXFLDM = AS_SXFL\n" +
                "  CONNECT BY PRIOR SJFLDM = SXFLDM;\n" +
                "\n" +
                "  RETURN RS_MSG;\n" +
                "\n" +
                "END F_SSDZ_GET_SXFLMC;\n" +
                "\n" +
                "/\n";


        String format = SQLUtils.format(oracleSql, DBType.Oracle);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);

    }
}
