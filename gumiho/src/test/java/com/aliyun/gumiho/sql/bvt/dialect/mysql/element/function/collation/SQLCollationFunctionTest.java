package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.collation;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCollationFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT COLLATION(name), COLLATION(?)\n" +
                "  FROM id_table;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
