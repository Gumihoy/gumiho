package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.analytic;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLFirstFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT last_name, department_id, salary,\n" +
                "       MIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct)\n" +
                "         OVER (PARTITION BY department_id) \"Worst\",\n" +
                "       MAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct)\n" +
                "         OVER (PARTITION BY department_id) \"Best\"\n" +
                "   FROM employees\n" +
                "   ORDER BY department_id, salary, last_name;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT last_name, department_id, salary,\n" +
                "\tMIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct) OVER (PARTITION BY department_id) \"Worst\",\n" +
                "\tMAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct) OVER (PARTITION BY department_id) \"Best\"\n" +
                "FROM employees\n" +
                "ORDER BY department_id, salary, last_name;", formatSQL);
    }

}
