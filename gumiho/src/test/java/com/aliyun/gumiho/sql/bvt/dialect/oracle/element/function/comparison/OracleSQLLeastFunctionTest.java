package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.comparison;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLLeastFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT LEAST('HARRY','HARRIOT','HAROLD') \"Least\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT LEAST('HARRY', 'HARRIOT', 'HAROLD') \"Least\"\n" +
                "FROM DUAL;", formatSQL);
    }

}
