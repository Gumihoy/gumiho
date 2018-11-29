package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.aggregate;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLAvgFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT AVG(DISTINCT salary) \"Average\"\n" +
                "  FROM employees;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT AVG(DISTINCT ?) \"Average\"\n" +
                "  FROM employees;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
