package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datetime;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCurrentDateFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT SESSIONTIMEZONE, CURRENT_DATE FROM DUAL";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SESSIONTIMEZONE, CURRENT_DATE\n" +
                "FROM DUAL", format);
    }


}
