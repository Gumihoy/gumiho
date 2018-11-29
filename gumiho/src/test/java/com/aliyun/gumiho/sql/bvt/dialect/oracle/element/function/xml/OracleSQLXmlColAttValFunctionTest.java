package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLCOLATTVAL.html#GUID-AE3B6441-74D8-4033-900B-A578A79E5F0A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlColAttValFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLELEMENT(\"Emp\",\n" +
                "   XMLCOLATTVAL(e.employee_id, e.last_name, e.salary)) \"Emp Element\"\n" +
                "   FROM employees e\n" +
                "   WHERE employee_id = 204;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLELEMENT(\"Emp\", XMLCOLATTVAL(e.employee_id, e.last_name, e.salary)) \"Emp Element\"\n" +
                "FROM employees e\n" +
                "WHERE employee_id = 204;", formatSQL);
    }


}
