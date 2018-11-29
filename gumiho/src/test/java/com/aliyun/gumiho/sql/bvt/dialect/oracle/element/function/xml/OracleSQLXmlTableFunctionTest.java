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
public class OracleSQLXmlTableFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLTABLE('/Warehouse'\n" +
                "      PASSING warehouses.warehouse_spec\n" +
                "      COLUMNS \n" +
                "         \"Water\" varchar2(6) PATH 'WaterAccess',\n" +
                "         \"Rail\" varchar2(6) PATH 'RailAccess') FROM DUAL; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLTABLE('/Warehouse' PASSING warehouses.warehouse_spec COLUMNS \"Water\" VARCHAR2(6) PATH 'WaterAccess', \"Rail\" VARCHAR2(6) PATH 'RailAccess')\n" +
                "FROM DUAL;", formatSQL);
    }

}
