package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.largeobject;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLEmptyClobFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT EMPTY_BLOB()\n" +
                "  FROM customer_addresses;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT EMPTY_BLOB()\n" +
                "FROM customer_addresses;", formatSQL);
    }

}
