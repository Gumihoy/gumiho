package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLEXISTS.html#GUID-3D0D90DB-3D4F-4685-AFF6-72B6250624B9
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlExistsFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLEXISTS(1+2 PASSING BY VALUE 1+1 AS alias) FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLEXISTS(1 + 2 PASSING BY VALUE 1 + 1 AS alias)\n" +
                "FROM DUAL;", formatSQL);
    }

}
