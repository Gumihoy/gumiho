package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/EXISTS-Condition.html#GUID-20259A83-C42B-4E0D-8DF4-9A2A66ACA8E7
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLExistsConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT department_id\n" +
                "  FROM departments d\n" +
                "  WHERE EXISTS\n" +
                "  (SELECT * FROM employees e\n" +
                "    WHERE d.department_id \n" +
                "    = e.department_id)\n" +
                "   ORDER BY department_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT department_id\n" +
                "FROM departments d\n" +
                "WHERE EXISTS (\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM employees e\n" +
                "\t\tWHERE d.department_id = e.department_id\n" +
                "\t)\n" +
                "ORDER BY department_id;", format);
    }

}
