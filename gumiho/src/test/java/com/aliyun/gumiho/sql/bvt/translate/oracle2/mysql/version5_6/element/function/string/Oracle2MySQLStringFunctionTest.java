package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.string;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CHR.html#GUID-35FEE007-D49C-4562-A904-041186AC8928
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLStringFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT CHR(67), CHR(196 USING NCHAR_CS) \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_2() {
        String sql = "select CONCAT('ab', 'BC') from dual; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT INITCAP('aA')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT LOWER('MR. SCOTT MCMILLAN')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT LPAD('Page 1',15), LPAD('Page 1',15,'*.')" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT LTRIM('<=====>BROWNING<=====>'), LTRIM('<=====>BROWNING<=====>', '<>=')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT NCHR(187)\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT NLS_INITCAP()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_9() {
        String sql = "SELECT NLS_LOWER()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_10() {
        String sql = "SELECT NLS_UPPER()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_11() {
        String sql = "SELECT NLSSORT()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_12() {
        String sql = "SELECT REGEXP_REPLACE()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_13() {
        String sql = "SELECT REGEXP_SUBSTR()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_14() {
        String sql = "SELECT REPLACE('JACK and JUE','J'), REPLACE('JACK and JUE','J','BL')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_16() {
        String sql = "SELECT RPAD(' ', 10), RPAD(' ', 10, '*')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_17() {
        String sql = "SELECT RTRIM('<=====>BROWNING<=====>', '<>='), RTRIM('<=====>BROWNING<=====>')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_18() {
        String sql = "SELECT SOUNDEX()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_19() {
        String sql = "SELECT SUBSTR()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_20() {
        String sql = "SELECT TRANSLATE()\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_21() {
        String sql = "SELECT TRANSLATE('1' USING CHAR_CS)\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_22() {
        String sql = "SELECT TRIM('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_23() {
        String sql = "SELECT UPPER('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_24() {
        String sql = "SELECT ASCII('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_25() {
        String sql = "SELECT INSTR('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_26() {
        String sql = "SELECT LENGTH('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_27() {
        String sql = "SELECT REGEXP_COUNT('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_28() {
        String sql = "SELECT REGEXP_INSTR('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }

    @Test
    public void test_29() {
        String sql = "SELECT NLS_CHARSET_DECL_LEN('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_30() {
        String sql = "SELECT NLS_CHARSET_ID('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }
    @Test
    public void test_31() {
        String sql = "SELECT NLS_CHARSET_NAME('1 ')\n" +
                "  FROM DUAL; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", format);
    }



}
