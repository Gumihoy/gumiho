package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_7_Key_Partition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE tk (col1 INT, col2 CHAR(5), col3 DATE)\n" +
                "    PARTITION BY KEY(col3)\n" +
                "    PARTITIONS 4;";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_1() {
        String sql = "CREATE TABLE tk (col1 INT, col2 CHAR(5), col3 DATE)\n" +
                "    PARTITION BY LINEAR KEY(col3)\n" +
                "    PARTITIONS 5;";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

}
