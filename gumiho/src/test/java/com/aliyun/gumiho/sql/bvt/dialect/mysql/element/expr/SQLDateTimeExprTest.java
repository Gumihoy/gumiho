package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.expr;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLDateTimeExprTest {


    @Test
    public void test_1() {
        String sql = "SELECT -(-4) FROM DUAL;";

        String format = OracleUtils.format(sql);

        Assert.assertEquals("SELECT -(-4)\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT CONNECT_BY_ROOT last_name \"Manager\" FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
