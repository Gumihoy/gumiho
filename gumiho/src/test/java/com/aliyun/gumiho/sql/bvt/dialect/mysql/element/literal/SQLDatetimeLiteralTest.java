package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLDatetimeLiteralTest {


    @Test
    public void test_1() {
        String sql = "SELECT DATE '1998-12-25' FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DATE '1998-12-25'\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT DATE ? FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DATE ?\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT TIME '1998-12-25' FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIME '1998-12-25'\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_4() {
        String sql = "SELECT TIME ? FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIME ?\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT TIMESTAMP '2009-10-29 01:30:00' FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIMESTAMP '2009-10-29 01:30:00'\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT TIMESTAMP ? FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIMESTAMP ?\n" +
                "FROM DUAL;", format);
    }

}
