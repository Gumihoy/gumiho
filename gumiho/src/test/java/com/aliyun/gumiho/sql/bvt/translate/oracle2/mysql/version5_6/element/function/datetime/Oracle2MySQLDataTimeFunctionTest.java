package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.datetime;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLDataTimeFunctionTest {

    @Test
    public void test_ADD_MONTHS_0() {
        String sql = "SELECT ADD_MONTHS(hire_date, 1) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT TIMESTAMPADD(MONTH, 1, `hire_date`)\n" +
                "FROM `DUAL`", result.targetSql);
    }

    @Test
    public void test_CURRENT_DATE_1() {
        String sql = "SELECT CURRENT_DATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CURRENT_DATE\n" +
                "FROM `DUAL`", result.targetSql);
    }

    @Test
    public void test_CURRENT_TIMESTAMP_2() {
        String sql = "SELECT CURRENT_TIMESTAMP, CURRENT_TIMESTAMP(0), CURRENT_TIMESTAMP(6) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CURRENT_DATE\n" +
                "FROM `DUAL`", result.targetSql);
    }

    @Test
    public void test_DBTIMEZONE_3() {
        String sql = "SELECT DBTIMEZONE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CURRENT_DATE\n" +
                "FROM `DUAL`", result.targetSql);
    }

    @Test
    public void test_EXTRACT_4() {
        String sql = "SELECT EXTRACT(year FROM sysdate), EXTRACT(month FROM sysdate), " +
                " EXTRACT(day FROM sysdate), EXTRACT(HOUR FROM sysdate)," +
                " EXTRACT(MINUTE FROM sysdate), EXTRACT(SECOND FROM sysdate)," +
                " EXTRACT(TIMEZONE_HOUR FROM sysdate), EXTRACT(TIMEZONE_MINUTE FROM sysdate)," +
                " EXTRACT(TIMEZONE_REGION FROM sysdate), EXTRACT(TIMEZONE_ABBR FROM sysdate) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_FROM_TZ_5() {
        String sql = "SELECT FROM_TZ(TIMESTAMP '2000-03-28 08:00:00', '3:00') FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_LAST_DAY_6() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_LOCALTIMESTAMP_7() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_MONTHS_BETWEEN_8() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_NEW_TIME_9() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_NEXT_DAY_10() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_NUMTODSINTERVAL_11() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_NUMTOYMINTERVAL_12() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_ORA_DST_AFFECTED_13() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_ORA_DST_CONVERT_14() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_ORA_DST_ERROR_15() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_ROUND_16() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_SESSIONTIMEZONE_17() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_SYS_EXTRACT_UTC_18() {
        String sql = "SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_SYSDATE_19() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_SYSTIMESTAMP_20() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TO_CHAR_21() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TO_DSINTERVAL_22() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TO_TIMESTAMP_23() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TO_TIMESTAMP_TZ_24() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TO_YMINTERVAL_25() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TRUNC_26() {
        String sql = "SELECT SYSDATE FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_TZ_OFFSET_27() {
        String sql = "SELECT TZ_OFFSET('US/Eastern'), TZ_OFFSET(SESSIONTIMEZONE), " +
                " TZ_OFFSET(DBTIMEZONE) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
}
