package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.conversion;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCastFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT CAST('22-OCT-1997'\n" +
                "       AS TIMESTAMP WITH LOCAL TIME ZONE) \n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CAST('22-OCT-1997' AS TIMESTAMP WITH LOCAL TIME ZONE)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT product_id, CAST(ad_sourcetext AS VARCHAR2(30)) text\n" +
                "  FROM print_media\n" +
                "  ORDER BY product_id;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT product_id, CAST(ad_sourcetext AS VARCHAR2(30)) text\n" +
                "FROM print_media\n" +
                "ORDER BY product_id;", formatSQL);
    }


    @Test
    public void test_2() {
        String s = "SELECT CAST(200\n" +
                "       AS NUMBER\n" +
                "       DEFAULT 0 ON CONVERSION ERROR)\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CAST(200 AS NUMBER DEFAULT 0 ON CONVERSION ERROR)\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "SELECT CAST('January 15, 1989, 11:00 A.M.'\n" +
                "       AS DATE\n" +
                "       DEFAULT NULL ON CONVERSION ERROR,\n" +
                "       'Month dd, YYYY, HH:MI A.M.')\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CAST('January 15, 1989, 11:00 A.M.' AS DATE DEFAULT NULL ON CONVERSION ERROR, 'Month dd, YYYY, HH:MI A.M.')\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_4() {
        String s = "SELECT CAST('1999-12-01 11:00:00 -8:00'\n" +
                "       AS TIMESTAMP WITH TIME ZONE\n" +
                "       DEFAULT '2000-01-01 01:00:00 -8:00' ON CONVERSION ERROR,\n" +
                "       'YYYY-MM-DD HH:MI:SS TZH:TZM',\n" +
                "       'NLS_DATE_LANGUAGE = American')\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CAST('1999-12-01 11:00:00 -8:00' AS TIMESTAMP WITH TIME ZONE DEFAULT '2000-01-01 01:00:00 -8:00' ON CONVERSION ERROR, 'YYYY-MM-DD HH:MI:SS TZH:TZM', 'NLS_DATE_LANGUAGE = American')\n" +
                "FROM DUAL;", formatSQL);
    }

    @Test
    public void test_5() {
        String s = "SELECT s.custno, s.name,\n" +
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
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT s.custno, s.name,\n" +
                "\tCAST(MULTISET(\n" +
                "\t\tSELECT ca.street_address, ca.postal_code, ca.city, ca.state_province,\n" +
                "\t\t\tca.country_id\n" +
                "\t\tFROM cust_address ca\n" +
                "\t\tWHERE s.custno = ca.custno\n" +
                "\t) AS address_book_t)\n" +
                "FROM cust_short s\n" +
                "ORDER BY s.custno;", formatSQL);
    }

    @Test
    public void test_6() {
        String s = "SELECT CAST(s.addresses AS address_book_t)\n" +
                "  FROM states s \n" +
                "  WHERE s.state_id = 111;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CAST(s.addresses AS address_book_t)\n" +
                "FROM states s\n" +
                "WHERE s.state_id = 111;", formatSQL);
    }
}
