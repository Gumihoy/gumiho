package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.string;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TRANSLATE-USING.html#GUID-EC8DE4D2-4F24-456D-A2E7-AD8F82E3A148
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLTranslateUsingFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT TRANSLATE(nchar_col USING CHAR_CS) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TRANSLATE(nchar_col USING CHAR_CS)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT TRANSLATE (? USING CHAR_CS) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT TRANSLATE(? USING CHAR_CS)\n" +
                "FROM DUAL;", formatSQL);
    }

}
