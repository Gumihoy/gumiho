package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.datatype;

import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
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
public class Oracle2MySQLDataTypeTest_11_still_image_object {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 SI_StillImage ," +
                " c2 SI_AverageColor," +
                " c3 SI_PositionalColor ," +
                " c4 SI_ColorHistogram," +

                " vc1 SI_Texture ," +
                " vc2 SI_FeatureList ," +
                " vc3 SI_Color " +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 SI_StillImage,\n" +
                "\tc2 SI_AverageColor,\n" +
                "\tc3 SI_PositionalColor,\n" +
                "\tc4 SI_ColorHistogram,\n" +
                "\tvc1 SI_Texture,\n" +
                "\tvc2 SI_FeatureList,\n" +
                "\tvc3 SI_Color\n" +
                ")", result.targetSql);
    }

}
