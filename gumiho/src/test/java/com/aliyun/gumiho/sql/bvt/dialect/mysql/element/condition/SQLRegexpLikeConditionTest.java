package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pattern-matching-Conditions.html#GUID-3FA7F5AB-AC64-4200-8F90-294101428C26
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLRegexpLikeConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT first_name, last_name\n" +
                "FROM employees\n" +
                "WHERE REGEXP_LIKE (first_name, '^Ste(v|ph)en$')\n" +
                "ORDER BY first_name, last_name;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT first_name, last_name\n" +
                "FROM employees\n" +
                "WHERE REGEXP_LIKE(first_name, '^Ste(v|ph)en$')\n" +
                "ORDER BY first_name, last_name;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT last_name\n" +
                "FROM employees\n" +
                "WHERE REGEXP_LIKE (last_name, '([aeiou])\\1', 'i')\n" +
                "ORDER BY last_name;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name\n" +
                "FROM employees\n" +
                "WHERE REGEXP_LIKE(last_name, '([aeiou])\\1', 'i')\n" +
                "ORDER BY last_name;", format);
    }
}
