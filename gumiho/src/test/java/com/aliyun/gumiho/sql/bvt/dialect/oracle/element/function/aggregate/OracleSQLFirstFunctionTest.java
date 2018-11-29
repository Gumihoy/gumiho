package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.aggregate;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TO_CHAR-datetime.html#GUID-0C3EEFD1-AE3D-452D-BF23-2FC95664E78F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLFirstFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT department_id,\n" +
                "       MIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct) \"Worst\",\n" +
                "       MAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct) \"Best\"\n" +
                "  FROM employees\n" +
                "  GROUP BY department_id\n" +
                "  ORDER BY department_id;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT department_id,\n" +
                "\tMIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct) \"Worst\",\n" +
                "\tMAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct) \"Best\"\n" +
                "FROM employees\n" +
                "GROUP BY department_id\n" +
                "ORDER BY department_id;", formatSQL);
    }

}
