package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.datatype;

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
public class Oracle2DRDSDataTypeTest_1_Number {


    @Test
    public void test() {
        String sql = "CREATE TABLE t (\n" +
                "\tn1 NUMBER,\n" +
                "\tn2 NUMBER(*),\n" +
                "\tn3 NUMBER(*, 0),\n" +
                "\tn4 NUMBER(1),\n" +
                "\tn5 NUMBER(3),\n" +
                "\tn6 NUMBER(5),\n" +
                "\tn7 NUMBER(7),\n" +
                "\tn8 NUMBER(10),\n" +
                "\tn9 NUMBER(19),\n" +
                "\tn10 NUMBER(1, 0),\n" +
                "\tn11 NUMBER(3, 0),\n" +
                "\tn12 NUMBER(5, 0),\n" +
                "\tn13 NUMBER(7, 0),\n" +
                "\tn14 NUMBER(10, 0),\n" +
                "\tn15 NUMBER(19, 0),\n" +
                "\tn16 NUMBER(10, 9),\n" +
                "\tn17 NUMBER(10, 11),\n" +
                "\tn18 NUMBER(10, 127),\n" +
                "\tn19 NUMBER(10, -1),\n" +
                "\tf1 FLOAT,\n" +
                "\tf2 FLOAT(1),\n" +
                "\tbf BINARY_FLOAT,\n" +
                "\tbd BINARY_DOUBLE\n" +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        SQLTransformResult result = SQLTransformUtils.oracleToDRDS(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tn1 NUMBER,\n" +
                "\tn2 NUMBER(*),\n" +
                "\tn3 NUMBER(1),\n" +
                "\tn4 NUMBER(3),\n" +
                "\tn5 NUMBER(5),\n" +
                "\tn6 NUMBER(9),\n" +
                "\tn7 NUMBER(19),\n" +
                "\tn8 NUMBER(38),\n" +
                "\tn9 NUMBER(1, 1),\n" +
                "\tn10 NUMBER(1, 5),\n" +
                "\tf1 FLOAT,\n" +
                "\tf2 FLOAT(1),\n" +
                "\tbf BINARY_FLOAT,\n" +
                "\tbd BINARY_DOUBLE\n" +
                ")", result.targetSql);
    }


}
