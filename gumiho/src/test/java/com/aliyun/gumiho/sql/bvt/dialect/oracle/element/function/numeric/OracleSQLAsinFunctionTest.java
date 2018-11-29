package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.numeric;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLAsinFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT ASIN(.3) \"Arc_Sine\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT ASIN(.3) \"Arc_Sine\"\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT ASIN(?) FROM dual;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT ASIN(?)\n" +
                "FROM dual;", formatSQL);
    }

}
