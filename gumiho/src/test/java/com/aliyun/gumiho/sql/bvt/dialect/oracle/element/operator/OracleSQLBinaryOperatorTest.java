package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.operator;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLBinaryOperatorTest {


    @Test
    public void test_1() {
        String sql = "SELECT 1+(-3) FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 + (-3)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT -1+(-3) FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT -1 + (-3)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT 1-1+(-3) * 4 / 5 FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 - 1 + (-3) * 4 / 5\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT 'Name is ' || last_name FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'Name is ' || last_name\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_5() {
        String sql = "SELECT last_name\n" +
                "  FROM employees\n" +
                "  ORDER BY last_name COLLATE GENERIC_M;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name\n" +
                "FROM employees\n" +
                "ORDER BY last_name COLLATE GENERIC_M;", format);
    }


    @Test
    public void test_6() {
        String sql = "SELECT * from dual UNION SELECT * from dual";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "UNION\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }


    @Test
    public void test_7() {
        String sql = "SELECT * from dual UNION ALL SELECT * from dual";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "UNION ALL\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT * from dual INTERSECT SELECT * from dual";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "INTERSECT\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }

    @Test
    public void test_9() {
        String sql = "SELECT * from dual MINUS SELECT * from dual";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM dual\n" +
                "MINUS\n" +
                "SELECT *\n" +
                "FROM dual", format);
    }

    @Test
    public void test_10() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  MULTISET EXCEPT DISTINCT cust_address2_ntab multiset_except\n" +
                "  FROM customers_demo\n" +
                "  ORDER BY customer_id;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id,\n" +
                "\tcust_address_ntab MULTISET EXCEPT DISTINCT cust_address2_ntab multiset_except\n" +
                "FROM customers_demo\n" +
                "ORDER BY customer_id;", format);
    }

    @Test
    public void test_11() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  MULTISET INTERSECT DISTINCT cust_address2_ntab multiset_intersect\n" +
                "  FROM customers_demo\n" +
                "  ORDER BY customer_id;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id,\n" +
                "\tcust_address_ntab MULTISET INTERSECT DISTINCT cust_address2_ntab multiset_intersect\n" +
                "FROM customers_demo\n" +
                "ORDER BY customer_id;", format);
    }

    @Test
    public void test_12() {
        String sql = "SELECT customer_id, cust_address_ntab\n" +
                "  MULTISET UNION cust_address2_ntab multiset_union\n" +
                "  FROM customers_demo\n" +
                "  ORDER BY customer_id;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT customer_id,\n" +
                "\tcust_address_ntab MULTISET UNION cust_address2_ntab multiset_union\n" +
                "FROM customers_demo\n" +
                "ORDER BY customer_id;", format);
    }

    @Test
    public void test_13() {
        // '!='| '<>'| '^='| '~=';
        String sql = "SELECT 1 | | 1 FROM DUAL where 1=1 and 1> 1 and 1< 1 and 1 ! = 1 and 1< >1 and 1 ^ = 1 and 1 ~ = 1and 2 > = 1 and 1 < = 1 ;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 1 || 1\n" +
                "FROM DUAL\n" +
                "WHERE 1 = 1 AND 1 > 1 AND 1 < 1 AND 1 != 1 AND 1 <> 1 AND 1 ^= 1 AND 1 ~= 1 AND 2 >= 1 AND 1 <= 1;", format);
    }
}
