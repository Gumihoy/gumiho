package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Expression-Lists.html#GUID-5CC8FC75-813B-44AA-8737-D940FA887D1E
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLListExprTest {


    @Test
    public void test_0() {
        String s = "SELECT * FROM employees \n" +
                "  WHERE (first_name, last_name, email) IN \n" +
                "  (('Guy', 'Himuro', 'GHIMURO'),('Karen', 'Colmenares', 'KCOLMENA')) ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE (first_name, last_name, email) IN (('Guy', 'Himuro', 'GHIMURO'), ('Karen', 'Colmenares', 'KCOLMENA'))", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "SELECT department_id, MIN(salary) min, MAX(salary) max FROM employees\n" +
                "   GROUP BY (department_id, salary)\n" +
                "   ORDER BY department_id, min, max;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT department_id, MIN(salary) min, MAX(salary) max\n" +
                "FROM employees\n" +
                "GROUP BY (department_id, salary)\n" +
                "ORDER BY department_id, min, max;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "SELECT \n" +
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
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT prod_category, prod_subcategory, country_id, cust_city, count(*)\n" +
                "FROM products, sales, customers\n" +
                "WHERE sales.prod_id = products.prod_id\n" +
                "\tAND sales.cust_id = customers.cust_id AND sales.time_id = '01-oct-00'\n" +
                "\tAND customers.cust_year_of_birth BETWEEN 1960 AND 1970\n" +
                "GROUP BY GROUPING SETS (\n" +
                "\t(prod_category, prod_subcategory, country_id, cust_city),\n" +
                "\t(prod_category, prod_subcategory, country_id),\n" +
                "\t(prod_category, prod_subcategory),\n" +
                "\tcountry_id\n" +
                ")\n" +
                "ORDER BY prod_category, prod_subcategory, country_id, cust_city;", formatSQL);
    }
}
