package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.conversion;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLTreatFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT name, TREAT(VALUE(p) AS employee_t).salary salary \n" +
                "   FROM persons p;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT name, TREAT(VALUE(p) AS employee_t).salary salary\n" +
                "FROM persons p;", formatSQL);
    }

}
