package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.xml;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class MySQLSQLXmlCastFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ExtractValue('<a><b/></a>', '/a/b') FROM DUAL; ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ExtractValue('<a><b/></a>', '/a/b')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT UpdateXML('<a><b>ccc</b><d></d></a>', '/a', '<e>fff</e>') FROM DUAL; ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT UpdateXML('<a><b>ccc</b><d></d></a>', '/a', '<e>fff</e>')\n" +
                "FROM DUAL;", format);
    }
}
