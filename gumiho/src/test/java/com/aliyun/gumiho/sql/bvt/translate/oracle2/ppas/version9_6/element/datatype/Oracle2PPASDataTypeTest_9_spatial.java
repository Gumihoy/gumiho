package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.element.datatype;

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
public class Oracle2PPASDataTypeTest_9_spatial {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 SDO_Geometry, " +
                " c2 SDO_Topo_Geometry ," +
                " c3 SDO_GeoRaster " +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 SDO_Geometry,\n" +
                "\tc2 SDO_Topo_Geometry,\n" +
                "\tc3 SDO_GeoRaster\n" +
                ")", result.targetSql);
    }

}