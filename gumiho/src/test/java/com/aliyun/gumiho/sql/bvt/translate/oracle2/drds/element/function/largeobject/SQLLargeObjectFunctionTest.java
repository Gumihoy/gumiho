package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.largeobject;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLLargeObjectFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT BFILENAME('MEDIA_DIR', 'modem_comp_ad.gif')\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("-------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT EMPTY_BLOB('MEDIA_DIR', 'modem_comp_ad.gif')\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("-------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT EMPTY_CLOB('MEDIA_DIR', 'modem_comp_ad.gif')\n" +
                "  FROM customer_addresses;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("-------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(sql, format);
    }
}
