package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_8_Range_Partition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE t1 (\n" +
                "    year_col  INT,\n" +
                "    some_data INT\n" +
                ")\n" +
                "PARTITION BY RANGE (year_col) (\n" +
                "    PARTITION p0 VALUES LESS THAN (1991),\n" +
                "    PARTITION p1 VALUES LESS THAN (1995),\n" +
                "    PARTITION p2 VALUES LESS THAN (1999),\n" +
                "    PARTITION p3 VALUES LESS THAN (2002),\n" +
                "    PARTITION p4 VALUES LESS THAN (2006),\n" +
                "    PARTITION p5 VALUES LESS THAN MAXVALUE\n" +
                ");";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_1() {
        String sql = "CREATE TABLE rc (\n" +
                "    a INT NOT NULL,\n" +
                "    b INT NOT NULL\n" +
                ")\n" +
                "PARTITION BY RANGE COLUMNS(a,b) (\n" +
                "    PARTITION p0 VALUES LESS THAN (10,5),\n" +
                "    PARTITION p1 VALUES LESS THAN (20,10),\n" +
                "    PARTITION p2 VALUES LESS THAN (50,MAXVALUE),\n" +
                "    PARTITION p3 VALUES LESS THAN (65,MAXVALUE),\n" +
                "    PARTITION p4 VALUES LESS THAN (MAXVALUE,MAXVALUE)\n" +
                ");";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

}
