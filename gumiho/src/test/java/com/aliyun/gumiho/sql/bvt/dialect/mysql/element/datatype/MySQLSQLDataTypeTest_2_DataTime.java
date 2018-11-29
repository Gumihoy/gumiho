package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.datatype;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class MySQLSQLDataTypeTest_2_DataTime {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " d1 date, " +

                " d1 datetime, " +
                " d1 datetime(1), " +

                " t1 timestamp," +
                " t2 timestamp(1) ," +

                " t1 time," +
                " t2 time(1) ," +

                " t1 year," +
                " t2 year(2)" +

                ")";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\td1 DATE,\n" +
                "\td1 DATETIME,\n" +
                "\td1 DATETIME(1),\n" +
                "\tt1 TIMESTAMP,\n" +
                "\tt2 TIMESTAMP(1),\n" +
                "\tt1 TIME,\n" +
                "\tt2 TIME1,\n" +
                "\tt1 YEAR,\n" +
                "\tt2 YEAR(2)\n" +
                ")", format);
    }

}
