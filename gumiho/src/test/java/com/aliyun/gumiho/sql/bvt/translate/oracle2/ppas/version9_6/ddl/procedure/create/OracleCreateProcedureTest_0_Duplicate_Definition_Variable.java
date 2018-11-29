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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.procedure.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateProcedureTest_0_Duplicate_Definition_Variable {

    @Test
    public void test() {
        String s = "create or replace PROCEDURE sp_fkctz (\n" +
                "\tv_com_code IN VARCHAR2,\n" +
                "\tv_storeno in varchar2\n" +
                ")\n" +
                "AS\n" +
                "\tCURSOR cur_pici_fkc(\n" +
                "\t\tcv_com_code IN VARCHAR2\n" +
                "\t) IS\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy = '4' AND com_code = cv_com_code and storeno = v_storeno\n" +
                "\t\tORDER BY seqno;\n" +
                "\trow_pici_fkc cur_pici_fkc%ROWTYPE;\n" +
                "\tCURSOR cur_pici_normal(\n" +
                "\t\tcv_com_code IN VARCHAR2\n" +
                "\t) IS\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy <> '4' AND com_code = cv_com_code and storeno = v_storeno;\n" +
                "\trow_pici_normal cur_pici_normal%ROWTYPE;\n" +
                "\tCURSOR cur_com_xs(\n" +
                "\t\tcv_com_code IN VARCHAR2,\n" +
                "\t\tcv_pici_seqno IN NUMBER\n" +
                "\t) IS\n" +
                "\t\tSELECT SUM(lsje) AS lsje, SUM(zzje) AS zzje, SUM(sczk) AS sczk, SUM(sysy) AS sysy, SUM(zkzr) AS zkzr\n" +
                "\t\tFROM jxc_com_day\n" +
                "\t\tWHERE (zy = '5' OR zy = '6') AND com_code = cv_com_code AND ydjbh = TO_CHAR(cv_pici_seqno) and memo2 = v_storeno;\n" +
                "\trow_com_xs cur_com_xs%ROWTYPE;\n" +
                "\tlv_store_total NUMBER;\n" +
                "\tlv_store_total NUMBER;\n" +
                "\tlv_negative_total NUMBER;\n" +
                "\tlv_ljclsl NUMBER;\n" +
                "\tlv_dcllsje NUMBER;\n" +
                "\trow_commod commod%ROWTYPE;\n" +
                "\trow_jxc_com_day jxc_com_day%ROWTYPE;\n" +
                "\trow_com_hz STR_COM_HZ%ROWTYPE;\n" +
                "BEGIN\n" +
                "\tBEGIN\n" +
                "\t\tSELECT nvl(SUM(xssl), 0)\n" +
                "\t\tINTO lv_negative_total\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy = '4' AND com_code = v_com_code and storeno = v_storeno;\n" +
                "\t\tIF lv_negative_total < 1 THEN\n" +
                "\t\t\tRETURN;\n" +
                "\t\tEND IF;\n" +
                "\t\tSELECT nvl(SUM(kcsl1), 0)\n" +
                "\t\tINTO lv_store_total\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy <> '4' AND com_code = v_com_code and storeno = v_storeno;\n" +
                "\t\tIF lv_store_total < 1 THEN\n" +
                "\t\t\tRETURN;\n" +
                "\t\tEND IF;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\tRETURN;\n" +
                "\tEND;\n" +
                "\tBEGIN\n" +
                "\t\tSELECT *\n" +
                "\t\tINTO row_commod\n" +
                "\t\tFROM commod\n" +
                "\t\tWHERE code = v_com_code and storeno = v_storeno;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\traise_application_error(-20001, 'commod表商品编码找不到:' || v_com_code);\n" +
                "\tEND;\n" +
                "\trow_jxc_com_day.rq := fgetdate;\n" +
                "\trow_jxc_com_day.com_code := v_com_code;\n" +
                "\trow_jxc_com_day.jymon := TO_CHAR(row_jxc_com_day.rq, 'YYYYMM');\n" +
                "\trow_jxc_com_day.pp := row_commod.pp;\n" +
                "\trow_jxc_com_day.xl := row_commod.xl;\n" +
                "\tOPEN cur_pici_fkc(\n" +
                "\t\tv_com_code\n" +
                "\t);\n" +
                "\tLOOP\n" +
                "\t\tFETCH cur_pici_fkc INTO row_pici_fkc;\n" +
                "\t\tEXIT WHEN cur_pici_fkc%NOTFOUND OR cur_pici_fkc%NOTFOUND IS NULL OR lv_negative_total = 0 OR lv_store_total = 0;\n" +
                "\t\tOPEN cur_com_xs(\n" +
                "\t\t\tv_com_code,\n" +
                "\t\t\trow_pici_fkc.seqno\n" +
                "\t\t);\n" +
                "\t\tFETCH cur_com_xs INTO row_com_xs;\n" +
                "\t\tCLOSE cur_com_xs;\n" +
                "\t\tlv_ljclsl := 0;\n" +
                "\t\tIF row_com_xs.lsje IS NULL THEN\n" +
                "\t\t\trow_com_xs.lsje := row_pici_fkc.xssjje;\n" +
                "\t\t\trow_com_xs.zzje := 0;\n" +
                "\t\t\trow_com_xs.sczk := 0;\n" +
                "\t\t\trow_com_xs.zkzr := 0;\n" +
                "\t\t\trow_com_xs.sysy := 0;\n" +
                "\t\tEND IF;\n" +
                "\t\tlv_dcllsje := row_com_xs.lsje;\n" +
                "\t\tOPEN cur_pici_normal(\n" +
                "\t\t\tv_com_code\n" +
                "\t\t);\n" +
                "\t\tLOOP\n" +
                "\t\t\tFETCH cur_pici_normal INTO row_pici_normal;\n" +
                "\t\t\tEXIT WHEN cur_pici_normal%NOTFOUND OR cur_pici_normal%NOTFOUND IS NULL OR lv_ljclsl >= row_pici_fkc.xssl OR lv_store_total = 0;\n" +
                "\t\t\trow_jxc_com_day.djbh := row_pici_fkc.yrkdh;\n" +
                "\t\t\trow_jxc_com_day.zy := '5';\n" +
                "\t\t\tIF (row_pici_fkc.xssl - lv_ljclsl) < row_pici_normal.kcsl1 THEN\n" +
                "\t\t\t\trow_jxc_com_day.sl := row_pici_fkc.xssl - lv_ljclsl;\n" +
                "\t\t\t\trow_jxc_com_day.hsje := row_pici_normal.kchsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\trow_jxc_com_day.bhsje := row_pici_normal.kcbhsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\trow_jxc_com_day.lsje := lv_dcllsje;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\trow_jxc_com_day.sl := row_pici_normal.kcsl1;\n" +
                "\t\t\t\trow_jxc_com_day.hsje := row_pici_normal.kchsjjje1;\n" +
                "\t\t\t\trow_jxc_com_day.bhsje := row_pici_normal.kcbhsjjje1;\n" +
                "\t\t\t\trow_jxc_com_day.lsje := row_com_xs.lsje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tlv_ljclsl := lv_ljclsl + row_jxc_com_day.sl;\n" +
                "\t\t\tlv_dcllsje := lv_dcllsje - row_jxc_com_day.lsje;\n" +
                "\t\t\trow_jxc_com_day.lsj := row_com_xs.lsje / row_pici_fkc.xssl;\n" +
                "\t\t\trow_jxc_com_day.hsjj := row_pici_normal.kchsjj;\n" +
                "\t\t\trow_jxc_com_day.bhsjj := row_pici_normal.kcbhsjj;\n" +
                "\t\t\trow_jxc_com_day.zzje := row_com_xs.zzje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.zkzr := row_com_xs.zkzr * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sczk := row_com_xs.sczk * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_pici_normal.kcsl1 := row_pici_normal.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\tIF row_pici_normal.kcsl1 = 0 THEN\n" +
                "\t\t\t\trow_pici_normal.status := 'Y';\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\trow_pici_normal.status := 'N';\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_pici_normal.kchsjjje1 := row_pici_normal.kchsjjje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\trow_pici_normal.kcbhsjjje1 := row_pici_normal.kcbhsjjje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\trow_pici_normal.xssl := row_pici_normal.xssl + row_jxc_com_day.sl;\n" +
                "\t\t\trow_pici_normal.xshsjjje := row_pici_normal.xshsjjje + row_jxc_com_day.hsje;\n" +
                "\t\t\trow_pici_normal.xsbhsjjje := row_pici_normal.xsbhsjjje + row_jxc_com_day.bhsje;\n" +
                "\t\t\trow_pici_normal.xssjje := row_pici_normal.xssjje + row_jxc_com_day.lsje - row_jxc_com_day.sczk - row_jxc_com_day.zkzr;\n" +
                "\t\t\tIF (row_com_hz.com_code <> v_com_code) OR (row_com_hz.gys <> row_pici_normal.gys) OR (row_com_hz.jyfs <> row_pici_normal.jyfs) OR (row_com_hz.com_code IS NULL) THEN\n" +
                "\t\t\t\tBEGIN\n" +
                "\t\t\t\t\tSELECT *\n" +
                "\t\t\t\t\tINTO row_com_hz\n" +
                "\t\t\t\t\tFROM str_com_hz\n" +
                "\t\t\t\t\tWHERE com_code = v_com_code AND jyfs = row_pici_normal.jyfs and storeno = v_storeno AND gys = row_pici_normal.gys;\n" +
                "\t\t\t\t\tEXCEPTION\n" +
                "\t\t\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\t\t\traise_application_error(-20101, '找不到str_com_hz记录com_code:' || v_com_code || ',gys:' || row_pici_normal.gys || ',jyfs:' || row_pici_normal.jyfs);\n" +
                "\t\t\t\tEND;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tIF row_com_hz.htbh IS NULL THEN\n" +
                "\t\t\t\trow_com_hz.htbh := row_commod.memo2;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_com_hz.kcsl1 := row_com_hz.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\tIF row_com_hz.kcsl1 = 0 THEN\n" +
                "\t\t\t\trow_jxc_com_day.kchsje1 := row_com_hz.kchsje1;\n" +
                "\t\t\t\trow_jxc_com_day.kcbhsje1 := row_com_hz.kcbhsje1;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_com_hz.kchsje1 := row_com_hz.kchsje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\trow_com_hz.kcbhsje1 := row_com_hz.kcbhsje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\tprc_cost_db_change(row_jxc_com_day, row_com_hz, row_pici_normal, 0, 1);\n" +
                "\t\t\tlv_store_total := lv_store_total - row_jxc_com_day.sl;\n" +
                "\t\tEND LOOP;\n" +
                "\t\tCLOSE cur_pici_normal;\n" +
                "\t\trow_jxc_com_day.djbh := row_pici_fkc.yrkdh;\n" +
                "\t\trow_jxc_com_day.zy := '6';\n" +
                "\t\trow_jxc_com_day.hsjj := row_pici_fkc.kchsjj;\n" +
                "\t\trow_jxc_com_day.bhsjj := row_pici_fkc.kcbhsjj;\n" +
                "\t\tIF row_pici_fkc.xssl = lv_ljclsl THEN\n" +
                "\t\t\trow_jxc_com_day.sl := row_pici_fkc.kcsl1;\n" +
                "\t\t\trow_jxc_com_day.hsje := row_pici_fkc.kchsjjje1;\n" +
                "\t\t\trow_jxc_com_day.bhsje := row_pici_fkc.kcbhsjjje1;\n" +
                "\t\t\trow_jxc_com_day.lsje := -1 * row_com_xs.lsje;\n" +
                "\t\t\trow_jxc_com_day.zzje := -1 * row_com_xs.zzje;\n" +
                "\t\t\trow_jxc_com_day.zkzr := -1 * row_com_xs.zkzr;\n" +
                "\t\t\trow_jxc_com_day.sczk := -1 * row_com_xs.sczk;\n" +
                "\t\t\trow_jxc_com_day.sysy := -1 * row_com_xs.sysy;\n" +
                "\t\tELSE\n" +
                "\t\t\trow_jxc_com_day.sl := -1 * lv_ljclsl;\n" +
                "\t\t\trow_jxc_com_day.hsje := row_pici_fkc.kchsjj * row_jxc_com_day.sl;\n" +
                "\t\t\trow_jxc_com_day.bhsje := row_pici_fkc.kcbhsjj * row_jxc_com_day.sl;\n" +
                "\t\t\trow_jxc_com_day.lsje := row_com_xs.lsje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.zzje := row_com_xs.zzje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.zkzr := row_com_xs.zkzr * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sczk := row_com_xs.sczk * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\tEND IF;\n" +
                "\t\trow_jxc_com_day.lsj := row_com_xs.lsje / row_pici_fkc.xssl;\n" +
                "\t\trow_pici_fkc.kcsl1 := row_pici_fkc.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\tIF row_pici_fkc.kcsl1 = 0 THEN\n" +
                "\t\t\trow_pici_fkc.status := 'Y';\n" +
                "\t\tELSE\n" +
                "\t\t\trow_pici_fkc.status := 'N';\n" +
                "\t\tEND IF;\n" +
                "\t\trow_pici_fkc.kchsjjje1 := row_pici_fkc.kchsjjje1 - row_jxc_com_day.hsje;\n" +
                "\t\trow_pici_fkc.kcbhsjjje1 := row_pici_fkc.kcbhsjjje1 - row_jxc_com_day.bhsje;\n" +
                "\t\trow_pici_fkc.xssjje := row_pici_fkc.xssjje * (1 + row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\trow_pici_fkc.xssl := row_pici_fkc.xssl + row_jxc_com_day.sl;\n" +
                "\t\trow_pici_fkc.xshsjjje := row_pici_fkc.xshsjjje + row_jxc_com_day.hsje;\n" +
                "\t\trow_pici_fkc.xsbhsjjje := row_pici_fkc.xsbhsjjje + row_jxc_com_day.bhsje;\n" +
                "\t\tIF (row_com_hz.com_code <> v_com_code) OR (row_com_hz.gys <> row_pici_fkc.gys) OR (row_com_hz.jyfs <> row_pici_fkc.jyfs) OR (row_com_hz.com_code IS NULL) THEN\n" +
                "\t\t\tBEGIN\n" +
                "\t\t\t\tSELECT *\n" +
                "\t\t\t\tINTO row_com_hz\n" +
                "\t\t\t\tFROM str_com_hz\n" +
                "\t\t\t\tWHERE com_code = v_com_code AND jyfs = row_pici_fkc.jyfs AND gys = row_pici_fkc.gys;\n" +
                "\t\t\t\tEXCEPTION\n" +
                "\t\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\t\traise_application_error(-20101, '找不到str_com_hz记录com_code:' || v_com_code || ',gys:' || row_pici_fkc.gys || ',jyfs:' || row_pici_fkc.jyfs);\n" +
                "\t\t\tEND;\n" +
                "\t\tEND IF;\n" +
                "\t\tIF row_com_hz.htbh IS NULL THEN\n" +
                "\t\t\trow_com_hz.htbh := row_commod.memo2;\n" +
                "\t\tEND IF;\n" +
                "\t\trow_com_hz.kcsl1 := row_com_hz.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\tIF row_com_hz.kcsl1 = 0 THEN\n" +
                "\t\t\trow_jxc_com_day.kchsje1 := row_com_hz.kchsje1;\n" +
                "\t\t\trow_jxc_com_day.kcbhsje1 := row_com_hz.kcbhsje1;\n" +
                "\t\tEND IF;\n" +
                "\t\trow_com_hz.kchsje1 := row_com_hz.kchsje1 - row_jxc_com_day.hsje;\n" +
                "\t\trow_com_hz.kcbhsje1 := row_com_hz.kcbhsje1 - row_jxc_com_day.bhsje;\n" +
                "\t\tprc_cost_db_change(row_jxc_com_day, row_com_hz, row_pici_fkc, 0, 1);\n" +
                "\t\tlv_negative_total := lv_negative_total - lv_ljclsl;\n" +
                "\tEND LOOP;\n" +
                "\tCLOSE cur_pici_fkc;\n" +
                "\tEXCEPTION\n" +
                "\t\tWHEN OTHERS THEN\n" +
                "\t\t\tIF cur_pici_fkc%ISOPEN THEN\n" +
                "\t\t\t\tCLOSE cur_pici_fkc;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tIF cur_pici_normal%ISOPEN THEN\n" +
                "\t\t\t\tCLOSE cur_pici_normal;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tIF cur_com_xs%ISOPEN THEN\n" +
                "\t\t\t\tCLOSE cur_com_xs;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tRAISE;\n" +
                "END;";

        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE OR REPLACE PROCEDURE sp_fkctz (\n" +
                "\tv_com_code IN VARCHAR2,\n" +
                "\tv_storeno IN VARCHAR2\n" +
                ")\n" +
                "AS\n" +
                "\tCURSOR cur_pici_fkc (\n" +
                "\t\tcv_com_code IN VARCHAR2\n" +
                "\t) IS\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy = '4' AND com_code = cv_com_code\n" +
                "\t\t\tAND storeno = v_storeno\n" +
                "\t\tORDER BY seqno;\n" +
                "\trow_pici_fkc cur_pici_fkc%ROWTYPE;\n" +
                "\tCURSOR cur_pici_normal (\n" +
                "\t\tcv_com_code IN VARCHAR2\n" +
                "\t) IS\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM str_com_pici\n" +
                "\t\tWHERE status = 'N' AND zy <> '4' AND com_code = cv_com_code\n" +
                "\t\t\tAND storeno = v_storeno;\n" +
                "\trow_pici_normal cur_pici_normal%ROWTYPE;\n" +
                "\tCURSOR cur_com_xs (\n" +
                "\t\tcv_com_code IN VARCHAR2,\n" +
                "\t\tcv_pici_seqno IN NUMBER\n" +
                "\t) IS\n" +
                "\t\tSELECT SUM(lsje) AS lsje, SUM(zzje) AS zzje, SUM(sczk) AS sczk,\n" +
                "\t\t\tSUM(sysy) AS sysy, SUM(zkzr) AS zkzr\n" +
                "\t\tFROM jxc_com_day\n" +
                "\t\tWHERE (zy = '5' OR zy = '6') AND com_code = cv_com_code\n" +
                "\t\t\tAND ydjbh = TO_CHAR(cv_pici_seqno) AND memo2 = v_storeno;\n" +
                "\trow_com_xs cur_com_xs%ROWTYPE;\n" +
                "\tlv_store_total NUMBER;\n" +
                "\tlv_store_total NUMBER;\n" +
                "\tlv_negative_total NUMBER;\n" +
                "\tlv_ljclsl NUMBER;\n" +
                "\tlv_dcllsje NUMBER;\n" +
                "\trow_commod commod%ROWTYPE;\n" +
                "\trow_jxc_com_day jxc_com_day%ROWTYPE;\n" +
                "\trow_com_hz STR_COM_HZ%ROWTYPE;\n" +
                "\tBEGIN\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT nvl(SUM(xssl), 0)\n" +
                "\t\t\tINTO lv_negative_total\n" +
                "\t\t\tFROM str_com_pici\n" +
                "\t\t\tWHERE status = 'N' AND zy = '4' AND com_code = v_com_code AND storeno = v_storeno;\n" +
                "\t\t\tIF lv_negative_total < 1 THEN\n" +
                "\t\t\t\tRETURN;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tSELECT nvl(SUM(kcsl1), 0)\n" +
                "\t\t\tINTO lv_store_total\n" +
                "\t\t\tFROM str_com_pici\n" +
                "\t\t\tWHERE status = 'N' AND zy <> '4' AND com_code = v_com_code\n" +
                "\t\t\t\tAND storeno = v_storeno;\n" +
                "\t\t\tIF lv_store_total < 1 THEN\n" +
                "\t\t\t\tRETURN;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tEXCEPTION\n" +
                "\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\tRETURN;\n" +
                "\t\tEND;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tSELECT *\n" +
                "\t\t\tINTO row_commod\n" +
                "\t\t\tFROM commod\n" +
                "\t\t\tWHERE code = v_com_code AND storeno = v_storeno;\n" +
                "\t\t\tEXCEPTION\n" +
                "\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\traise_application_error(-20001, 'commod表商品编码找不到:' || v_com_code);\n" +
                "\t\tEND;\n" +
                "\t\trow_jxc_com_day.rq := fgetdate;\n" +
                "\t\trow_jxc_com_day.com_code := v_com_code;\n" +
                "\t\trow_jxc_com_day.jymon := TO_CHAR(row_jxc_com_day.rq, 'YYYYMM');\n" +
                "\t\trow_jxc_com_day.pp := row_commod.pp;\n" +
                "\t\trow_jxc_com_day.xl := row_commod.xl;\n" +
                "\t\tOPEN cur_pici_fkc (\n" +
                "\t\t\tv_com_code\n" +
                "\t\t);\n" +
                "\t\tLOOP\n" +
                "\t\t\tFETCH cur_pici_fkc INTO row_pici_fkc;\n" +
                "\t\t\tEXIT WHEN cur_pici_fkc%NOTFOUND OR cur_pici_fkc%NOTFOUND IS NULL OR lv_negative_total = 0 OR lv_store_total = 0;\n" +
                "\t\t\tOPEN cur_com_xs (\n" +
                "\t\t\t\tv_com_code,\n" +
                "\t\t\t\trow_pici_fkc.seqno\n" +
                "\t\t\t);\n" +
                "\t\t\tFETCH cur_com_xs INTO row_com_xs;\n" +
                "\t\t\tCLOSE cur_com_xs;\n" +
                "\t\t\tlv_ljclsl := 0;\n" +
                "\t\t\tIF row_com_xs.lsje IS NULL THEN\n" +
                "\t\t\t\trow_com_xs.lsje := row_pici_fkc.xssjje;\n" +
                "\t\t\t\trow_com_xs.zzje := 0;\n" +
                "\t\t\t\trow_com_xs.sczk := 0;\n" +
                "\t\t\t\trow_com_xs.zkzr := 0;\n" +
                "\t\t\t\trow_com_xs.sysy := 0;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tlv_dcllsje := row_com_xs.lsje;\n" +
                "\t\t\tOPEN cur_pici_normal (\n" +
                "\t\t\t\tv_com_code\n" +
                "\t\t\t);\n" +
                "\t\t\tLOOP\n" +
                "\t\t\t\tFETCH cur_pici_normal INTO row_pici_normal;\n" +
                "\t\t\t\tEXIT WHEN cur_pici_normal%NOTFOUND OR cur_pici_normal%NOTFOUND IS NULL OR lv_ljclsl >= row_pici_fkc.xssl OR lv_store_total = 0;\n" +
                "\t\t\t\trow_jxc_com_day.djbh := row_pici_fkc.yrkdh;\n" +
                "\t\t\t\trow_jxc_com_day.zy := '5';\n" +
                "\t\t\t\tIF (row_pici_fkc.xssl - lv_ljclsl) < row_pici_normal.kcsl1 THEN\n" +
                "\t\t\t\t\trow_jxc_com_day.sl := row_pici_fkc.xssl - lv_ljclsl;\n" +
                "\t\t\t\t\trow_jxc_com_day.hsje := row_pici_normal.kchsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\t\trow_jxc_com_day.bhsje := row_pici_normal.kcbhsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\t\trow_jxc_com_day.lsje := lv_dcllsje;\n" +
                "\t\t\t\tELSE\n" +
                "\t\t\t\t\trow_jxc_com_day.sl := row_pici_normal.kcsl1;\n" +
                "\t\t\t\t\trow_jxc_com_day.hsje := row_pici_normal.kchsjjje1;\n" +
                "\t\t\t\t\trow_jxc_com_day.bhsje := row_pici_normal.kcbhsjjje1;\n" +
                "\t\t\t\t\trow_jxc_com_day.lsje := row_com_xs.lsje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\tlv_ljclsl := lv_ljclsl + row_jxc_com_day.sl;\n" +
                "\t\t\t\tlv_dcllsje := lv_dcllsje - row_jxc_com_day.lsje;\n" +
                "\t\t\t\trow_jxc_com_day.lsj := row_com_xs.lsje / row_pici_fkc.xssl;\n" +
                "\t\t\t\trow_jxc_com_day.hsjj := row_pici_normal.kchsjj;\n" +
                "\t\t\t\trow_jxc_com_day.bhsjj := row_pici_normal.kcbhsjj;\n" +
                "\t\t\t\trow_jxc_com_day.zzje := row_com_xs.zzje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.zkzr := row_com_xs.zkzr * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sczk := row_com_xs.sczk * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_pici_normal.kcsl1 := row_pici_normal.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\t\tIF row_pici_normal.kcsl1 = 0 THEN\n" +
                "\t\t\t\t\trow_pici_normal.status := 'Y';\n" +
                "\t\t\t\tELSE\n" +
                "\t\t\t\t\trow_pici_normal.status := 'N';\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\trow_pici_normal.kchsjjje1 := row_pici_normal.kchsjjje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\t\trow_pici_normal.kcbhsjjje1 := row_pici_normal.kcbhsjjje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\t\trow_pici_normal.xssl := row_pici_normal.xssl + row_jxc_com_day.sl;\n" +
                "\t\t\t\trow_pici_normal.xshsjjje := row_pici_normal.xshsjjje + row_jxc_com_day.hsje;\n" +
                "\t\t\t\trow_pici_normal.xsbhsjjje := row_pici_normal.xsbhsjjje + row_jxc_com_day.bhsje;\n" +
                "\t\t\t\trow_pici_normal.xssjje := row_pici_normal.xssjje + row_jxc_com_day.lsje - row_jxc_com_day.sczk - row_jxc_com_day.zkzr;\n" +
                "\t\t\t\tIF (row_com_hz.com_code <> v_com_code) OR (row_com_hz.gys <> row_pici_normal.gys) OR (row_com_hz.jyfs <> row_pici_normal.jyfs) OR (row_com_hz.com_code IS NULL) THEN\n" +
                "\t\t\t\t\tBEGIN\n" +
                "\t\t\t\t\t\tSELECT *\n" +
                "\t\t\t\t\t\tINTO row_com_hz\n" +
                "\t\t\t\t\t\tFROM str_com_hz\n" +
                "\t\t\t\t\t\tWHERE com_code = v_com_code AND jyfs = row_pici_normal.jyfs\n" +
                "\t\t\t\t\t\t\tAND storeno = v_storeno AND gys = row_pici_normal.gys;\n" +
                "\t\t\t\t\t\tEXCEPTION\n" +
                "\t\t\t\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\t\t\t\traise_application_error(-20101, '找不到str_com_hz记录com_code:' || v_com_code || ',gys:' || row_pici_normal.gys || ',jyfs:' || row_pici_normal.jyfs);\n" +
                "\t\t\t\t\tEND;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\tIF row_com_hz.htbh IS NULL THEN\n" +
                "\t\t\t\t\trow_com_hz.htbh := row_commod.memo2;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\trow_com_hz.kcsl1 := row_com_hz.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\t\tIF row_com_hz.kcsl1 = 0 THEN\n" +
                "\t\t\t\t\trow_jxc_com_day.kchsje1 := row_com_hz.kchsje1;\n" +
                "\t\t\t\t\trow_jxc_com_day.kcbhsje1 := row_com_hz.kcbhsje1;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\trow_com_hz.kchsje1 := row_com_hz.kchsje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\t\trow_com_hz.kcbhsje1 := row_com_hz.kcbhsje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\t\tprc_cost_db_change(row_jxc_com_day, row_com_hz, row_pici_normal, 0, 1);\n" +
                "\t\t\t\tlv_store_total := lv_store_total - row_jxc_com_day.sl;\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tCLOSE cur_pici_normal;\n" +
                "\t\t\trow_jxc_com_day.djbh := row_pici_fkc.yrkdh;\n" +
                "\t\t\trow_jxc_com_day.zy := '6';\n" +
                "\t\t\trow_jxc_com_day.hsjj := row_pici_fkc.kchsjj;\n" +
                "\t\t\trow_jxc_com_day.bhsjj := row_pici_fkc.kcbhsjj;\n" +
                "\t\t\tIF row_pici_fkc.xssl = lv_ljclsl THEN\n" +
                "\t\t\t\trow_jxc_com_day.sl := row_pici_fkc.kcsl1;\n" +
                "\t\t\t\trow_jxc_com_day.hsje := row_pici_fkc.kchsjjje1;\n" +
                "\t\t\t\trow_jxc_com_day.bhsje := row_pici_fkc.kcbhsjjje1;\n" +
                "\t\t\t\trow_jxc_com_day.lsje := -1 * row_com_xs.lsje;\n" +
                "\t\t\t\trow_jxc_com_day.zzje := -1 * row_com_xs.zzje;\n" +
                "\t\t\t\trow_jxc_com_day.zkzr := -1 * row_com_xs.zkzr;\n" +
                "\t\t\t\trow_jxc_com_day.sczk := -1 * row_com_xs.sczk;\n" +
                "\t\t\t\trow_jxc_com_day.sysy := -1 * row_com_xs.sysy;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\trow_jxc_com_day.sl := -1 * lv_ljclsl;\n" +
                "\t\t\t\trow_jxc_com_day.hsje := row_pici_fkc.kchsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\trow_jxc_com_day.bhsje := row_pici_fkc.kcbhsjj * row_jxc_com_day.sl;\n" +
                "\t\t\t\trow_jxc_com_day.lsje := row_com_xs.lsje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.zzje := row_com_xs.zzje * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.zkzr := row_com_xs.zkzr * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sczk := row_com_xs.sczk * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\t\trow_jxc_com_day.sysy := row_com_xs.sysy * (row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_jxc_com_day.lsj := row_com_xs.lsje / row_pici_fkc.xssl;\n" +
                "\t\t\trow_pici_fkc.kcsl1 := row_pici_fkc.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\tIF row_pici_fkc.kcsl1 = 0 THEN\n" +
                "\t\t\t\trow_pici_fkc.status := 'Y';\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\trow_pici_fkc.status := 'N';\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_pici_fkc.kchsjjje1 := row_pici_fkc.kchsjjje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\trow_pici_fkc.kcbhsjjje1 := row_pici_fkc.kcbhsjjje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\trow_pici_fkc.xssjje := row_pici_fkc.xssjje * (1 + row_jxc_com_day.sl / row_pici_fkc.xssl);\n" +
                "\t\t\trow_pici_fkc.xssl := row_pici_fkc.xssl + row_jxc_com_day.sl;\n" +
                "\t\t\trow_pici_fkc.xshsjjje := row_pici_fkc.xshsjjje + row_jxc_com_day.hsje;\n" +
                "\t\t\trow_pici_fkc.xsbhsjjje := row_pici_fkc.xsbhsjjje + row_jxc_com_day.bhsje;\n" +
                "\t\t\tIF (row_com_hz.com_code <> v_com_code) OR (row_com_hz.gys <> row_pici_fkc.gys) OR (row_com_hz.jyfs <> row_pici_fkc.jyfs) OR (row_com_hz.com_code IS NULL) THEN\n" +
                "\t\t\t\tBEGIN\n" +
                "\t\t\t\t\tSELECT *\n" +
                "\t\t\t\t\tINTO row_com_hz\n" +
                "\t\t\t\t\tFROM str_com_hz\n" +
                "\t\t\t\t\tWHERE com_code = v_com_code AND jyfs = row_pici_fkc.jyfs\n" +
                "\t\t\t\t\t\tAND gys = row_pici_fkc.gys;\n" +
                "\t\t\t\t\tEXCEPTION\n" +
                "\t\t\t\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\t\t\t\traise_application_error(-20101, '找不到str_com_hz记录com_code:' || v_com_code || ',gys:' || row_pici_fkc.gys || ',jyfs:' || row_pici_fkc.jyfs);\n" +
                "\t\t\t\tEND;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tIF row_com_hz.htbh IS NULL THEN\n" +
                "\t\t\t\trow_com_hz.htbh := row_commod.memo2;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_com_hz.kcsl1 := row_com_hz.kcsl1 - row_jxc_com_day.sl;\n" +
                "\t\t\tIF row_com_hz.kcsl1 = 0 THEN\n" +
                "\t\t\t\trow_jxc_com_day.kchsje1 := row_com_hz.kchsje1;\n" +
                "\t\t\t\trow_jxc_com_day.kcbhsje1 := row_com_hz.kcbhsje1;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\trow_com_hz.kchsje1 := row_com_hz.kchsje1 - row_jxc_com_day.hsje;\n" +
                "\t\t\trow_com_hz.kcbhsje1 := row_com_hz.kcbhsje1 - row_jxc_com_day.bhsje;\n" +
                "\t\t\tprc_cost_db_change(row_jxc_com_day, row_com_hz, row_pici_fkc, 0, 1);\n" +
                "\t\t\tlv_negative_total := lv_negative_total - lv_ljclsl;\n" +
                "\t\tEND LOOP;\n" +
                "\t\tCLOSE cur_pici_fkc;\n" +
                "\t\tEXCEPTION\n" +
                "\t\t\tWHEN OTHERS THEN\n" +
                "\t\t\t\tIF cur_pici_fkc%ISOPEN THEN\n" +
                "\t\t\t\t\tCLOSE cur_pici_fkc;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\tIF cur_pici_normal%ISOPEN THEN\n" +
                "\t\t\t\t\tCLOSE cur_pici_normal;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\tIF cur_com_xs%ISOPEN THEN\n" +
                "\t\t\t\t\tCLOSE cur_com_xs;\n" +
                "\t\t\t\tEND IF;\n" +
                "\t\t\t\tRAISE;\n" +
                "\tEND;", result.targetSql);

        Assert.assertEquals(1, result.errors.size());
    }
}
