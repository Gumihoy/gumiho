package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/string-literals.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLNullLiteralTest {

    @Test
    public void test1() {
        String sql = "INSERT INTO my_table (phone) VALUES (NULL);";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("INSERT INTO my_table (phone)\n" +
                "VALUES (NULL);", format);
    }

    @Test
    public void test2() {
        String sql = "SELECT NULL, 1+NULL, CONCAT('Invisible',NULL);";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT NULL, 1 + NULL, CONCAT('Invisible', NULL);", format);
    }

    @Test
    public void test3() {
        String sql = "SELECT * FROM my_table WHERE phone = NULL;";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM my_table\n" +
                "WHERE phone = NULL;", format);
    }

}
