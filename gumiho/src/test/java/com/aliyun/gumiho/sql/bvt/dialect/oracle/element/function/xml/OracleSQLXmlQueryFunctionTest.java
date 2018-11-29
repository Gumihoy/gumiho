package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLQUERY.html#GUID-9E8D3220-2CF5-4C63-BDC2-0526D57B9CDB
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlQueryFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT warehouse_name,\n" +
                "EXTRACTVALUE(warehouse_spec, '/Warehouse/Area'),\n" +
                "XMLQuery(\n" +
                "   'for $i in /Warehouse\n" +
                "   where $i/Area > 50000\n" +
                "   return <Details>\n" +
                "             <Docks num=\"{$i/Docks}\"/>\n" +
                "             <Rail>\n" +
                "               {\n" +
                "               if ($i/RailAccess = \"Y\") then \"true\" else \"false\"\n" +
                "               }\n" +
                "             </Rail>\n" +
                "          </Details>' PASSING warehouse_spec RETURNING CONTENT) \"Big_warehouses\"\n" +
                "   FROM warehouses;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT warehouse_name,\n" +
                "\tEXTRACTVALUE(warehouse_spec, '/Warehouse/Area'),\n" +
                "\tXMLQUERY('for $i in /Warehouse\n" +
                "   where $i/Area > 50000\n" +
                "   return <Details>\n" +
                "             <Docks num=\"{$i/Docks}\"/>\n" +
                "             <Rail>\n" +
                "               {\n" +
                "               if ($i/RailAccess = \"Y\") then \"true\" else \"false\"\n" +
                "               }\n" +
                "             </Rail>\n" +
                "          </Details>' PASSING warehouse_spec RETURNING CONTENT) \"Big_warehouses\"\n" +
                "FROM warehouses;", formatSQL);
    }

}
