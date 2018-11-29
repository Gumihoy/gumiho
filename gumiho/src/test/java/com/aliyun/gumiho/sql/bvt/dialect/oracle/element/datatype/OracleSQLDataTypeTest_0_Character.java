package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_0_Character {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 char, " +
                " c2 char(1), " +
                " c3 char(1 byte), " +
                " c4 char(1 char), " +

                " vc1 varchar2, " +
                " vc2 varchar2(1), " +
                " vc3 varchar2(1 byte), " +
                " vc4 varchar2(1 char), " +

                " nc1 nchar, " +
                " nc2 nchar(1), " +

                " nvc2 nvarchar2(1) " +

                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 CHAR,\n" +
                "\tc2 CHAR(1),\n" +
                "\tc3 CHAR(1 BYTE),\n" +
                "\tc4 CHAR(1 CHAR),\n" +
                "\tvc1 VARCHAR2,\n" +
                "\tvc2 VARCHAR2(1),\n" +
                "\tvc3 VARCHAR2(1 BYTE),\n" +
                "\tvc4 VARCHAR2(1 CHAR),\n" +
                "\tnc1 NCHAR,\n" +
                "\tnc2 NCHAR(1),\n" +
                "\tnvc2 NVARCHAR2(1)\n" +
                ")", format);
    }


}
