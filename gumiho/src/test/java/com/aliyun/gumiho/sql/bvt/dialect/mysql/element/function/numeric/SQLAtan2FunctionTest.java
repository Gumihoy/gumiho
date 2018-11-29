package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.numeric;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLAtan2FunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ACOS(.3)\"Arc_Cosine\"\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT ACOS(?) FROM dual;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
