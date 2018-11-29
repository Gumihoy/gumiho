package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.expr;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Compound-Expressions.html#GUID-533C7BA0-C8B4-4323-81EA-1379657AF64A
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLExprTest_Compound {

    @Test
    public void test_0() {
        String sql = "SELECT  1 || 1" +
                "  FROM dual\n";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT 1 || 1\n" +
                "FROM `dual`", result.targetSql);
    }



}
