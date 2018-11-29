package com.aliyun.gumiho.sql.bvt.dialect.mysql.dml.locktable;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/2.
 */
public class MySQLSQLLockTableTest_0 {

    @Test
    public void test_0() {
        String sql = "LOCK TABLES t1 WRITE, t2 READ; ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------");
        System.out.println(format);
        Assert.assertEquals("LOCK TABLES t1 WRITE, t2 READ;", format);
    }
}
