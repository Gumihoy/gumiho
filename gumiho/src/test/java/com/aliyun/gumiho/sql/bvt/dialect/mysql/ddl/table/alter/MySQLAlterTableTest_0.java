package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.alter;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLAlterTableTest_0 {

    @Test
    public void test() {
        String oracleSql = "CREATE TABLE emp(t1 int, t2 int) ";

        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(oracleSql, format);
    }

}
