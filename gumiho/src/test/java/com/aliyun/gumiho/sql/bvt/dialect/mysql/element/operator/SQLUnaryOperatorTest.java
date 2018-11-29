package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.operator;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLUnaryOperatorTest {


    @Test
    public void test_1() {
        String sql = "SELECT -4, -(-4), +4, ~4,!4, BINARY 4 FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT -4, -(-4), +4, ~4, !4, BINARY 4\n" +
                "FROM DUAL;", format);
    }

}
