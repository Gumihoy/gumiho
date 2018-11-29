package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.objectreference;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLDerefFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT DEREF(address)\n" +
                "  FROM customer_addresses;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT DEREF(address)\n" +
                "FROM customer_addresses;", formatSQL);
    }

}
