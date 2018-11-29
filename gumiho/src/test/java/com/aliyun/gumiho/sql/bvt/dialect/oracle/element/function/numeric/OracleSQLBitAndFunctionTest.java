package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.numeric;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLBitAndFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT BITAND(6,3)\n" +
                "  FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT BITAND(6, 3)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT BITAND(\n" +
                "    BIN_TO_NUM(1,1,0),\n" +
                "    BIN_TO_NUM(0,1,1)) \"Binary\"\n" +
                "  FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT BITAND(BIN_TO_NUM(1, 1, 0), BIN_TO_NUM(0, 1, 1)) \"Binary\"\n" +
                "FROM DUAL;", formatSQL);
    }

}
