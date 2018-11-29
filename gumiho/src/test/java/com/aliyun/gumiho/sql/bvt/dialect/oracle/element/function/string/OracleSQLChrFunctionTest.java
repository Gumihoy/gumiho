package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.string;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CHR.html#GUID-35FEE007-D49C-4562-A904-041186AC8928
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLChrFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT CHR(67)||CHR(65)||CHR(84) \"Dog\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CHR(67) || CHR(65) || CHR(84) \"Dog\"\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "select chr(66+1) from dual; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CHR(66 + 1)\n" +
                "FROM dual;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "SELECT CHR (? USING NCHAR_CS)\n" +
                "  FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CHR(? USING NCHAR_CS)\n" +
                "FROM DUAL;", formatSQL);
    }
}
