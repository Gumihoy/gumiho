package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.literal;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-49FADC66-794D-4763-88C7-B81BB4F26D9E
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLIntervalLiteralTest {


    @Test
    public void testIntervalLiteral_0() {
        String  s = "SELECT INTERVAL '123-2' YEAR(3) TO MONTH FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '123-2' YEAR(3) TO MONTH\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_1() {
        String s = "SELECT INTERVAL '123' YEAR(3) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '123' YEAR(3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_2() {
        String s = "SELECT INTERVAL '300' MONTH(3) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '300' MONTH(3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_3() {
        String s = "SELECT INTERVAL '4' YEAR FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '4' YEAR\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_4() {
        String s = "SELECT INTERVAL '50' MONTH FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '50' MONTH\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_5() {
        String s = "SELECT INTERVAL '123' YEAR FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '123' YEAR\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_6() {
        String s = "SELECT INTERVAL '6-11' YEAR TO MONTH FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '6-11' YEAR TO MONTH\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_7() {
        String s = "SELECT INTERVAL ? YEAR(?) TO MONTH FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL ? YEAR(?) TO MONTH\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void testIntervalLiteral_8() {
        String s = "SELECT INTERVAL '4 5:12:10.222' DAY TO SECOND(3) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '4 5:12:10.222' DAY TO SECOND(3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_9() {
        String s = "SELECT INTERVAL '4 5:12' DAY TO MINUTE FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '4 5:12' DAY TO MINUTE\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_10() {
        String s = "SELECT INTERVAL '400 5' DAY(3) TO HOUR FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '400 5' DAY(3) TO HOUR\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_11() {
        String s = "SELECT INTERVAL '400' DAY(3) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '400' DAY(3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_12() {
        String s = "SELECT INTERVAL '11:12:10.2222222' HOUR TO SECOND(7) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '11:12:10.2222222' HOUR TO SECOND(7)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_13() {
        String s = "SELECT INTERVAL '11:20' HOUR TO MINUTE FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '11:20' HOUR TO MINUTE\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void testIntervalLiteral_14() {
        String s = "SELECT INTERVAL '10' HOUR FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '10' HOUR\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void testIntervalLiteral_15() {
        String s = "SELECT INTERVAL '10:22' MINUTE TO SECOND FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '10:22' MINUTE TO SECOND\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_16() {
        String s = "SELECT INTERVAL '10' MINUTE FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '10' MINUTE\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_17() {
        String s = "SELECT INTERVAL '4' DAY FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '4' DAY\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_18() {
        String s = "SELECT INTERVAL '25' HOUR FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '25' HOUR\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_19() {
        String s = "SELECT INTERVAL '40' MINUTE FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '40' MINUTE\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_20() {
        String s = "SELECT INTERVAL '120' HOUR(3) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '120' HOUR(3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testIntervalLiteral_21() {
        String s = "SELECT INTERVAL '30.12345' SECOND(2,4) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL '30.12345' SECOND(2, 4)\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void testIntervalLiteral_22() {
        String s = "SELECT INTERVAL ? DAY(?) TO SECOND(?) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT INTERVAL ? DAY(?) TO SECOND(?)\n" +
                "FROM DUAL;", formatSQL);
    }
}
