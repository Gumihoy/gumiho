package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.view.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateViewTest_0 {

    @Test
    public void test_0() {
        String sql = "CREATE VIEW test.v AS SELECT * FROM t;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE VIEW test.v\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM t;", format);
    }

    @Test
    public void test_1() {
        String sql = "CREATE VIEW v_today (today) AS SELECT CURRENT_DATE;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE VIEW v_today (\n" +
                "\ttoday\n" +
                ")\n" +
                "AS\n" +
                "\tSELECT CURRENT_DATE;", format);
    }

}
