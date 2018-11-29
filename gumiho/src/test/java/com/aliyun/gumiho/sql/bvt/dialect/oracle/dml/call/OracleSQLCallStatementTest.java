package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.call;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/23.
 */
public class OracleSQLCallStatementTest {

    @Test
    public void test_1() {
        String sql = "CALL my_procedure(3, 4)";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "CALL my_procedure(3, arg2 => 4)";
        System.out.println(sql);
        String format = OracleUtils.format(sql);
        System.out.println("-------------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_3() {
        String sql = "CALL ret_warehouse_typ(warehouse_typ(234, 'Warehouse 234',\n" +
                "   2235)).ret_name() INTO :x;";
        System.out.println(sql);
        String format = OracleUtils.format(sql);
        System.out.println("-------------------------");
        System.out.println(format);
        Assert.assertEquals("CALL ret_warehouse_typ(warehouse_typ(234, 'Warehouse 234', 2235)).ret_name() INTO :x;", format);
    }
}
