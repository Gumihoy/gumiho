package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.datetime;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLAddMonthsFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT TO_CHAR(ADD_MONTHS(hire_date, 1), 'DD-MON-YYYY') \"Next month\"\n" +
                "  FROM employees \n" +
                "  WHERE last_name = 'Baer';";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }


}
