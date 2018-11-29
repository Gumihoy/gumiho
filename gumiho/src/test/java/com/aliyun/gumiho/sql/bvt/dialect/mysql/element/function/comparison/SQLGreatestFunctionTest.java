package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.comparison;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLGreatestFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT GREATEST('HARRY', 'HARRIOT', 'HAROLD') \"Greatest\"\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
