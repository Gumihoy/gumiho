package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.function.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/29.
 */
public class MySQLCreateFunctionTest_0 {

    @Test
    public void test() {
        String sql = "CREATE FUNCTION hello (s CHAR(20))\n" +
                "    RETURNS CHAR(50) DETERMINISTIC\n" +
                "    RETURN CONCAT('Hello, ',s,'!');";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);

    }
}
