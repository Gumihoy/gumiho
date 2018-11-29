package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.collation;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLCollationFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT COLLATION(name), COLLATION(?)\n" +
                "  FROM id_table;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT NLS_COLLATION_ID(name), COLLATION(?)\n" +
                "  FROM id_table;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT NLS_COLLATION_NAME(name), COLLATION(?)\n" +
                "  FROM id_table;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
