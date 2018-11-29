package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Logical-Conditions.html#GUID-C5E48AF2-3FF9-401D-A104-CDB5FC19E65F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLInConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT * FROM employees\n" +
                "  WHERE job_id IN\n" +
                "  ('PU_CLERK','SH_CLERK')\n" +
                "  ORDER BY employee_id;\n" ;

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE job_id IN ('PU_CLERK', 'SH_CLERK')\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT * FROM employees\n" +
                "  WHERE salary IN\n" +
                "  (SELECT salary \n" +
                "   FROM employees\n" +
                "   WHERE department_id =30)\n" +
                "  ORDER BY employee_id;" ;

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE salary IN (\n" +
                "\t\tSELECT salary\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE department_id = 30\n" +
                "\t)\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT * FROM employees\n" +
                "  WHERE salary NOT IN\n" +
                "  (SELECT salary \n" +
                "   FROM employees\n" +
                "  WHERE department_id = 30)\n" +
                "  ORDER BY employee_id;\n" +
                "SELECT * FROM employees\n" +
                "  WHERE job_id NOT IN\n" +
                "  ('PU_CLERK', 'SH_CLERK')\n" +
                "  ORDER BY employee_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE salary NOT IN (\n" +
                "\t\tSELECT salary\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE department_id = 30\n" +
                "\t)\n" +
                "ORDER BY employee_id;\n" +
                "SELECT *\n" +
                "FROM employees\n" +
                "WHERE job_id NOT IN ('PU_CLERK', 'SH_CLERK')\n" +
                "ORDER BY employee_id;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT employee_id, last_name FROM employees\n" +
                "   WHERE (employee_id, LEVEL) \n" +
                "      IN (SELECT employee_id, 2 FROM employees)\n" +
                "   START WITH employee_id = 2\n" +
                "   CONNECT BY PRIOR employee_id = manager_id;\n";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name\n" +
                "FROM employees\n" +
                "WHERE (employee_id, LEVEL) IN (\n" +
                "\t\tSELECT employee_id, 2\n" +
                "\t\tFROM employees\n" +
                "\t)\n" +
                "START WITH employee_id = 2\n" +
                "CONNECT BY PRIOR employee_id = manager_id;", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT v.employee_id, v.last_name, v.lev FROM\n" +
                "      (SELECT employee_id, last_name, LEVEL lev \n" +
                "      FROM employees v\n" +
                "      START WITH employee_id = 100 \n" +
                "      CONNECT BY PRIOR employee_id = manager_id) v \n" +
                "   WHERE (v.employee_id, v.lev) IN\n" +
                "      (SELECT employee_id, 2 FROM employees); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT v.employee_id, v.last_name, v.lev\n" +
                "FROM (\n" +
                "\tSELECT employee_id, last_name, LEVEL lev\n" +
                "\tFROM employees v\n" +
                "\tSTART WITH employee_id = 100\n" +
                "\tCONNECT BY PRIOR employee_id = manager_id\n" +
                ") v\n" +
                "WHERE (v.employee_id, v.lev) IN (\n" +
                "\t\tSELECT employee_id, 2\n" +
                "\t\tFROM employees\n" +
                "\t);", format);
    }
}
