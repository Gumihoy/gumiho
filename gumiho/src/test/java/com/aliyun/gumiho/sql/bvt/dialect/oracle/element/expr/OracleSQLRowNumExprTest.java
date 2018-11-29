package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLRowNumExprTest {


    @Test
    public void test_0() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE ROWNUM < 11;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE ROWNUM < 11;", format);
    }


    @Test
    public void test_1() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE ROWNUM < 11\n" +
                "  ORDER BY last_name;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE ROWNUM < 11\n" +
                "ORDER BY last_name;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT *\n" +
                "  FROM (SELECT * FROM employees ORDER BY employee_id)\n" +
                "  WHERE ROWNUM < 11;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM employees\n" +
                "\tORDER BY employee_id\n" +
                ")\n" +
                "WHERE ROWNUM < 11;", format);
    }


    @Test
    public void test_3() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE ROWNUM > 1;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE ROWNUM > 1;", format);
    }

    @Test
    public void test_4() {
        String sql = "UPDATE my_table\n" +
                "  SET column1 = ROWNUM;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE my_table\n" +
                "SET column1 = ROWNUM;", format);
    }


}
