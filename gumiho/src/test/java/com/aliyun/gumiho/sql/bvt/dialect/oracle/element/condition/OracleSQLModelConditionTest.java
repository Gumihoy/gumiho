package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.condition;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Model-Conditions.html#GUID-1F5B08DB-2B7A-4ECE-B51A-C753A426928B
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLModelConditionTest {

    @Test
    public void test_0() {
        String sql = "SELECT country, prod, year, s\n" +
                "  FROM sales_view_ref\n" +
                "  MODEL\n" +
                "    PARTITION BY (country)\n" +
                "    DIMENSION BY (prod, year)\n" +
                "    MEASURES (sale s)\n" +
                "    IGNORE NAV\n" +
                "    UNIQUE DIMENSION\n" +
                "    RULES UPSERT SEQUENTIAL ORDER\n" +
                "    (\n" +
                "      s[ANY, 2000] = 0\n" +
                "    )\n" +
                "  ORDER BY country, prod, year;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT country, prod, year, s\n" +
                "FROM sales_view_ref\n" +
                "MODEL\n" +
                "\tPARTITION BY (country)\n" +
                "\tDIMENSION BY (prod, year)\n" +
                "\tMEASURES (sale s)\n" +
                "\tIGNORE NAV UNIQUE DIMENSION\n" +
                "\tRULES UPSERT SEQUENTIAL ORDER (\n" +
                "\t\ts[ANY, 2000] = 0\n" +
                "\t)\n" +
                "ORDER BY country, prod, year;", format);
    }


    @Test
    public void test_1() {
        String sql = "SELECT country, prod, year, s\n" +
                "  FROM sales_view_ref\n" +
                "  MODEL\n" +
                "    PARTITION BY (country)\n" +
                "    DIMENSION BY (prod, year)\n" +
                "    MEASURES (sale s)\n" +
                "    IGNORE NAV\n" +
                "    UNIQUE DIMENSION\n" +
                "    RULES UPSERT SEQUENTIAL ORDER\n" +
                "    (\n" +
                "      s['Mouse Pad', 2000] =\n" +
                "        CASE WHEN s['Mouse Pad', 1999] IS PRESENT\n" +
                "             THEN s['Mouse Pad', 1999]\n" +
                "             ELSE 0\n" +
                "        END\n" +
                "    )\n" +
                "  ORDER BY country, prod, year;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT country, prod, year, s\n" +
                "FROM sales_view_ref\n" +
                "MODEL\n" +
                "\tPARTITION BY (country)\n" +
                "\tDIMENSION BY (prod, year)\n" +
                "\tMEASURES (sale s)\n" +
                "\tIGNORE NAV UNIQUE DIMENSION\n" +
                "\tRULES UPSERT SEQUENTIAL ORDER (\n" +
                "\t\ts['Mouse Pad', 2000] = CASE\n" +
                "\t\t\tWHEN s['Mouse Pad', 1999] IS PRESENT THEN s['Mouse Pad', 1999]\n" +
                "\t\t\tELSE 0\n" +
                "\t\tEND\n" +
                "\t)\n" +
                "ORDER BY country, prod, year;", format);
    }

}
