package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_3_Like {

    @Test
    public void test_0() {
        String oracleSql = "CREATE TABLE new_tbl LIKE orig_tbl;";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }

}
