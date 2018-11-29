package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.aggregate;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLListAggFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT LISTAGG(last_name, '; ')\n" +
                "         WITHIN GROUP (ORDER BY hire_date, last_name) \"Emp_list\",\n" +
                "       MIN(hire_date) \"Earliest\"\n" +
                "  FROM employees\n" +
                "  WHERE department_id = 30;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT LISTAGG(last_name, '; ') WITHIN GROUP (ORDER BY hire_date, last_name) \"Emp_list\",\n" +
                "\tMIN(hire_date) \"Earliest\"\n" +
                "FROM employees\n" +
                "WHERE department_id = 30;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT department_id \"Dept.\",\n" +
                "       LISTAGG(last_name, '; ') WITHIN GROUP (ORDER BY hire_date) \"Employees\"\n" +
                "  FROM employees\n" +
                "  GROUP BY department_id\n" +
                "  ORDER BY department_id;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT department_id \"Dept.\",\n" +
                "\tLISTAGG(last_name, '; ') WITHIN GROUP (ORDER BY hire_date) \"Employees\"\n" +
                "FROM employees\n" +
                "GROUP BY department_id\n" +
                "ORDER BY department_id;", formatSQL);
    }
}
