package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSCreateTableTest_10_MMDD_TBPartition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE user_log4(\n" +
                " userId int, \n" +
                " name varchar(30), \n" +
                " operation varchar(30), \n" +
                " actionDate DATE\n" +
                ") dbpartition by hash(userId) tbpartition by MMDD(actionDate) tbpartitions 365;";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE user_log4(\n" +
                " userId int, \n" +
                " name varchar(30), \n" +
                " operation varchar(30), \n" +
                " actionDate DATE\n" +
                ") dbpartition by hash(userId) tbpartition by MMDD(actionDate) tbpartitions 365;", format);
    }

}
