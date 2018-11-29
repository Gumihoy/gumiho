package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonQueryFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT JSON_QUERY('{a:100, b:200, c:300}', '$') AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_QUERY('{a:100, b:200, c:300}', '$') AS value\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "SELECT JSON_QUERY('{a:100, b:200, c:300}', '$.a' WITH WRAPPER) AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_QUERY('{a:100, b:200, c:300}', '$.a' WITH WRAPPER) AS value\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[*]'\n" +
                "       WITH CONDITIONAL WRAPPER) AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[*]' WITH CONDITIONAL WRAPPER) AS value\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_4() {
        String s = "SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[*]'\n" +
                "       RETURNING VARCHAR2(100) WITH CONDITIONAL WRAPPER) AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[*]' RETURNING VARCHAR2(100) WITH CONDITIONAL WRAPPER) AS value\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_5() {
        String s = "SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[3]'\n" +
                "       EMPTY ON ERROR) AS value\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_QUERY('[{\"a\":100},{\"b\":200},{\"c\":300}]', '$[3]' EMPTY ON ERROR) AS value\n" +
                "FROM DUAL;", formatSQL);
    }
}
