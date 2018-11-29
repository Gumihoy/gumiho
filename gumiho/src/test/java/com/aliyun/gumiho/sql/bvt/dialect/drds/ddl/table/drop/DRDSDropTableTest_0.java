package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.drop;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSDropTableTest_0 {

    @Test
    public void test() {
        String sql = "DROP TABLE user_log; ";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("DROP TABLE user_log;", format);
    }

}
