package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.element.operator;

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
public class Oracle2PPASBinaryOperatorTest {


    @Test
    public void test() {
        String sql = "SELECT SYSDATE + INTERVAL '1' YEAR FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `t` (\n" +
                "\t`c1` CHAR,\n" +
                "\t`c2` CHAR(255),\n" +
                "\t`c3` VARCHAR(256),\n" +
                "\t`c4` VARCHAR(1000),\n" +
                "\t`c5` VARCHAR(2000),\n" +
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
