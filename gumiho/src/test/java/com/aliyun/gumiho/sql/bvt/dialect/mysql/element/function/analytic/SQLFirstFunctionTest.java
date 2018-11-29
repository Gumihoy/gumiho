package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.analytic;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLFirstFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT last_name, department_id, salary,\n" +
                "       MIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct)\n" +
                "         OVER (PARTITION BY department_id) \"Worst\",\n" +
                "       MAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct)\n" +
                "         OVER (PARTITION BY department_id) \"Best\"\n" +
                "   FROM employees\n" +
                "   ORDER BY department_id, salary, last_name;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
