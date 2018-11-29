package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.procedure.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/29.
 */
public class MySQLCreateProcedureTest_0 {

    @Test
    public void test() {
        String sql = "CREATE PROCEDURE simpleproc (OUT param1 INT)\n" +
                "    BEGIN\n" +
                "    SELECT COUNT(*) INTO param1 FROM t;\n" +
                "    END";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals(sql, format);
    }
}
