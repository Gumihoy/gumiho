package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pattern-matching-Conditions.html#GUID-3FA7F5AB-AC64-4200-8F90-294101428C26
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class OracleSQLLikeConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT salary \n" +
                "    FROM employees\n" +
                "    WHERE last_name LIKE 'R%'\n" +
                "    ORDER BY salary;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT salary\n" +
                "FROM employees\n" +
                "WHERE last_name LIKE 'R%'\n" +
                "ORDER BY salary;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT salary \n" +
                "    FROM employees \n" +
                "    WHERE 'SM%' LIKE last_name\n" +
                "    ORDER BY salary;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT salary\n" +
                "FROM employees\n" +
                "WHERE 'SM%' LIKE last_name\n" +
                "ORDER BY salary;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT salary \n" +
                "    FROM employees \n" +
                "    WHERE last_name LIKE 'SMITH_'\n" +
                "    ORDER BY salary;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT salary\n" +
                "FROM employees\n" +
                "WHERE last_name LIKE 'SMITH_'\n" +
                "ORDER BY salary;", format);
    }
}
