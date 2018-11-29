package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.aggregate;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLListAggFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT LISTAGG(last_name, '; ')\n" +
                "         WITHIN GROUP (ORDER BY hire_date, last_name) \"Emp_list\",\n" +
                "       MIN(hire_date) \"Earliest\"\n" +
                "  FROM employees\n" +
                "  WHERE department_id = 30;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT department_id \"Dept.\",\n" +
                "       LISTAGG(last_name, '; ') WITHIN GROUP (ORDER BY hire_date) \"Employees\"\n" +
                "  FROM employees\n" +
                "  GROUP BY department_id\n" +
                "  ORDER BY department_id;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
