package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.literal;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLNumericLiteralTest {

    @Test
    public void testNumericLiteral_0() {
        String s = "SELECT 7 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT 7\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testNumericLiteral_1() {
        String s = "SELECT +255 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT +255\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testNumericLiteral_2() {
        String s = "SELECT 0.23 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT 0.23\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testNumericLiteral_3() {
        String s = "SELECT 1.23 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT 1.23\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void testNumericLiteral_4() {
        String s = "SELECT +1.23 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT +1.23\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void testNumericLiteral_5() {
        String s = "SELECT 25E-03 FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT 25E-03\n" +
                "FROM DUAL;", formatSQL);
    }
}
