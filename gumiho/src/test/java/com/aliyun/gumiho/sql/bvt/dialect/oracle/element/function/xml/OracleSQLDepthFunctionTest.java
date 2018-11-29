package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLDepthFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT PATH(1), DEPTH(2)\n" +
                "  FROM RESOURCE_VIEW\n" +
                "  WHERE UNDER_PATH(res, '/sys/schemas/OE', 1)=1\n" +
                "    AND UNDER_PATH(res, '/sys/schemas/OE', 2)=1; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT PATH(1), DEPTH(2)\n" +
                "FROM RESOURCE_VIEW\n" +
                "WHERE UNDER_PATH(res, '/sys/schemas/OE', 1) = 1\n" +
                "\tAND UNDER_PATH(res, '/sys/schemas/OE', 2) = 1;", formatSQL);
    }

}
