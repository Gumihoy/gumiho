package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_8_xml {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 XMLType ," +
                " c2 URIType " +
                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 XMLTYPE,\n" +
                "\tc2 URIType\n" +
                ")", format);
    }

}
