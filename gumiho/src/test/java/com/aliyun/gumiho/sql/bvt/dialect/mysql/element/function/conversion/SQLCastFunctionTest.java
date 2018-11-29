package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.conversion;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCastFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT CAST('22-OCT-1997'\n" +
                "       AS TIMESTAMP WITH LOCAL TIME ZONE) \n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT product_id, CAST(ad_sourcetext AS VARCHAR2(30)) text\n" +
                "  FROM print_media\n" +
                "  ORDER BY product_id;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_3() {
        String sql = "SELECT CAST(200\n" +
                "       AS NUMBER\n" +
                "       DEFAULT 0 ON CONVERSION ERROR)\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT CAST('January 15, 1989, 11:00 A.M.'\n" +
                "       AS DATE\n" +
                "       DEFAULT NULL ON CONVERSION ERROR,\n" +
                "       'Month dd, YYYY, HH:MI A.M.')\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT CAST('1999-12-01 11:00:00 -8:00'\n" +
                "       AS TIMESTAMP WITH TIME ZONE\n" +
                "       DEFAULT '2000-01-01 01:00:00 -8:00' ON CONVERSION ERROR,\n" +
                "       'YYYY-MM-DD HH:MI:SS TZH:TZM',\n" +
                "       'NLS_DATE_LANGUAGE = American')\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT s.custno, s.name,\n" +
                "       CAST(MULTISET(SELECT ca.street_address,   \n" +
                "                            ca.postal_code, \n" +
                "                            ca.city, \n" +
                "                            ca.state_province, \n" +
                "                            ca.country_id\n" +
                "                       FROM cust_address ca\n" +
                "                       WHERE s.custno = ca.custno)\n" +
                "       AS address_book_t)\n" +
                "  FROM cust_short s\n" +
                "  ORDER BY s.custno;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT CAST(s.addresses AS address_book_t)\n" +
                "  FROM states s \n" +
                "  WHERE s.state_id = 111;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
