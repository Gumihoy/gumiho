package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_1_Number {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " n1 number, " +
                " n2 number(*), " +
                " n3 number(*,0), " +
                " n4 number(10), " +
                " n5 number(10, 0), " +

                " f1 float, " +
                " f2 float(1), " +

                " bf binary_float, " +

                " bd binary_double " +
                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tn1 NUMBER,\n" +
                "\tn2 NUMBER(*),\n" +
                "\tn3 NUMBER(*, 0),\n" +
                "\tn4 NUMBER(10),\n" +
                "\tn5 NUMBER(10, 0),\n" +
                "\tf1 FLOAT,\n" +
                "\tf2 FLOAT(1),\n" +
                "\tbf BINARY_FLOAT,\n" +
                "\tbd BINARY_DOUBLE\n" +
                ")", format);
    }


}
