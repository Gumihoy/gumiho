package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.rename;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSRenameTableTest_0 {

    @Test
    public void test_0() {
        String sql = "RENAME TABLE old_table TO new_table; ";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("RENAME TABLE old_table TO new_table;", format);
    }

    @Test
    public void test_1() {
        String sql = "RENAME TABLE old_table1 TO new_table1,\n" +
                "             old_table2 TO new_table2,\n" +
                "             old_table3 TO new_table3; ";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("RENAME TABLE old_table1 TO new_table1, old_table2 TO new_table2, old_table3 TO new_table3;", format);
    }

    @Test
    public void test_2() {
        String sql = "RENAME TABLE current_db.tbl_name TO other_db.tbl_name; ";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("RENAME TABLE current_db.tbl_name TO other_db.tbl_name;", format);
    }

}
