package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLExprCollateExprTest {


    @Test
    public void test_1() {
        String sql = "SELECT name COLLATE BINARY_CI FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT name COLLATE BINARY_CI\n" +
                "FROM DUAL;", format);
    }

}
