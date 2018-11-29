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
public class Oracle2PPASDataTypeTest_5_rowid {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 rowid, " +
                " c2 urowid, " +
                " c3 urowid(1) " +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 ROWID,\n" +
                "\tc2 UROWID,\n" +
                "\tc3 UROWID(1)\n" +
                ")", result.targetSql);
    }
}
