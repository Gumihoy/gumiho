package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.expr;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLExprCollateExprTest {


    @Test
    public void test_1() {
        String sql = "SELECT name COLLATE BINARY_CI FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
