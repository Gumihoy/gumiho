package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.json;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class MySQLSQLJsonFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT JSON_ARRAY_APPEND(@j, '$[1]', 1)" +
                "  FROM id_table;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT JSON_ARRAY_APPEND(@j, '$[1]', 1)\n" +
                "FROM id_table;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT JSON_ARRAY_INSERT(@j, '$[1]', 1)" +
                "  FROM id_table;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT JSON_ARRAY_INSERT(@j, '$[1]', 1)\n" +
                "FROM id_table;", format);
    }

}
