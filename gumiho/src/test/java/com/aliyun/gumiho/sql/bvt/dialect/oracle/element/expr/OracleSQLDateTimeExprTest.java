package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.expr;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Datetime-Expressions.html#GUID-F72A753A-98A4-4EBD-84E9-C014CE058384
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDateTimeExprTest {


    @Test
    public void test_0() {
        String s = "SELECT FROM_TZ(CAST(TO_DATE('1999-12-01 11:00:00', \n" +
                "      'YYYY-MM-DD HH:MI:SS') AS TIMESTAMP), 'America/New_York') \n" +
                "   AT TIME ZONE 'America/Los_Angeles' \"West Coast Time\" \n" +
                "   FROM DUAL;";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT FROM_TZ(CAST(TO_DATE('1999-12-01 11:00:00', 'YYYY-MM-DD HH:MI:SS') AS TIMESTAMP), 'America/New_York') AT TIME ZONE 'America/Los_Angeles' \"West Coast Time\"\n" +
                "FROM DUAL;", formatSQL);
    }

}
