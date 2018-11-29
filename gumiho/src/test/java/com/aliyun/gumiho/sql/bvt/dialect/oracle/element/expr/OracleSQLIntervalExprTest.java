package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLIntervalExprTest {


    @Test
    public void test_0() {
        String s = "SELECT (SYSTIMESTAMP - order_date) DAY(9) TO SECOND FROM orders\n" +
                "   WHERE order_id = 2458; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT (SYSTIMESTAMP - order_date) DAY (9) TO SECOND\n" +
                "FROM orders\n" +
                "WHERE order_id = 2458;", formatSQL);
    }

}
