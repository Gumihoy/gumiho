package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SQL-JSON-Conditions.html#GUID-99B9493D-2929-4A09-BA39-A56F8E7319DA
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT col1\n" +
                "  FROM t\n" +
                "  WHERE col1 IS JSON;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT col1\n" +
                "FROM t\n" +
                "WHERE col1 IS JSON;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT col1\n" +
                "  FROM t\n" +
                "  WHERE col1 IS JSON STRICT;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT col1\n" +
                "FROM t\n" +
                "WHERE col1 IS JSON STRICT;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT col1\n" +
                "  FROM t\n" +
                "  WHERE col1 IS NOT JSON STRICT AND col1 IS JSON LAX;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT col1\n" +
                "FROM t\n" +
                "WHERE col1 IS NOT JSON STRICT AND col1 IS JSON LAX;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT col1 FROM t\n" +
                "  WHERE col1 IS JSON WITH UNIQUE KEYS;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT col1\n" +
                "FROM t\n" +
                "WHERE col1 IS JSON WITH UNIQUE KEYS;", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT col1 FROM t\n" +
                "  WHERE col1 IS JSON WITHOUT UNIQUE KEYS;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT col1\n" +
                "FROM t\n" +
                "WHERE col1 IS JSON WITHOUT UNIQUE KEYS;", format);
    }


    @Test
    public void test_6() {
        String sql = "SELECT name FROM t\n" +
                "  WHERE JSON_EXISTS(name, '$[0].first');";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT name\n" +
                "FROM t\n" +
                "WHERE JSON_EXISTS(name, '$[0].first');", format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT name FROM t\n" +
                "  WHERE JSON_EXISTS(name, '$[1].middle' TRUE ON ERROR);";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT name\n" +
                "FROM t\n" +
                "WHERE JSON_EXISTS(name, '$[1].middle' TRUE ON ERROR);", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT family_doc FROM families\n" +
                "  WHERE JSON_TEXTCONTAINS(family_doc, '$', '10');";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT family_doc\n" +
                "FROM families\n" +
                "WHERE JSON_TEXTCONTAINS(family_doc, '$', '10');", format);
    }
}
