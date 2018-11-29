package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLFOREST.html#GUID-68E5C67E-CE97-4BF8-B7FF-2365E062C363
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlForestFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLELEMENT(\"Emp\", \n" +
                "   XMLFOREST(e.employee_id, e.last_name, e.salary))\n" +
                "   \"Emp Element\"\n" +
                "   FROM employees e WHERE employee_id = 204;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLELEMENT(\"Emp\", XMLFOREST(e.employee_id, e.last_name, e.salary)) \"Emp Element\"\n" +
                "FROM employees e\n" +
                "WHERE employee_id = 204;", formatSQL);
    }

}
