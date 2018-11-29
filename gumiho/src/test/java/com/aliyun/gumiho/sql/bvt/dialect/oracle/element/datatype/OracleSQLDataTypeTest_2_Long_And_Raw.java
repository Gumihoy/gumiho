package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_2_Long_And_Raw {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " l1 long, " +

                " lr long raw, " +

                " r1 raw(1) " +

                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tl1 LONG,\n" +
                "\tlr LONG RAW,\n" +
                "\tr1 RAW(1)\n" +
                ")", format);
    }

}
