package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.nullrelated;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLNullRelatedFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT COALESCE(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT COALESCE(0.9, 1, 5)\n" +
                "FROM `DUAL`", result.targetSql);
    }

    @Test
    public void test_2() {
        String sql = "SELECT * FROM DUAL WHERE LNNVL(.1 >= .2);";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `DUAL`\n" +
                "WHERE LNNVL(.1 >= .2);", result.targetSql);

        Assert.assertEquals(1, result.errors.size());
    }

    @Test
    public void test_3() {
        String sql = "SELECT NANVL(1,2), NANVL(NULL, 1) FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `DUAL`\n" +
                "WHERE LNNVL(.1 >= .2);", result.targetSql);
    }

    @Test
    public void test_4() {
        String sql = "SELECT NULLIF(1,2), NULLIF(NULL, 1) FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `DUAL`\n" +
                "WHERE LNNVL(.1 >= .2);", result.targetSql);
    }

    @Test
    public void test_5() {
        String sql = "SELECT NVL(1,2), NVL(NULL, 1) FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `DUAL`\n" +
                "WHERE LNNVL(.1 >= .2);", result.targetSql);
    }

    @Test
    public void test_6() {
        String sql = "SELECT NVL2(1, 1,2), NVL2(NULL, 1, 2) FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `DUAL`\n" +
                "WHERE LNNVL(.1 >= .2);", result.targetSql);
    }
}
