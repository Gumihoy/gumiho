package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CURSOR-Expressions.html#GUID-B28362BE-8831-4687-89CF-9F77DB3698D2
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLCursorExprTest {


    @Test
    public void testSimpleCASE_0() {
        String s = "SELECT department_name, CURSOR(SELECT salary, commission_pct \n" +
                "   FROM employees e\n" +
                "   WHERE e.department_id = d.department_id)\n" +
                "   FROM departments d\n" +
                "   ORDER BY department_name;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT department_name,\n" +
                "\tCURSOR(\n" +
                "\t\tSELECT salary, commission_pct\n" +
                "\t\tFROM employees e\n" +
                "\t\tWHERE e.department_id = d.department_id\n" +
                "\t)\n" +
                "FROM departments d\n" +
                "ORDER BY department_name;", formatSQL);
    }


    @Test
    public void testSearchedCASE_1() {
        String s = "SELECT e1.last_name FROM employees e1\n" +
                "   WHERE f(\n" +
                "   CURSOR(SELECT e2.hire_date FROM employees e2\n" +
                "   WHERE e1.employee_id = e2.manager_id),\n" +
                "   e1.hire_date) = 1\n" +
                "   ORDER BY last_name;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT e1.last_name\n" +
                "FROM employees e1\n" +
                "WHERE f(CURSOR(\n" +
                "\t\tSELECT e2.hire_date\n" +
                "\t\tFROM employees e2\n" +
                "\t\tWHERE e1.employee_id = e2.manager_id\n" +
                "\t), e1.hire_date) = 1\n" +
                "ORDER BY last_name;", formatSQL);
    }
}
