package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.analytic;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLSumFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT manager_id, last_name, salary,\n" +
                "   SUM(salary) OVER (PARTITION BY manager_id ORDER BY salary\n" +
                "   RANGE UNBOUNDED PRECEDING) l_csum\n" +
                "   FROM employees\n" +
                "   ORDER BY manager_id, last_name, salary, l_csum;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
