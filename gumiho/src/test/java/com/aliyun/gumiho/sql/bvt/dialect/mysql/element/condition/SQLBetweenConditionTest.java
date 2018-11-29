package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Logical-Conditions.html#GUID-C5E48AF2-3FF9-401D-A104-CDB5FC19E65F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLBetweenConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT * FROM employees\n" +
                "  WHERE salary\n" +
                "  BETWEEN 2000 AND 3000\n" +
                "  ORDER BY employee_id;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM employees\n" +
                "WHERE salary BETWEEN 2000 AND 3000\n" +
                "ORDER BY employee_id;", format);
    }

}
