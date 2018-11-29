package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.collation;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLNlsCollationIdFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT NLS_COLLATION_ID('BINARY_CI') \n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT NLS_COLLATION_ID('BINARY_CI')\n" +
                "FROM DUAL;", formatSQL);
    }

}
