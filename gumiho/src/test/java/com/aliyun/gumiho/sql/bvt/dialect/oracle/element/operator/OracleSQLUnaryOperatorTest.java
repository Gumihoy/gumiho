package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.operator;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLUnaryOperatorTest {


    @Test
    public void test_1() {
        String sql = "SELECT -4, -(-4), +4, CONNECT_BY_ROOT last_name, COLLATE name FROM DUAL;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT -4, -(-4), +4, CONNECT_BY_ROOT last_name, COLLATE name\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT last_name \"Employee\", CONNECT_BY_ROOT last_name \"Manager\",\n" +
                "   LEVEL-1 \"Pathlen\", SYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "   FROM employees\n" +
                "   WHERE LEVEL > 1 and department_id = 110\n" +
                "   CONNECT BY PRIOR employee_id = manager_id\n" +
                "   ORDER BY \"Employee\", \"Manager\", \"Pathlen\", \"Path\";";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name \"Employee\", CONNECT_BY_ROOT last_name \"Manager\",\n" +
                "\tLEVEL - 1 \"Pathlen\",\n" +
                "\tSYS_CONNECT_BY_PATH(last_name, '/') \"Path\"\n" +
                "FROM employees\n" +
                "WHERE LEVEL > 1 AND department_id = 110\n" +
                "CONNECT BY PRIOR employee_id = manager_id\n" +
                "ORDER BY \"Employee\", \"Manager\", \"Pathlen\", \"Path\";", format);
    }
}
