package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.analytic;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLAvgFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT manager_id, last_name, hire_date, salary,\n" +
                "       AVG(salary) OVER (PARTITION BY manager_id ORDER BY hire_date \n" +
                "  ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS c_mavg,\n" +
                "    dd   "+
                "  FROM employees\n" +
                "  ORDER BY manager_id, hire_date, salary;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
