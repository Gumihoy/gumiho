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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_23_Union {

    @Test
    public void test_0() {
        String sql = "select '01' ydjy_dm,  --税务稽查\n" +
                "       yd.fxyd_dm,\n" +
                "       yd.sjwc_sj sjwc_sj,\n" +
                "        decode(zsxm_id,'01','01','03','03','04','04','99') zsxm_dm,\n" +
                "       sum(nvl(cbsk, 0)) cbsk,\n" +
                "       sum(nvl(znj, 0)) znj,\n" +
                "       sum(nvl(fkje, 0)) fkje,\n" +
                "       sum(nvl(cjldsj, 0)) cjldsj,\n" +
                "       sum(nvl(cjytsj, 0)) cjytsj,\n" +
                "       sum(nvl(tzks, 0)) tzks\n" +
                "  from (\n" +
                "        --填写金额\n" +
                "        select b.fxyd_dm,\n" +
                "               zsxm_dm zsxm_id,\n" +
                "               bsje cbsk,\n" +
                "               b.znj,\n" +
                "               b.swjc_fk fkje,\n" +
                "               b.swjc_ldsj cjldsj,\n" +
                "               b.swjc_ytsj cjytsj,\n" +
                "               b.tzks\n" +
                "          from FXGL_FXYD_SWJC_BSQKTJFKB b) sk,\n" +
                "       FXGL_FXYD_JCFKB yd\n" +
                " where sk.fxyd_dm(+) = yd.fxyd_dm\n" +
                " group by yd.fxyd_dm, yd.sjwc_sj,decode(sk.zsxm_id,'01','01','03','03','04','04','99')\n" +
                " union all\n" +
                "--纳税评估\n" +
                "select ydjy_dm,\n" +
                "       fxyd_dm,\n" +
                "       sjwc_sj,\n" +
                "       zsxm_dm,\n" +
                "       cbsk,\n" +
                "       nvl(znj, 0) znj,\n" +
                "       0 fkje,\n" +
                "       nvl(cjldsj,0) cjldsj,\n" +
                "       nvl(cjytsj,0) cjytsj,\n" +
                "       nvl(tzks, 0) tzks\n" +
                "  from\n" +
                "  (select '02' ydjy_dm,nspg.fxyd_dm,max(nspg.fk_sj) sjwc_sj,\n" +
                "     decode(fkb.zsxm_dm,'01','01','03','03','04','04','99') zsxm_dm,\n" +
                "     sum(fkb.NSPG_RKSE+fkb.NSPG_BKBS+fkb.NSPG_QT) cbsk,\n" +
                "     sum(fkb.znj) znj,\n" +
                "     sum(fkb.tzks) tzks,\n" +
                "     sum(fkb.nspg_ldsj) cjldsj,\n" +
                "     sum(fkb.nspg_ytsj) cjytsj\n" +
                " from FXGL_FXYD_NSPG_PGGZBDFKB nspg,FXGL_FXYD_NSPG_BSQKTJFKB fkb\n" +
                " where fkb.fxyd_dm=nspg.fxyd_dm\n" +
                " group by nspg.fxyd_dm,decode(fkb.zsxm_dm,'01','01','03','03','04','04','99'))\n" +
                " union all\n" +
                " --提示提醒\n" +
                " select '03' ydjy_dm,tstx.fxyd_dm,max(tstx.sjwc_sj) sjwc_sj,\n" +
                "    decode(fkb.zsxm_dm,'01','01','03','03','04','04','99') zsxm_dm,\n" +
                "    sum(fkb.NSPG_RKSE+fkb.NSPG_BKBS+fkb.NSPG_QT) cbsk,\n" +
                "    sum(fkb.znj) znj,\n" +
                "     0 fkje,\n" +
                "     sum(fkb.nspg_ldsj) cjldsj,\n" +
                "     sum(fkb.nspg_ytsj) cjytsj,\n" +
                "     sum(fkb.tzks) tzks\n" +
                "  from FXGL_FXYD_TSTXCLB tstx,FXGL_FXYD_JC_BSQKTJFKB fkb\n" +
                "  where fkb.fxyd_dm=tstx.fxyd_dm\n" +
                "  and tstx.sjwc_sj is not null\n" +
                "  group by tstx.fxyd_dm,decode(fkb.zsxm_dm,'01','01','03','03','04','04','99')";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT '01' ydjy_dm, yd.fxyd_dm, yd.sjwc_sj sjwc_sj,\n" +
                "\tdecode(zsxm_id, '01', '01', '03', '03', '04', '04', '99') zsxm_dm,\n" +
                "\tsum(nvl(cbsk, 0)) cbsk, sum(nvl(znj, 0)) znj,\n" +
                "\tsum(nvl(fkje, 0)) fkje, sum(nvl(cjldsj, 0)) cjldsj,\n" +
                "\tsum(nvl(cjytsj, 0)) cjytsj, sum(nvl(tzks, 0)) tzks\n" +
                "FROM (\n" +
                "\tSELECT b.fxyd_dm, zsxm_dm zsxm_id, bsje cbsk, b.znj, b.swjc_fk fkje,\n" +
                "\t\tb.swjc_ldsj cjldsj, b.swjc_ytsj cjytsj, b.tzks\n" +
                "\tFROM FXGL_FXYD_SWJC_BSQKTJFKB b\n" +
                ") sk, FXGL_FXYD_JCFKB yd\n" +
                "WHERE sk.fxyd_dm(+) = yd.fxyd_dm\n" +
                "GROUP BY yd.fxyd_dm, yd.sjwc_sj, decode(sk.zsxm_id, '01', '01', '03', '03', '04', '04', '99')\n" +
                "UNION ALL\n" +
                "SELECT ydjy_dm, fxyd_dm, sjwc_sj, zsxm_dm, cbsk, nvl(znj, 0) znj, 0 fkje,\n" +
                "\tnvl(cjldsj, 0) cjldsj, nvl(cjytsj, 0) cjytsj, nvl(tzks, 0) tzks\n" +
                "FROM (\n" +
                "\tSELECT '02' ydjy_dm, nspg.fxyd_dm, max(nspg.fk_sj) sjwc_sj,\n" +
                "\t\tdecode(fkb.zsxm_dm, '01', '01', '03', '03', '04', '04', '99') zsxm_dm,\n" +
                "\t\tsum(fkb.NSPG_RKSE + fkb.NSPG_BKBS + fkb.NSPG_QT) cbsk,\n" +
                "\t\tsum(fkb.znj) znj, sum(fkb.tzks) tzks, sum(fkb.nspg_ldsj) cjldsj,\n" +
                "\t\tsum(fkb.nspg_ytsj) cjytsj\n" +
                "\tFROM FXGL_FXYD_NSPG_PGGZBDFKB nspg, FXGL_FXYD_NSPG_BSQKTJFKB fkb\n" +
                "\tWHERE fkb.fxyd_dm = nspg.fxyd_dm\n" +
                "\tGROUP BY nspg.fxyd_dm, decode(fkb.zsxm_dm, '01', '01', '03', '03', '04', '04', '99')\n" +
                ")\n" +
                "UNION ALL\n" +
                "SELECT '03' ydjy_dm, tstx.fxyd_dm, max(tstx.sjwc_sj) sjwc_sj,\n" +
                "\tdecode(fkb.zsxm_dm, '01', '01', '03', '03', '04', '04', '99') zsxm_dm,\n" +
                "\tsum(fkb.NSPG_RKSE + fkb.NSPG_BKBS + fkb.NSPG_QT) cbsk,\n" +
                "\tsum(fkb.znj) znj, 0 fkje, sum(fkb.nspg_ldsj) cjldsj,\n" +
                "\tsum(fkb.nspg_ytsj) cjytsj, sum(fkb.tzks) tzks\n" +
                "FROM FXGL_FXYD_TSTXCLB tstx, FXGL_FXYD_JC_BSQKTJFKB fkb\n" +
                "WHERE fkb.fxyd_dm = tstx.fxyd_dm AND tstx.sjwc_sj IS NOT NULL\n" +
                "GROUP BY tstx.fxyd_dm, decode(fkb.zsxm_dm, '01', '01', '03', '03', '04', '04', '99')", format);
    }


}
