package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSCreateTableTest_11_Table_Option {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE brd_tbl(\n" +
                "  id int, \n" +
                "  name varchar(30), \n" +
                "  primary key(id)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 BROADCAST;";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE brd_tbl(\n" +
                "  id int, \n" +
                "  name varchar(30), \n" +
                "  primary key(id)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 BROADCAST;", format);
    }

}
