package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSCreateTableTest_3_Hash_DBPartition {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE multi_db_single_tbl(\n" +
                "  id int, \n" +
                "  name varchar(30), \n" +
                "  primary key(id)\n" +
                ") dbpartition by hash(id);";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE multi_db_single_tbl (\n" +
                "\tid INT,\n" +
                "\tname VARCHAR(30),\n" +
                "\tPRIMARY KEY (id)\n" +
                ")\n" +
                "DBPARTITION BY HASH (id);", format);
    }

}