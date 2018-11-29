package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_4_SubQuery {

    @Test
    public void test_0() {
        String oracleSql = "CREATE TABLE new_tbl AS SELECT * FROM orig_tbl;";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }

    @Test
    public void test_1() {
        String oracleSql = "CREATE TABLE test (a INT NOT NULL AUTO_INCREMENT,\n" +
                "    PRIMARY KEY (a), KEY(b))\n" +
                "    ENGINE=MyISAM SELECT b,c FROM test2;";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }
}
