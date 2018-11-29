package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Floating-Point-Conditions.html#GUID-D7707649-2C93-4553-BF78-F461F17A634E
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLFloatingPointConditionTest {


    @Test
    public void test_1() {
        String sql = "SELECT COUNT(*) FROM employees\n" +
                "  WHERE commission_pct IS NOT NAN;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT COUNT(*)\n" +
                "FROM employees\n" +
                "WHERE commission_pct IS NOT NAN;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT last_name FROM employees\n" +
                "  WHERE salary IS NOT INFINITE;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name\n" +
                "FROM employees\n" +
                "WHERE salary IS NOT INFINITE;", format);
    }
}
