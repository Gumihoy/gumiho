package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLPI.html#GUID-142604E3-7999-4803-9DF5-28BDC0701571
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlPiFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLPI(NAME \"Order analysisComp\", 'imported, reconfigured, disassembled')\n" +
                "   AS \"XMLPI\" FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLPI(NAME \"Order analysisComp\", 'imported, reconfigured, disassembled') AS \"XMLPI\"\n" +
                "FROM DUAL;", formatSQL);
    }

}