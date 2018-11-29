package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datetime;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLExtractFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT EXTRACT(month FROM order_date) \"Month\", COUNT(order_date) \"No. of Orders\"\n" +
                "  FROM orders\n" +
                "  GROUP BY EXTRACT(month FROM order_date)\n" +
                "  ORDER BY \"No. of Orders\" DESC, \"Month\";";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("SELECT EXTRACT(MONTH FROM order_date) \"Month\",\n" +
                "\tCOUNT(order_date) \"No. of Orders\"\n" +
                "FROM orders\n" +
                "GROUP BY EXTRACT(MONTH FROM order_date)\n" +
                "ORDER BY \"No. of Orders\" DESC, \"Month\";", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT last_name, employee_id, hire_date\n" +
                "  FROM employees\n" +
                "  WHERE EXTRACT(YEAR FROM TO_DATE(hire_date, 'DD-MON-RR')) > 2007";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name, employee_id, hire_date\n" +
                "FROM employees\n" +
                "WHERE EXTRACT(YEAR FROM TO_DATE(hire_date, 'DD-MON-RR')) > 2007", format);
    }
}
