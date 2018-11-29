package com.aliyun.gumiho.sql.bvt.dialect.drds.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class DRDSCreateTableTest_1_Column {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE single_tbl2(\n" +
                " id int, \n" +
                " name varchar(30), \n" +
                " primary key(id)\n" +
                ") select * from single_tbl;";

        String format = SQLUtils.format(sql, DBType.DRDS);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE single_tbl2 (\n" +
                "\tid INT,\n" +
                "\tname VARCHAR(30),\n" +
                "\tPRIMARY KEY (id)\n" +
                ")\n" +
                "\tSELECT *\n" +
                "\tFROM single_tbl;", format);
    }

}
