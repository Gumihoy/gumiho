package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.conversion;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLTreatFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT name, TREAT(VALUE(p) AS employee_t).salary salary \n" +
                "   FROM persons p;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
