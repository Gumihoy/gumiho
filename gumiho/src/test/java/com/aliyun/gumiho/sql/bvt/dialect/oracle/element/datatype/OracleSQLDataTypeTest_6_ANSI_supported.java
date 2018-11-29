package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.datatype;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLDataTypeTest_6_ANSI_supported {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 character(1), " +
                " c2 character varying(1), " +

                " c3 char varying(1), " +
                " c4 nchar varying(1), " +

                " vc1 varchar(1), " +

                " vc2 national character(1) ," +
                " vc2 national character varying(1) ," +

                " vc3 national char(1) ," +
                " vc4 national char varying(1), " +

                " n1 numeric ," +
                " n2 numeric(1) ," +
                " n3 numeric(1,1), " +

                " n1 decimal ," +
                " n2 decimal(1) ," +
                " n3 decimal(1,1) ," +

                " n1 dec, " +
                " n2 dec(1), " +
                " n3 dec(1,1) ," +

                " n1 integer, " +
                " n1 int, " +
                " n1 smallint, " +

                " f1 float, " +
                " f2 float(1), " +

                " dp1 double precision, " +
                " r real " +

                ")";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 CHARACTER(1),\n" +
                "\tc2 CHARACTER VARYING(1),\n" +
                "\tc3 CHAR VARYING(1),\n" +
                "\tc4 NCHAR VARYING(1),\n" +
                "\tvc1 VARCHAR(1),\n" +
                "\tvc2 NATIONAL CHARACTER,\n" +
                "\tvc2 NATIONAL CHARACTER VARYING(1),\n" +
                "\tvc3 NATIONAL CHAR(1),\n" +
                "\tvc4 NATIONAL CHAR VARYING(1),\n" +
                "\tn1 NUMERIC,\n" +
                "\tn2 NUMERIC(1),\n" +
                "\tn3 NUMERIC(1, 1),\n" +
                "\tn1 DECIMAL,\n" +
                "\tn2 DECIMAL(1),\n" +
                "\tn3 DECIMAL(1, 1),\n" +
                "\tn1 DEC,\n" +
                "\tn2 DEC(1),\n" +
                "\tn3 DEC(1, 1),\n" +
                "\tn1 INTEGER,\n" +
                "\tn1 INT,\n" +
                "\tn1 SMALLINT,\n" +
                "\tf1 FLOAT,\n" +
                "\tf2 FLOAT(1),\n" +
                "\tdp1 DOUBLE PRECISION,\n" +
                "\tr REAL\n" +
                ")", format);
    }

}
