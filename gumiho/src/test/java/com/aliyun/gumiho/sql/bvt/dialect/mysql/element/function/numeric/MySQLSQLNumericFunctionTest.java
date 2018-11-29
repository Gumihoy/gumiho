package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.numeric;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class MySQLSQLNumericFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ABS(2), ABS(-32) " +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ABS(2), ABS(-32)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT ACOS(1), ACOS(1.0001) FROM dual; ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ACOS(1), ACOS(1.0001)\n" +
                "FROM dual;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT ASIN(0.2) FROM dual; ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ASIN(0.2)\n" +
                "FROM dual;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT ATAN(2), ATAN(-2) " +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ATAN(2), ATAN(-2)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT ATAN2(2), ATAN2(-2) " +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ATAN2(2), ATAN2(-2)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT CEILING(1.23), CEILING(-1.23) " +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CEILING(1.23), CEILING(-1.23)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT CONV('a',16,2), CONV(10+'10'+'10'+X'0a',10,10)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CONV('a', 16, 2), CONV(10 + '10' + '10' + X'0a', 10, 10)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT COS(PI())" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT COS(PI())\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_9() {
        String sql = "SELECT COT(12)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT COT(12)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_10() {
        String sql = "SELECT CRC32('MySQL')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CRC32('MySQL')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_11() {
        String sql = "SELECT DEGREES(PI())" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DEGREES(PI())\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_12() {
        String sql = "SELECT EXP(2)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT EXP(2)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_13() {
        String sql = "SELECT FLOOR(1.23), FLOOR(-1.23)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FLOOR(1.23), FLOOR(-1.23)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_14() {
        String sql = "SELECT FORMAT(1, '##.#')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FORMAT(1, '##.#')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_15() {
        String sql = "SELECT LN(2)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LN(2)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_16() {
        String sql = "SELECT LOG(2), LOG(2,65536)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LOG(2), LOG(2, 65536)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_17() {
        String sql = "SELECT LOG10(2), LOG10(2,65536)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LOG10(2), LOG10(2, 65536)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_18() {
        String sql = "SELECT MOD(234, 10)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT MOD(234, 10)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_19() {
        String sql = "SELECT POWER(234, 10)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT POWER(234, 10)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_20() {
        String sql = "SELECT RADIANS(90)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT RADIANS(90)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_21() {
        String sql = "SELECT FLOOR(7 + (RAND() * 5))" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FLOOR(7 + (RAND() * 5))\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_22() {
        String sql = "SELECT ROUND(-1.23)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ROUND(-1.23)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_23() {
        String sql = "SELECT SIGN(23)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SIGN(23)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_24() {
        String sql = "SELECT SIN(PI())" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SIN(PI())\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_25() {
        String sql = "SELECT SQRT(4)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SQRT(4)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_26() {
        String sql = "SELECT TAN(PI())" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TAN(PI())\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_27() {
        String sql = "SELECT TRUNCATE(1.223,1)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TRUNCATE(1.223, 1)\n" +
                "FROM DUAL;", format);
    }
}
