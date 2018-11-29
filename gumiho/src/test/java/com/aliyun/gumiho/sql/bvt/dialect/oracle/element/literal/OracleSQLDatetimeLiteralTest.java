package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.literal;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDatetimeLiteralTest {


    @Test
    public void testDatetimeLiteral_0() {
        String sql = "SELECT DATE '1998-12-25' FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DATE '1998-12-25'\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void testDatetimeLiteral_1() {
        String sql = "SELECT DATE ? FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT DATE ?\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void testDatetimeLiteral_3() {
        String sql = "SELECT TIMESTAMP '1997-01-31 09:26:50.124' FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIMESTAMP '1997-01-31 09:26:50.124'\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void testDatetimeLiteral_4() {
        String sql = "SELECT TIMESTAMP '2009-10-29 01:30:00' AT TIME ZONE 'US/Pacific' FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIMESTAMP '2009-10-29 01:30:00' AT TIME ZONE 'US/Pacific'\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void testDatetimeLiteral_5() {
        String sql = "SELECT TIMESTAMP ? FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TIMESTAMP ?\n" +
                "FROM DUAL;", format);
    }

}
