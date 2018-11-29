package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.datamining;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLDataMiningFunctionTest {

    @Test
    public void test_0() {
        String sql = "SELECT CLUSTER_DETAILS(hire_date, 1) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_1() {
        String sql = "SELECT CLUSTER_DISTANCE(hire_date, 1) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_2() {
        String sql = "SELECT CLUSTER_ID(hire_date, 1) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_3() {
        String sql = "SELECT CLUSTER_PROBABILITY() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_4() {
        String sql = "SELECT CLUSTER_SET() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_5() {
        String sql = "SELECT FEATURE_COMPARE() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_6() {
        String sql = "SELECT FEATURE_DETAILS() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_7() {
        String sql = "SELECT FEATURE_ID() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_8() {
        String sql = "SELECT FEATURE_SET() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_9() {
        String sql = "SELECT FEATURE_VALUE() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_10() {
        String sql = "SELECT ORA_DM_PARTITION_NAME() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_11() {
        String sql = "SELECT PREDICTION() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_12() {
        String sql = "SELECT PREDICTION_BOUNDS() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_13() {
        String sql = "SELECT PREDICTION_COST() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_14() {
        String sql = "SELECT PREDICTION_DETAILS() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_15() {
        String sql = "SELECT PREDICTION_PROBABILITY() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
    @Test
    public void test_16() {
        String sql = "SELECT PREDICTION_SET() FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

}
