package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.model;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ITERATION_NUMBER.html#GUID-C7B75092-475A-4AB3-8A7C-94C68704538C
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLIterationNumberFunctionTest {

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
                "    RULES UPSERT SEQUENTIAL ORDER ITERATE(2)\n" +
                "      (\n" +
                "        s['Mouse Pad', 2001 + ITERATION_NUMBER] =\n" +
                "          s['Mouse Pad', 1998 + ITERATION_NUMBER]\n" +
                "      )\n" +
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
                "\tRULES UPSERT SEQUENTIAL ORDER ITERATE (2) (\n" +
                "\t\ts['Mouse Pad', 2001 + ITERATION_NUMBER] = s['Mouse Pad', 1998 + ITERATION_NUMBER]\n" +
                "\t)\n" +
                "ORDER BY country, prod, year;", formatSQL);
    }

}
