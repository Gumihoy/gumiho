package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_10_TableOption {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE `table_a` (\n" +
                "  `a` int(11) DEFAULT NULL,\n" +
                "  `b` int(11) DEFAULT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试';";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }



}
