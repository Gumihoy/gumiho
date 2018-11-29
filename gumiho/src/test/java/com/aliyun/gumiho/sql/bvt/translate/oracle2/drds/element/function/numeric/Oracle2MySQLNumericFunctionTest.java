package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.numeric;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * abs(n)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ABS.html#GUID-D8D3489A-44EA-4FEC-A6F0-B5E312FFC231
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLNumericFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT abs(-15) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT abs(-15)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_2() {
        String sql = "SELECT acos(.3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT acos(.3)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_3() {
        String sql = "SELECT ASIN(.3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT ASIN(.3)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_4() {
        String sql = "SELECT ATAN(.3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT ATAN(.3)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_5() {
        String sql = "SELECT ATAN2(.3, .2) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT ATAN2(.3, .2)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_6() {
        String sql = "SELECT BITAND(.3, .2) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT (.3 & .2)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_7() {
        String sql = "SELECT CEIL(3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CEIL(3)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_8() {
        String sql = "SELECT COS(180 * 3.14159265359/180) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT COS(180 * 3.14159265359 / 180)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_9() {
        String sql = "SELECT COSH(1), COSH(0), COSH(-1) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT (EXP(1) + EXP(-1)) / 2, EXP(0), (EXP(-1) + EXP(1)) / 2\n" +
                "FROM dual;", result.targetSql);
    }


    @Test
    public void test_10() {
        String sql = "SELECT EXP(4) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT EXP(4)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_11() {
        String sql = "SELECT FLOOR(15.7) FROM dual;\n" +
                "SELECT FLOOR(15.4) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT FLOOR(15.7)\n" +
                "FROM dual;\n" +
                "SELECT FLOOR(15.4)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_12() {
        String sql = "SELECT LN(95) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT LN(95)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_13() {
        String sql = "SELECT LOG(10,100) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT LOG(10, 100)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_14() {
        String sql = "SELECT MOD(11, 4) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT MOD(11, 4)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_15() {
        String sql = "SELECT NANVL(null, 3) FROM dual;\n" +
                "SELECT NANVL(1, 3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_16() {
        String sql = "SELECT POWER(3, 2) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT POWER(3, 2)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_17() {
        String sql = "SELECT REMAINDER(3.2, 2.3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT (3.2 - 2.3 * ROUND(3.2 / 2.3))\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_18() {
        String sql = "SELECT ROUND(15.193) FROM dual;\n" +
                "SELECT ROUND(15.193, 1) FROM dual;\n" +
                "SELECT ROUND(15.193, -1) FROM dual;\n";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT ROUND(15.193)\n" +
                "FROM dual;\n" +
                "SELECT ROUND(15.193, 1)\n" +
                "FROM dual;\n" +
                "SELECT ROUND(15.193, -1)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_19() {
        String sql = "SELECT SIGN(3) FROM dual;\n" +
                "SELECT SIGN(0) FROM dual;\n" +
                "SELECT SIGN(-3) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT SIGN(3)\n" +
                "FROM dual;\n" +
                "SELECT SIGN(0)\n" +
                "FROM dual;\n" +
                "SELECT SIGN(-3)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_20() {
        String sql = "SELECT SIN(30 * 3.14159265359/180) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT SIN(30 * 3.14159265359 / 180)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_21() {
        String sql = "SELECT SINH(1), SINH(0), SINH(-1) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT (EXP(1) - EXP(-1)) / 2, 0, (EXP(-1) - EXP(1)) / 2\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_22() {
        String sql = "SELECT SQRT(26) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT SQRT(26)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_23() {
        String sql = "SELECT TAN(135 * 3.14159265359/180) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT TAN(135 * 3.14159265359 / 180)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_24() {
        String sql = "SELECT TANH(.5) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT (EXP(1.0) - 1) / (EXP(1.0) + 1)\n" +
                "FROM dual;", result.targetSql);
    }

    @Test
    public void test_25() {
        String sql = "SELECT TRUNC(15.79) FROM dual;\n" +
                "SELECT TRUNC(15.79, 1) FROM dual;\n" +
                "SELECT TRUNC(15.79, -1) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_26() {
        String sql = "SELECT WIDTH_BUCKET(100, 100, 5000, 10) FROM dual;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }


}
