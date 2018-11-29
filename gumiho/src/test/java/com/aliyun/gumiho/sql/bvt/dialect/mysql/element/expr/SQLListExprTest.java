package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.expr;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Expression-Lists.html#GUID-5CC8FC75-813B-44AA-8737-D940FA887D1E
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLListExprTest {


    @Test
    public void test_1() {
        String sql = "SELECT * FROM employees \n" +
                "  WHERE (first_name, last_name, email) IN \n" +
                "  (('Guy', 'Himuro', 'GHIMURO'),('Karen', 'Colmenares', 'KCOLMENA')) ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT department_id, MIN(salary) min, MAX(salary) max FROM employees\n" +
                "   GROUP BY (department_id, salary)\n" +
                "   ORDER BY department_id, min, max;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT \n" +
                "prod_category, prod_subcategory, country_id, cust_city, count(*)\n" +
                "   FROM  products, sales, customers\n" +
                "   WHERE sales.prod_id = products.prod_id \n" +
                "   AND sales.cust_id=customers.cust_id \n" +
                "   AND sales.time_id = '01-oct-00'\n" +
                "   AND customers.cust_year_of_birth BETWEEN 1960 and 1970\n" +
                "GROUP BY GROUPING SETS \n" +
                "  (\n" +
                "   (prod_category, prod_subcategory, country_id, cust_city),\n" +
                "   (prod_category, prod_subcategory, country_id),\n" +
                "   (prod_category, prod_subcategory),\n" +
                "    country_id\n" +
                "  )\n" +
                "ORDER BY prod_category, prod_subcategory, country_id, cust_city;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }
}
