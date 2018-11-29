package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.drop;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLDropTableTest_0 {

    @Test
    public void test_0() {
        String sql = "DROP TABLE IF EXISTS tempo; ";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("DROP TABLE IF EXISTS tempo;", format);
    }

    @Test
    public void test_1() {
        String sql = "DROP TEMPORARY TABLE IF EXISTS tempo; ";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("DROP TEMPORARY TABLE IF EXISTS tempo;", format);
    }

}
