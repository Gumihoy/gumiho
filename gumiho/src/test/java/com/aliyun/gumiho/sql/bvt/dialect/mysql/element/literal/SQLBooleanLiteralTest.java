package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/string-literals.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLBooleanLiteralTest {

    @Test
    public void test1() {
        String sql = "select 'Hello', 'ORACLE.dbs', 'Jackie''s raincoat', '09-MAR-98', N'nchar literal' from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'Hello', 'ORACLE.dbs', 'Jackie''s raincoat', '09-MAR-98',\n" +
                "\tN'nchar literal'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test2() {
        String sql = "select 'LIKE', 'SELECT * FROM dual' from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'LIKE', 'SELECT * FROM dual'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test3() {
        String sql = "select n '1' from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT n '1'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test4() {
        String sql = "select  'hello', '\"hello\"', '\"\"hello\"\"', 'hel''lo', '\\'hello' from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'hello', '\"hello\"', '\"\"hello\"\"', 'hel''lo', '\\'hello'\n" +
                "FROM dual;", format);
    }

}
