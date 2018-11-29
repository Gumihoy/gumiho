package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.aggregate;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TO_CHAR-datetime.html#GUID-0C3EEFD1-AE3D-452D-BF23-2FC95664E78F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLFirstFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT department_id,\n" +
                "       MIN(salary) KEEP (DENSE_RANK FIRST ORDER BY commission_pct) \"Worst\",\n" +
                "       MAX(salary) KEEP (DENSE_RANK LAST ORDER BY commission_pct) \"Best\"\n" +
                "  FROM employees\n" +
                "  GROUP BY department_id\n" +
                "  ORDER BY department_id;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
