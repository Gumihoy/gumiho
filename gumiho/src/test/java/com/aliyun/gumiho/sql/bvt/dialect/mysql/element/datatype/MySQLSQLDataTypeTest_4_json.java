package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.datatype;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class MySQLSQLDataTypeTest_4_json {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " s1 json " +
                ")";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\ts1 JSON\n" +
                ")", format);
    }

}
