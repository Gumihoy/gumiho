package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.datetime;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLLocalTimestampFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT LOCALTIMESTAMP FROM DUAL";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT LOCALTIMESTAMP(3) FROM DUAL";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
