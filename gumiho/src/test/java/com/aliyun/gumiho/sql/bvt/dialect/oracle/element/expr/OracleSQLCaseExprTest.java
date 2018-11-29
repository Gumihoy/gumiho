package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLCaseExprTest {


    @Test
    public void testSimpleCASE_1() {
        String sql = "SELECT cust_last_name,\n" +
                "   CASE credit_limit WHEN 100 THEN 'Low'\n" +
                "   WHEN 5000 THEN 'High'\n" +
                "   ELSE 'Medium' END AS credit\n" +
                "   FROM customers\n" +
                "   ORDER BY cust_last_name, credit; ";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT cust_last_name,\n" +
                "\tCASE credit_limit\n" +
                "\t\tWHEN 100 THEN 'Low'\n" +
                "\t\tWHEN 5000 THEN 'High'\n" +
                "\t\tELSE 'Medium'\n" +
                "\tEND AS credit\n" +
                "FROM customers\n" +
                "ORDER BY cust_last_name, credit;", format);
    }


    @Test
    public void testSearchedCASE_2() {
        String sql = "SELECT AVG(CASE WHEN e.salary > 2000 THEN e.salary\n" +
                "   ELSE 2000 END) \"Average Salary\" FROM employees e;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT AVG(CASE\n" +
                "\t\tWHEN e.salary > 2000 THEN e.salary\n" +
                "\t\tELSE 2000\n" +
                "\tEND) \"Average Salary\"\n" +
                "FROM employees e;", format);
    }

    @Test
    public void test3() {
        String sql = "SELECT CASE \n" +
                "WHEN New_porqty THEN New_porqty - Gross_Qty\n" +
                "ELSE 0 \n" +
                "END AS Add_porqty " +
                " FROM Mrp_Net_Balance_For_Pur_Tp Pur";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CASE\n" +
                "\t\tWHEN New_porqty THEN New_porqty - Gross_Qty\n" +
                "\t\tELSE 0\n" +
                "\tEND AS Add_porqty\n" +
                "FROM Mrp_Net_Balance_For_Pur_Tp Pur", format);
    }


}
