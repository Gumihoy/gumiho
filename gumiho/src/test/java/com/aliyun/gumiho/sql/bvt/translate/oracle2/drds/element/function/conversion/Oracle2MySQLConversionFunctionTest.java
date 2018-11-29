package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.conversion;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLConversionFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ASCIISTR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT BIN_TO_NUM() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT CAST('1' as VARCHAR2(32)), CAST('1' as VARCHAR2(32 BYTE)), " +
                "  CAST('1' as NCHAR), CAST('1' as NCHAR(32)), " +
                "  CAST('1' as NVARCHAR2(32)) \n" +
                "  FROM DUAL;";

        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(sql);
        System.out.println("-----------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(sql, result.targetSql);
    }

    @Test
    public void test_4() {
        String sql = "SELECT CHARTOROWID() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT COMPOSE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT CONVERT() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT DECOMPOSE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT HEXTORAW() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_9() {
        String sql = "SELECT NUMTODSINTERVAL() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_10() {
        String sql = "SELECT NUMTOYMINTERVAL() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_11() {
        String sql = "SELECT RAWTOHEX() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_12() {
        String sql = "SELECT RAWTONHEX() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_13() {
        String sql = "SELECT ROWIDTOCHAR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_14() {
        String sql = "SELECT ROWIDTONCHAR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_15() {
        String sql = "SELECT SCN_TO_TIMESTAMP() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_16() {
        String sql = "SELECT TIMESTAMP_TO_SCN() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_17() {
        String sql = "SELECT TO_BINARY_DOUBLE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_18() {
        String sql = "SELECT TO_BINARY_FLOAT() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_19() {
        String sql = "SELECT TO_BLOB() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_20() {
        String sql = "SELECT TO_CHAR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_21() {
        String sql = "SELECT TO_CLOB() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_22() {
        String sql = "SELECT TO_DATE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_23() {
        String sql = "SELECT TO_DSINTERVAL() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_24() {
        String sql = "SELECT TO_LOB() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_25() {
        String sql = "SELECT TO_MULTI_BYTE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_26() {
        String sql = "SELECT TO_NCHAR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_27() {
        String sql = "SELECT TO_NCLOB() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_28() {
        String sql = "SELECT TO_NUMBER() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_29() {
        String sql = "SELECT TO_SINGLE_BYTE() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_30() {
        String sql = "SELECT TO_TIMESTAMP() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_31() {
        String sql = "SELECT TO_TIMESTAMP_TZ() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_32() {
        String sql = "SELECT TO_YMINTERVAL() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_33() {
        String sql = "SELECT TREAT() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_34() {
        String sql = "SELECT UNISTR() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_35() {
        String sql = "SELECT VALIDATE_CONVERSION() \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
