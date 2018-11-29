package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLROOT.html#GUID-5BD300E2-7138-436D-87AF-21658840CF9D
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlRootFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLROOT ( XMLType('<poid>143598</poid>'), VERSION '1.0', STANDALONE YES)\n" +
                "   AS \"XMLROOT\" FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLROOT(XMLType('<poid>143598</poid>'), VERSION '1.0', STANDALONE YES) AS \"XMLROOT\"\n" +
                "FROM DUAL;", formatSQL);
    }

}
