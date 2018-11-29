package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.trigger.drop;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLDropTriggerTest_0 {

    @Test
    public void test_0() {
        String sql = "DROP TRIGGER cur_trig_name; ";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("DROP TRIGGER cur_trig_name;", format);
    }


}
