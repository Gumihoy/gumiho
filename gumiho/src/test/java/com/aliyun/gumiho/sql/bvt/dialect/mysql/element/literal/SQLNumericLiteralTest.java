package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLNumericLiteralTest {

    @Test
    public void test_1() {
        String sql = "SELECT 1, .2, 3.4, -5, -6.78, +9.10 FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1, .2, 3.4, -5, -6.78, +9.10\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT 1.2E3, 1.2E-3, -1.2E3, -1.2E-3 FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1.2E3, 1.2E-3, -1.2E3, -1.2E-3\n" +
                "FROM DUAL;", format);
    }
}
