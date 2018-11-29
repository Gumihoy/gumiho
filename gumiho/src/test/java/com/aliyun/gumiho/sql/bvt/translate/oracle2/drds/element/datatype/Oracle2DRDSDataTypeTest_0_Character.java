package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.datatype;

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
public class Oracle2DRDSDataTypeTest_0_Character {


    @Test
    public void test() {
        String sql = "create table t(\n" +
                "c1 char,\n" +
                "c2 char(255),\n" +
                "c3 char(256),\n" +
                "c4 char(1000 byte),\n" +
                "c5 char(2000 char),\n" +

                "vc0 VARCHAR2(200 byte),\n" +
                "vc1 VARCHAR2(2000),\n" +
                "vc2 VARCHAR2(3000),\n" +
                "vc3 VARCHAR2(3000),\n" +
                "vc4 VARCHAR2(4000 BYTE),\n" +
                "vc5 VARCHAR2(3000 char),\n" +

                "nc1 NCHAR(255),\n" +
                "nc2 NCHAR(256),\n" +
                "nc3 NCHAR(2000),\n" +

                "nv1 NVARCHAR2(100),\n" +
                "nv2 NVARCHAR2(4000)\n" +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        SQLTransformResult result = SQLTransformUtils.oracleToDRDS(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `t` (\n" +
                "\t`c1` CHAR,\n" +
                "\t`c2` CHAR(255),\n" +
                "\t`c3` VARCHAR(256),\n" +
                "\t`c4` VARCHAR(1000),\n" +
                "\t`c5` VARCHAR(2000),\n" +
                "\t`vc0` VARCHAR(200),\n" +
                "\t`vc1` VARCHAR(2000),\n" +
                "\t`vc2` TEXT,\n" +
                "\t`vc3` TEXT,\n" +
                "\t`vc4` TEXT,\n" +
                "\t`vc5` TEXT,\n" +
                "\t`nc1` NCHAR(255),\n" +
                "\t`nc2` NVARCHAR(256),\n" +
                "\t`nc3` NVARCHAR(2000),\n" +
                "\t`nv1` NVARCHAR(100),\n" +
                "\t`nv2` NVARCHAR(4000)\n" +
                ")", result.targetSql);
    }

}
