package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.table.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTableTest_9_List_Partition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE client_firms (\n" +
                "    id   INT,\n" +
                "    name VARCHAR(35)\n" +
                ")\n" +
                "PARTITION BY LIST (id) (\n" +
                "    PARTITION r0 VALUES IN (1, 5, 9, 13, 17, 21),\n" +
                "    PARTITION r1 VALUES IN (2, 6, 10, 14, 18, 22),\n" +
                "    PARTITION r2 VALUES IN (3, 7, 11, 15, 19, 23),\n" +
                "    PARTITION r3 VALUES IN (4, 8, 12, 16, 20, 24)\n" +
                ");";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_1() {
        String sql = "CREATE TABLE lc (\n" +
                "    a INT NULL,\n" +
                "    b INT NULL\n" +
                ")\n" +
                "PARTITION BY LIST COLUMNS(a,b) (\n" +
                "    PARTITION p0 VALUES IN( (0,0), (NULL,NULL) ),\n" +
                "    PARTITION p1 VALUES IN( (0,1), (0,2), (0,3), (1,1), (1,2) ),\n" +
                "    PARTITION p2 VALUES IN( (1,0), (2,0), (2,1), (3,0), (3,1) ),\n" +
                "    PARTITION p3 VALUES IN( (1,3), (2,2), (2,3), (3,2), (3,3) )\n" +
                ");";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "CREATE TABLE th (id INT, name VARCHAR(30), adate DATE)\n" +
                "PARTITION BY LIST(YEAR(adate))\n" +
                "(\n" +
                "  PARTITION p1999 VALUES IN (1995, 1999, 2003)\n" +
                "    DATA DIRECTORY = '/var/appdata/95/data'\n" +
                "    INDEX DIRECTORY = '/var/appdata/95/idx',\n" +
                "  PARTITION p2000 VALUES IN (1996, 2000, 2004)\n" +
                "    DATA DIRECTORY = '/var/appdata/96/data'\n" +
                "    INDEX DIRECTORY = '/var/appdata/96/idx',\n" +
                "  PARTITION p2001 VALUES IN (1997, 2001, 2005)\n" +
                "    DATA DIRECTORY = '/var/appdata/97/data'\n" +
                "    INDEX DIRECTORY = '/var/appdata/97/idx',\n" +
                "  PARTITION p2002 VALUES IN (1998, 2002, 2006)\n" +
                "    DATA DIRECTORY = '/var/appdata/98/data'\n" +
                "    INDEX DIRECTORY = '/var/appdata/98/idx'\n" +
                ");";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }
}
