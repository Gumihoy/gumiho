package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.procedure.drop;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/29.
 */
public class MySQLDropProcedureTest_0 {

    @Test
    public void test() {
        String sql = "DROP PROCEDURE IF EXISTS simpleproc";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }
}
