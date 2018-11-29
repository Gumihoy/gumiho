package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/IS-OF-type-Condition.html#GUID-7254E4C7-0194-4C1F-A3B2-2CFB0AD907CD
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLIsOfTypeConditionTest {

    @Test
    public void test_1() {
        String sql = "SELECT * FROM persons p \n" +
                "   WHERE VALUE(p) IS OF TYPE (employee_t);";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT *\n" +
                "FROM persons p\n" +
                "WHERE VALUE(p) IS OF TYPE (employee_t);", format);
    }


}
