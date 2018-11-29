package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLSERIALIZE.html#GUID-F2D5ECE7-3838-4DD5-BE8F-2AEE7890AA1C
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlSerializeFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLSERIALIZE(CONTENT XMLTYPE('<Owner>Grandco</Owner>')) AS xmlserialize_doc\n" +
                "   FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLSERIALIZE(CONTENT XMLTYPE('<Owner>Grandco</Owner>')) AS xmlserialize_doc\n" +
                "FROM DUAL;", formatSQL);
    }

}
