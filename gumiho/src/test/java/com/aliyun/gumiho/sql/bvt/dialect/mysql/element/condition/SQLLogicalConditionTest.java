package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Logical-Conditions.html#GUID-C5E48AF2-3FF9-401D-A104-CDB5FC19E65F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLLogicalConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE NOT (job_id IS NULL)\n" +
                "  ORDER BY employee_id;\n";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE NOT (job_id IS NULL)\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE NOT \n" +
                "  (salary BETWEEN 1000 AND 2000)\n" +
                "  ORDER BY employee_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE NOT (salary BETWEEN 1000 AND 2000)\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE job_id = 'PU_CLERK'\n" +
                "  AND department_id = 30\n" +
                "  ORDER BY employee_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE job_id = 'PU_CLERK' AND department_id = 30\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE job_id = 'PU_CLERK'\n" +
                "  OR department_id = 10\n" +
                "  ORDER BY employee_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE job_id = 'PU_CLERK' OR department_id = 10\n" +
                "ORDER BY employee_id;", format);
    }
}
