package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.truncate;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class OracleTruncateTableTest_0 {

    @Test
    public void test_0() {
        String oracleSql = "TRUNCATE TABLE employees_demo; ";

        String format = SQLUtils.format(oracleSql, DBType.Oracle);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("TRUNCATE TABLE employees_demo;", format);
    }

    @Test
    public void test_1() {
        String oracleSql = "TRUNCATE TABLE sales_demo PRESERVE MATERIALIZED VIEW LOG;  ";

        String format = SQLUtils.format(oracleSql, DBType.Oracle);
        System.out.println(oracleSql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("TRUNCATE TABLE sales_demo PRESERVE MATERIALIZED VIEW LOG;", format);
    }
}
