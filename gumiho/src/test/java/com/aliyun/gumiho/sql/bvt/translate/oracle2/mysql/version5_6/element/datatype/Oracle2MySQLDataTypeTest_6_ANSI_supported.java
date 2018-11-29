package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.datatype;

import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLDataTypeTest_6_ANSI_supported {

    @Test
    public void test() {
        String sql = "CREATE TABLE t (\n" +
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
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
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
                ")", result.targetSql);
    }

}
