package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.conversion;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TO_CHAR-datetime.html#GUID-0C3EEFD1-AE3D-452D-BF23-2FC95664E78F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLToCharFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT TO_CHAR(media_col, 873) FROM media_tab;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TO_CHAR(media_col, 873)\n" +
                "FROM media_tab;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT TO_CHAR('01110') FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TO_CHAR('01110')\n" +
                "FROM DUAL;", formatSQL);
    }


    @Test
    public void test_2() {
        String s = "SELECT TO_CHAR('01110' + 1) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TO_CHAR('01110' + 1)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "SELECT TO_CHAR(-10000,'L99G999D99MI') \"Amount\"\n" +
                "     FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TO_CHAR(-10000, 'L99G999D99MI') \"Amount\"\n" +
                "FROM DUAL;", formatSQL);
    }
}
