package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_11_still_image_object {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 SI_StillImage ," +
                " c2 SI_AverageColor," +
                " c3 SI_PositionalColor ," +
                " c4 SI_ColorHistogram," +
                " c5 sys.SI_StillImage ," +
                " c6 sys.SI_AverageColor," +
                " c7 sys.SI_PositionalColor ," +
                " c8 sys.SI_ColorHistogram," +
                " c9 \"sys\".SI_StillImage ," +
                " c10 \"sys\".SI_AverageColor," +
                " c11 \"sys\".SI_PositionalColor ," +
                " c12 \"sys\".SI_ColorHistogram," +

                " vc1 SI_Texture ," +
                " vc2 SI_FeatureList ," +
                " vc3 SI_Color, " +
                " vc1 \"sys\".SI_Texture ," +
                " vc2 \"sys\".SI_FeatureList ," +
                " vc3 \"sys\".SI_Color " +
                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 SI_StillImage,\n" +
                "\tc2 SI_AverageColor,\n" +
                "\tc3 SI_PositionalColor,\n" +
                "\tc4 SI_ColorHistogram,\n" +
                "\tvc1 SI_Texture,\n" +
                "\tvc2 SI_FeatureList,\n" +
                "\tvc3 SI_Color\n" +
                ")", format);
    }

}
