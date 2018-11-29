package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Hierarchical-Queries.html#GUID-0118DF1D-B9A9-41EB-8556-C6E7D6A5A84E
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLHierarchicalQueryTest {


    @Test
    public void test_0() {
        String s = "SELECT employee_id, last_name, manager_id\n" +
                "   FROM employees\n" +
                "   CONNECT BY PRIOR employee_id = manager_id;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT employee_id, last_name, manager_id\n" +
                "FROM employees\n" +
                "CONNECT BY PRIOR employee_id = manager_id;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "SELECT employee_id, last_name, manager_id, LEVEL\n" +
                "   FROM employees\n" +
                "   CONNECT BY PRIOR employee_id = manager_id;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT employee_id, last_name, manager_id, LEVEL\n" +
                "FROM employees\n" +
                "CONNECT BY PRIOR employee_id = manager_id;", formatSQL);
    }

    @Test
    public void test_2() {
        String s = "SELECT last_name, employee_id, manager_id, LEVEL\n" +
                "      FROM employees\n" +
                "      START WITH employee_id = 100\n" +
                "      CONNECT BY PRIOR employee_id = manager_id\n" +
                "      ORDER SIBLINGS BY last_name;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT last_name, employee_id, manager_id, LEVEL\n" +
                "FROM employees\n" +
                "START WITH employee_id = 100\n" +
                "CONNECT BY PRIOR employee_id = manager_id\n" +
                "ORDER SIBLINGS BY last_name;", formatSQL);
    }

    @Test
    public void test_3() {
        String s = "SELECT last_name \"Employee\", \n" +
                "   LEVEL, SYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "   FROM employees\n" +
                "   WHERE level <= 3 AND department_id = 80\n" +
                "   START WITH last_name = 'King'\n" +
                "   CONNECT BY PRIOR employee_id = manager_id AND LEVEL <= 4;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT last_name \"Employee\", LEVEL,\n" +
                "\tSYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "FROM employees\n" +
                "WHERE LEVEL <= 3 AND department_id = 80\n" +
                "START WITH last_name = 'King'\n" +
                "CONNECT BY PRIOR employee_id = manager_id AND LEVEL <= 4;", formatSQL);
    }

    @Test
    public void test_4() {
        String s = "SELECT last_name \"Employee\", CONNECT_BY_ISCYCLE \"Cycle\",\n" +
                "   LEVEL, SYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "   FROM employees\n" +
                "   WHERE level <= 3 AND department_id = 80\n" +
                "   START WITH last_name = 'King'\n" +
                "   CONNECT BY NOCYCLE PRIOR employee_id = manager_id AND LEVEL <= 4\n" +
                "   ORDER BY \"Employee\", \"Cycle\", LEVEL, \"Path\";";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT last_name \"Employee\", CONNECT_BY_ISCYCLE \"Cycle\", LEVEL,\n" +
                "\tSYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "FROM employees\n" +
                "WHERE LEVEL <= 3 AND department_id = 80\n" +
                "START WITH last_name = 'King'\n" +
                "CONNECT BY NOCYCLE PRIOR employee_id = manager_id AND LEVEL <= 4\n" +
                "ORDER BY \"Employee\", \"Cycle\", LEVEL, \"Path\";", formatSQL);
    }

    @Test
    public void test_5() {
        String s = "SELECT LTRIM(SYS_CONNECT_BY_PATH (warehouse_id,','),',') FROM\n" +
                "   (SELECT ROWNUM r, warehouse_id FROM warehouses)\n" +
                "   WHERE CONNECT_BY_ISLEAF = 1\n" +
                "   START WITH r = 1\n" +
                "   CONNECT BY r = PRIOR r + 1\n" +
                "   ORDER BY warehouse_id; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals(s, formatSQL);
    }

    @Test
    public void test_6() {
        String s = "SELECT last_name \"Employee\", CONNECT_BY_ROOT last_name \"Manager\",\n" +
                "   LEVEL-1 \"Pathlen\", SYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "   FROM employees\n" +
                "   WHERE LEVEL > 1 and department_id = 110\n" +
                "   CONNECT BY PRIOR employee_id = manager_id\n" +
                "   ORDER BY \"Employee\", \"Manager\", \"Pathlen\", \"Path\";";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT last_name \"Employee\", CONNECT_BY_ROOT last_name \"Manager\",\n" +
                "\tLEVEL - 1 \"Pathlen\",\n" +
                "\tSYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "FROM employees\n" +
                "WHERE LEVEL > 1 AND department_id = 110\n" +
                "CONNECT BY PRIOR employee_id = manager_id\n" +
                "ORDER BY \"Employee\", \"Manager\", \"Pathlen\", \"Path\";", formatSQL);
    }
}
