package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.analytic;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLSumFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT manager_id, last_name, salary,\n" +
                "   SUM(salary) OVER (PARTITION BY manager_id ORDER BY salary\n" +
                "   RANGE UNBOUNDED PRECEDING) l_csum\n" +
                "   FROM employees\n" +
                "   ORDER BY manager_id, last_name, salary, l_csum;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT manager_id, last_name, salary,\n" +
                "\tSUM(salary) OVER (PARTITION BY manager_id ORDER BY salary RANGE UNBOUNDED PRECEDING) l_csum\n" +
                "FROM employees\n" +
                "ORDER BY manager_id, last_name, salary, l_csum;", formatSQL);
    }

}
