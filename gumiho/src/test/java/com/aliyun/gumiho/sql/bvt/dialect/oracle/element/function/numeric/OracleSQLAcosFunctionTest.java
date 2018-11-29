package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.numeric;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLAcosFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT ACOS(.3)\"Arc_Cosine\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT ACOS(.3) \"Arc_Cosine\"\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT ACOS(?) FROM dual;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT ACOS(?)\n" +
                "FROM dual;", formatSQL);
    }

}
