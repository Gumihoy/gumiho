package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.index.create;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/29.
 */
public class MySQLCreateIndexTest_0 {

    @Test
    public void test() {
        String sql = "CREATE INDEX \"ARMSCII8\" ON customer (ownedBy(10));";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);

    }
}
