package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.analytic;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLAvgFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT manager_id, last_name, hire_date, salary,\n" +
                "       AVG(salary) OVER (PARTITION BY manager_id ORDER BY hire_date \n" +
                "  ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS c_mavg,\n" +
                "    dd   "+
                "  FROM employees\n" +
                "  ORDER BY manager_id, hire_date, salary;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT manager_id, last_name, hire_date, salary,\n" +
                "\tAVG(salary) OVER (PARTITION BY manager_id ORDER BY hire_date ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS c_mavg,\n" +
                "\tdd\n" +
                "FROM employees\n" +
                "ORDER BY manager_id, hire_date, salary;", formatSQL);
    }

}
