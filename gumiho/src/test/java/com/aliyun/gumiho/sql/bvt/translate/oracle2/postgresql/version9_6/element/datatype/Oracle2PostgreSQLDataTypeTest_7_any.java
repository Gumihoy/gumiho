package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.element.datatype;

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
public class Oracle2PostgreSQLDataTypeTest_7_any {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 SYS.AnyData, " +
                " c2 SYS.AnyType ," +
                " c3 SYS.AnyDataSet " +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToPostgreSQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 SYS.AnyData,\n" +
                "\tc2 SYS.AnyType,\n" +
                "\tc3 SYS.AnyDataSet\n" +
                ")", result.targetSql);
    }


}