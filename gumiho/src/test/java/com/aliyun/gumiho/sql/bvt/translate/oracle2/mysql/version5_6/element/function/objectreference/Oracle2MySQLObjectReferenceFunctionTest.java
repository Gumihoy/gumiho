package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.objectreference;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLObjectReferenceFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT DEREF(address)\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT MAKE_REF(address)\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT REF(address)\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_4() {
        String sql = "SELECT REFTOHEX(address)\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
    @Test
    public void test_5() {
        String sql = "SELECT VALUE(address)\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
