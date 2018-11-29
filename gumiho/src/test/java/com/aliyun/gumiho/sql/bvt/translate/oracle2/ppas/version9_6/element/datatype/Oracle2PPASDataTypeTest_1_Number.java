package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.element.datatype;

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
public class Oracle2PPASDataTypeTest_1_Number {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " n1 number, " +
                " n2 number(1), " +
                " n3 number(1,1), " +
                " n4 number(1,5), " +
                " f1 float, " +
                " f2 float(1), " +
                " bf binary_float, " +
                " bd binary_double " +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tn1 NUMBER,\n" +
                "\tn2 NUMBER(1),\n" +
                "\tn3 NUMBER(1, 1),\n" +
                "\tn4 NUMBER(1, 1),\n" +
                "\tf1 FLOAT,\n" +
                "\tf2 FLOAT(1),\n" +
                "\tbf BINARY_FLOAT,\n" +
                "\tbd BINARY_DOUBLE\n" +
                ")", result.targetSql);
    }


}
