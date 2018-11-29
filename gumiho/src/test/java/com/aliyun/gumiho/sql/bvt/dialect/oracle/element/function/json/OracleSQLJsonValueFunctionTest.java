package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonValueFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT JSON_VALUE('{a:100}', '$.a') AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_VALUE('{a:100}', '$.a') AS value\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "SELECT JSON_VALUE('{a:100}', '$.a' RETURNING NUMBER) AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_VALUE('{a:100}', '$.a' RETURNING NUMBER) AS value\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "SELECT JSON_VALUE('{firstname:\"John\"}', '$.lastname'\n" +
                "                  DEFAULT 'No last name found' ON ERROR) AS \"Last Name\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_VALUE('{firstname:\"John\"}', '$.lastname' DEFAULT 'No last name found' ON ERROR) AS \"Last Name\"\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "SELECT JSON_VALUE(sys.anydata.convertobject(self)) AS \"Last Name\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_VALUE(sys.anydata.convertobject(self)) AS \"Last Name\"\n" +
                "FROM DUAL;", formatSQL);
    }
}
