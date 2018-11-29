package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.operator;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLBinaryOperatorTest {


    @Test
    public void test_1() {
        String sql = "SELECT 1|1, 1&1, 1^1, -1-3, 100-2*4*5, 100 div 5, 100 mod 5, 100 % 5 FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 | 1, 1 & 1, 1 1, -1 - 3, 100 - 2 * 4 * 5, 100 DIV 5, 100 MOD 5, 100 % 5\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT -1+(-3) FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT -1 + (-3)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT 1-1+(-3) * 4 / 5 FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 - 1 + (-3) * 4 / 5\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT 'Name is ' || last_name FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'Name is ' || last_name\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_5() {
        String sql = "SELECT last_name\n" +
                "  FROM employees\n" +
                "  ORDER BY last_name COLLATE GENERIC_M;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name\n" +
                "FROM employees\n" +
                "ORDER BY last_name COLLATE GENERIC_M;", format);
    }


    @Test
    public void test_6() {
        String sql = "SELECT * from dual UNION SELECT * from dual";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "UNION\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }


    @Test
    public void test_7() {
        String sql = "SELECT * from dual UNION ALL SELECT * from dual";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "UNION ALL\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT * from dual UNION DISTINCT SELECT * from dual";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "UNION DISTINCT\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }


    @Test
    public void test_9() {
        // '!='| '<>'| '<=>' | > | < | >> | <<
        String sql = "SELECT 1<< 1, 1 >> 2, 1 || 1 FROM DUAL where 1=1 and 1> 1 and 1< 1 and 1 != 1 and 1<>1 and 2 >= 1 and 1 <= 1 ;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 << 1, 1 >> 2, 1 || 1\n" +
                "FROM DUAL\n" +
                "WHERE 1 = 1 AND 1 > 1 AND 1 < 1 AND 1 != 1 AND 1 <> 1 AND 2 >= 1 AND 1 <= 1;", format);
    }
}
