package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.truncate;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLTruncateTableTest_0 {

    @Test
    public void test_0() {
        String sql = "TRUNCATE TABLE employees_demo; ";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("TRUNCATE TABLE employees_demo;", format);
    }

    @Test
    public void test_1() {
        String sql = "TRUNCATE employees_demo; ";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("TRUNCATE employees_demo;", format);
    }
}
