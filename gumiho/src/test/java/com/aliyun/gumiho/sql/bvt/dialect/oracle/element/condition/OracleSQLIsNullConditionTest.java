package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Null-Conditions.html#GUID-657F2BA6-5687-4A00-8C2F-57515FD2DAEB
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLIsNullConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT last_name\n" +
                "  FROM employees\n" +
                "  WHERE commission_pct\n" +
                "  IS NULL\n" +
                "  ORDER BY last_name;\n";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name\n" +
                "FROM employees\n" +
                "WHERE commission_pct IS NULL\n" +
                "ORDER BY last_name;", format);
    }


}
