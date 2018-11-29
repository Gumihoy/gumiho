package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.nullrelated;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLLnnvlFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT COUNT(*)\n" +
                "  FROM employees\n" +
                "  WHERE LNNVL(commission_pct >= .2);";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT COUNT(*)\n" +
                "FROM employees\n" +
                "WHERE LNNVL(commission_pct >= .2);", formatSQL);
    }

}
