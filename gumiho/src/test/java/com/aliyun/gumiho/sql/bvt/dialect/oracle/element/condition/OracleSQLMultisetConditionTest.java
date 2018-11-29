package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Multiset-Conditions.html#GUID-E8164A15-715A-40A0-944D-26DF4C84DE3F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLMultisetConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  FROM customers_demo\n" +
                "  WHERE cust_address_ntab IS A SET\n" +
                "  ORDER BY customer_id;\n";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id, cust_address_ntab\n" +
                "FROM customers_demo\n" +
                "WHERE cust_address_ntab IS A SET\n" +
                "ORDER BY customer_id;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT product_id, TO_CHAR(ad_finaltext) AS text\n" +
                "   FROM print_media\n" +
                "   WHERE ad_textdocs_ntab IS NOT EMPTY \n" +
                "   ORDER BY product_id, text;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT product_id, TO_CHAR(ad_finaltext) AS text\n" +
                "FROM print_media\n" +
                "WHERE ad_textdocs_ntab IS NOT EMPTY\n" +
                "ORDER BY product_id, text;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  FROM customers_demo\n" +
                "  WHERE cust_address_typ('8768 N State Rd 37', 47404, \n" +
                "                         'Bloomington', 'IN', 'US')\n" +
                "  MEMBER OF cust_address_ntab\n" +
                "  ORDER BY customer_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id, cust_address_ntab\n" +
                "FROM customers_demo\n" +
                "WHERE cust_address_typ('8768 N State Rd 37', 47404, 'Bloomington', 'IN', 'US') MEMBER OF cust_address_ntab\n" +
                "ORDER BY customer_id;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  FROM customers_demo\n" +
                "  WHERE cust_address_ntab SUBMULTISET OF cust_address2_ntab\n" +
                "  ORDER BY customer_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id, cust_address_ntab\n" +
                "FROM customers_demo\n" +
                "WHERE cust_address_ntab SUBMULTISET OF cust_address2_ntab\n" +
                "ORDER BY customer_id;", format);
    }
}
