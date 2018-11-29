package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.objectreference;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLValueFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT VALUE(p) FROM persons p;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT VALUE(p)\n" +
                "FROM persons p;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT VALUE(?) FROM persons p;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT VALUE(?)\n" +
                "FROM persons p;", formatSQL);
    }
}
