package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.xml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLELEMENT.html#GUID-DEA75423-00EA-4034-A246-4A774ADC988E
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLXmlElementFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT XMLELEMENT(\"Emp\", XMLELEMENT(\"Name\", \n" +
                "   e.job_id||' '||e.last_name),\n" +
                "   XMLELEMENT(\"Hiredate\", e.hire_date)) as \"Result\"\n" +
                "   FROM employees e WHERE employee_id > 200;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT XMLELEMENT(\"Emp\", XMLELEMENT(\"Name\", e.job_id || ' ' || e.last_name), XMLELEMENT(\"Hiredate\", e.hire_date)) AS \"Result\"\n" +
                "FROM employees e\n" +
                "WHERE employee_id > 200;", formatSQL);
    }


}
