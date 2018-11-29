package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.model;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CV.html#GUID-32E56E9C-4F59-486E-8E4C-F332284C5EA7
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCvFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT country, prod, year, s\n" +
                "  FROM sales_view_ref\n" +
                "  MODEL\n" +
                "    PARTITION BY (country)\n" +
                "    DIMENSION BY (prod, year)\n" +
                "    MEASURES (sale s)\n" +
                "    IGNORE NAV\n" +
                "    UNIQUE DIMENSION\n" +
                "    RULES UPSERT SEQUENTIAL ORDER\n" +
                "    (\n" +
                "      s[FOR prod IN ('Mouse Pad', 'Standard Mouse'), 2001] =\n" +
                "        s[CV( ), 1999] + s[CV( ), 2000]\n" +
                "    )\n" +
                "  ORDER BY country, prod, year;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT country, prod, year, s\n" +
                "FROM sales_view_ref\n" +
                "MODEL\n" +
                "\tPARTITION BY (country)\n" +
                "\tDIMENSION BY (prod, year)\n" +
                "\tMEASURES (sale s)\n" +
                "\tIGNORE NAV UNIQUE DIMENSION\n" +
                "\tRULES UPSERT SEQUENTIAL ORDER (\n" +
                "\t\ts[FOR prod IN ('Mouse Pad', 'Standard Mouse'), 2001] = s[CV(), 1999] + s[CV(), 2000]\n" +
                "\t)\n" +
                "ORDER BY country, prod, year;", formatSQL);
    }

}
