package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.json;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLJsonFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT JSON_QUERY()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_2() {
        String sql = "SELECT JSON_TABLE()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_3() {
        String sql = "SELECT JSON_VALUE()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_4() {
        String sql = "SELECT JSON_ARRAY()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_5() {
        String sql = "SELECT JSON_ARRAYAGG()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_6() {
        String sql = "SELECT JSON_OBJECT()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_7() {
        String sql = "SELECT JSON_OBJECTAGG()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_8() {
        String sql = "SELECT JSON_DATAGUIDE()" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
