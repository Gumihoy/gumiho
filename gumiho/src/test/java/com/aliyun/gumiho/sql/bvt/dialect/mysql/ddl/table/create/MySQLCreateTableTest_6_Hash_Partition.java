package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_6_Hash_Partition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE t1 (col1 INT, col2 CHAR(5))\n" +
                "    PARTITION BY HASH(col1);";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_1() {
        String sql = "CREATE TABLE t1 (col1 INT, col2 CHAR(5), col3 DATETIME)\n" +
                "    PARTITION BY HASH ( YEAR(col3) );";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

}
