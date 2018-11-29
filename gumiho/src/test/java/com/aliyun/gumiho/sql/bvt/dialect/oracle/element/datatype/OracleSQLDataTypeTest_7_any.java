package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_7_any {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 AnyData, " +
                " c2 AnyType ," +
                " c3 AnyDataSet, " +
                " c4 SYS.AnyData, " +
                " c5 SYS.AnyType ," +
                " c6 SYS.AnyDataSet " +
                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 SYS.AnyData,\n" +
                "\tc2 SYS.AnyType,\n" +
                "\tc3 SYS.AnyDataSet\n" +
                ")", format);
    }


}
