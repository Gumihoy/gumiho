package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.dml.select;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLSelectTest_0_With {


    @Test
    public void test() {
        String sql = "WITH T0 AS\n" +
                "/***************************************************************************************\n" +
                "程序名称：T3_13111表对应视图(根据机构统一指标计算口径)\n" +
                "功能描述：\n" +
                "编写人员：wh\n" +
                "编写日期：20180125\n" +
                "修改日期：\n" +
                "修改人员：\n" +
                "修改原因：\n" +
                "***************************************************************************************/\n" +
                " (SELECT T1.ORGA_ID, T.INDEX_TYPE, T.INDEX_CODE\n" +
                "    FROM T1_INDEX_CONF T\n" +
                "    JOIN T1_INDEX_CONF_ORGA T1\n" +
                "      ON T.ID = T1.INDEX_ID),\n" +
                "--组合久期指标\n" +
                "T1 AS\n" +
                " (SELECT * FROM T0 WHERE INDEX_CODE = '1001'),\n" +
                "--债券久期指标\n" +
                "T2 AS\n" +
                " (SELECT * FROM T0 WHERE INDEX_CODE = '1002'),\n" +
                "--利率债久期指标\n" +
                "T3 AS\n" +
                " (SELECT * FROM T0 WHERE INDEX_CODE = '1003'),\n" +
                "--信用债久期指标\n" +
                "T4 AS\n" +
                " (SELECT * FROM T0 WHERE INDEX_CODE = '1004')\n" +
                "SELECT T.DATA_DT,\n" +
                "       T.ORG_ID,\n" +
                "       T.PROD_CD,\n" +
                "       T.PROD_NM,\n" +
                "       T.VAL_NET_P,\n" +
                "       T.CONVX_PROD,\n" +
                "       T.LEVR_PROD,\n" +
                "       T.CHG_CDCWI,\n" +
                "       T.VAL_IB,\n" +
                "       T.CHG_YLD_IB,\n" +
                "       T.VAL_CB,\n" +
                "       T.CHG_YLD_CB,\n" +
                "       T.VAL_TB,\n" +
                "       T.CHG_YLD_TB,\n" +
                "       T.CONC_TF,\n" +
                "       T.CONC_TT,\n" +
                "       T.SRC_CD,\n" +
                "       T.YLD_TD_AVG,\n" +
                "       T.BOND_VAL,\n" +
                "       T.REMAT_AVG,\n" +
                "       T.VAL_ZHG,\n" +
                "       CASE\n" +
                "         WHEN T1.INDEX_TYPE = '2' THEN\n" +
                "          T.DUA_PROD2\n" +
                "         ELSE\n" +
                "          T.DUA_PROD\n" +
                "       END DUA_PROD,\n" +
                "       CASE\n" +
                "         WHEN T2.INDEX_TYPE = '2' THEN\n" +
                "          T.DUA_BOND2\n" +
                "         ELSE\n" +
                "          T.DUA_BOND\n" +
                "       END DUA_BOND,\n" +
                "       CASE\n" +
                "         WHEN T3.INDEX_TYPE = '2' THEN\n" +
                "          T.DUA_IB2\n" +
                "         ELSE\n" +
                "          T.DUA_IB\n" +
                "       END DUA_IB,\n" +
                "       CASE\n" +
                "         WHEN T4.INDEX_TYPE = '2' THEN\n" +
                "          T.DUA_CB2\n" +
                "         ELSE\n" +
                "          T.DUA_CB\n" +
                "       END DUA_CB\n" +
                "  FROM T3_13111 T\n" +
                "  LEFT JOIN T1_PROD_ISS S\n" +
                "    ON T.PROD_CD = S.PROD_CD\n" +
                "  LEFT JOIN T1\n" +
                "    ON S.PTY_ID_ISSUER = T1.ORGA_ID\n" +
                "  LEFT JOIN T2\n" +
                "    ON S.PTY_ID_ISSUER = T2.ORGA_ID\n" +
                "  LEFT JOIN T3\n" +
                "    ON S.PTY_ID_ISSUER = T3.ORGA_ID\n" +
                "  LEFT JOIN T4\n" +
                "    ON S.PTY_ID_ISSUER = T4.ORGA_ID";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 CHAR,\n" +
                "\tc2 CHAR(1),\n" +
                "\tc3 CHAR(1),\n" +
                "\tc4 CHAR(1),\n" +
                "\tvc1 VARCHAR2,\n" +
                "\tvc2 VARCHAR2(1),\n" +
                "\tvc3 VARCHAR2(1),\n" +
                "\tvc4 VARCHAR2(1),\n" +
                "\tnc1 NCHAR,\n" +
                "\tnc2 NCHAR(1),\n" +
                "\tnvc2 NVARCHAR2(1)\n" +
                ")", result.targetSql);

    }


}
