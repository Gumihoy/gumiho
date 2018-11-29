package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.procedure.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/29.
 */
public class MySQLCreateProcedureTest_1_Definer {

    @Test
    public void test() {
        String sql = "CREATE DEFINER = 'admin'@'localhost' PROCEDURE account_count()\n" +
                "BEGIN\n" +
                "  SELECT 'Number of accounts:', COUNT(*) FROM mysql.user;\n" +
                "END;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }
}
