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
public class Oracle2PPASDataTypeTest_3_DataTime {

    @Test
    public void test() {
        String sql = "Create table t(" +
                " d1 data, " +

                " t1 timestamp," +
                " t2 timestamp(1) ," +
                " t3 timestamp with time zone ," +
                " t4 timestamp(1) with time zone, " +
                " t5 timestamp with local time zone," +
                " t6 timestamp(1) with local time zone ," +

                " iy1 INTERVAL YEAR TO MONTH ," +
                " iy2 INTERVAL YEAR(1) TO MONTH, " +

                " id1 INTERVAL DAY TO SECOND ," +
                " id2 INTERVAL DAY(1) TO SECOND, " +
                " id3 INTERVAL DAY TO SECOND(1) ," +
                " id4 INTERVAL DAY(1) TO SECOND(1) " +

                ")";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\td1 data,\n" +
                "\tt1 TIMESTAMP,\n" +
                "\tt2 TIMESTAMP(1),\n" +
                "\tt3 TIMESTAMP WITH TIME ZONE,\n" +
                "\tt4 TIMESTAMP(1) WITH TIME ZONE,\n" +
                "\tt5 TIMESTAMP WITH LOCAL TIME ZONE,\n" +
                "\tt6 TIMESTAMP(1) WITH LOCAL TIME ZONE,\n" +
                "\tiy1 INTERVAL YEAR TO MONTH,\n" +
                "\tiy2 INTERVAL YEAR (1) TO MONTH,\n" +
                "\tid1 INTERVAL DAY TO SECOND,\n" +
                "\tid2 INTERVAL DAY (1) TO SECOND,\n" +
                "\tid3 INTERVAL DAY TO SECOND (1),\n" +
                "\tid4 INTERVAL DAY (1) TO SECOND (1)\n" +
                ")", result.targetSql);
    }

}
