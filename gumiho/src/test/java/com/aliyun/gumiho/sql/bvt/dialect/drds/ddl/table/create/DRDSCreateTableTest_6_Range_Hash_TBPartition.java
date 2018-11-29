package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSCreateTableTest_6_Range_Hash_TBPartition {

    @Test
    public void test_0() {
        String sql = "create table test_order_tb (\n" +
                " id int,\n" +
                " seller_id varchar(30) DEFAULT NULL,\n" +
                " order_id varchar(30) DEFAULT NULL,\n" +
                " buyer_id varchar(30) DEFAULT NULL,\n" +
                " create_time datetime DEFAULT NULL,\n" +
                " primary key(id)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 dbpartition by RANGE_HASH(buyer_id, order_id, 10) tbpartition by RANGE_HASH(buyer_id, order_id, 10) tbpartitions 3;";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE multi_db_multi_tbl (\n" +
                "\tid INT AUTO_INCREMENT,\n" +
                "\tbid INT,\n" +
                "\tname VARCHAR(30),\n" +
                "\tPRIMARY KEY (id)\n" +
                ")\n" +
                "DBPARTITION BY HASH (id)\n" +
                "\tTBPARTITION BY HASH (bid)\n" +
                "\tTBPARTITIONS 3;", format);
    }

}
