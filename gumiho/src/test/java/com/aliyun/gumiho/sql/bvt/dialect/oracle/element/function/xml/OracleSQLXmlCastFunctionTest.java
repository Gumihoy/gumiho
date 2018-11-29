package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLTABLE.html
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlCastFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLCAST(\"Warehouse\" as VARCHAR2) FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLCAST(\"Warehouse\" AS VARCHAR2)\n" +
                "FROM DUAL;", formatSQL);
    }

}
