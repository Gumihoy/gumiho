package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_5_Column {

    @Test
    public void test_0() {
        String oracleSql = "CREATE TABLE t1 (\n" +
                "    c1 INT STORAGE DISK,\n" +
                "    c2 INT STORAGE MEMORY\n" +
                "    ) TABLESPACE ts_1 ENGINE NDB;";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }

    @Test
    public void test_1() {
        String oracleSql = "CREATE TABLE lookup\n" +
                "  (id INT, INDEX USING BTREE (id))\n" +
                "  ENGINE = MEMORY;";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }
}
