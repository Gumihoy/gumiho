package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.dml.select;

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
public class Oracle2MySQLSelectTest_3_Intersect {


    @Test
    public void test_0() {
        String sql = "SELECT x, y FROM table_a\n" +
                "INTERSECT\n" +
                "SELECT x, y FROM table_b;" +
                "SELECT a.x, a.y\n" +
                "FROM table_a a JOIN table_b b\n" +
                "ON a.x = b.x AND a.y = b.y;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT a.x, a.y\n" +
                "FROM `table_a` a\n" +
                "\tLEFT JOIN `table_b` b\n" +
                "\tON a.x = b.x\n" +
                "\t\tAND a.y = b.y\n" +
                "WHERE b.x IS NULL;", result.targetSql);

    }

}
