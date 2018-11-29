package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.dml.locktable;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LOCK-TABLE.html#GUID-4C00C6D9-C5C5-46CC-AD33-A64001744A4C
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLLockTableTest_0 {


    @Test
    public void test_0() {
        String sql = "LOCK TABLE employees\n" +
                "   IN EXCLUSIVE MODE \n" +
                "   NOWAIT; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("LOCK TABLE employees\n" +
                "   IN EXCLUSIVE MODE \n" +
                "   NOWAIT; ", result.targetSql);
    }


    @Test
    public void test_1() {
        String sql = "LOCK TABLE employees@remote \n" +
                "   IN SHARE MODE; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("LOCK TABLE employees@remote \n" +
                "   IN SHARE MODE;", result.targetSql);

    }

}
