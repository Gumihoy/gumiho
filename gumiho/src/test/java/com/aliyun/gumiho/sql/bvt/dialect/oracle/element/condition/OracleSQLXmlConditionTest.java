package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XML-Conditions.html#GUID-DE0B495D-F70A-4D37-AB8B-9376991E6081
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ANY_PATH FROM RESOURCE_VIEW\n" +
                "   WHERE EQUALS_PATH(res, '/sys/schemas/OE/www.example.com')=1;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ANY_PATH\n" +
                "FROM RESOURCE_VIEW\n" +
                "WHERE EQUALS_PATH(res, '/sys/schemas/OE/www.example.com') = 1;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT ANY_PATH FROM RESOURCE_VIEW\n" +
                "   WHERE UNDER_PATH(res, '/sys/schemas/OE/www.example.com')=1;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ANY_PATH\n" +
                "FROM RESOURCE_VIEW\n" +
                "WHERE UNDER_PATH(res, '/sys/schemas/OE/www.example.com') = 1;", format);
    }


}
