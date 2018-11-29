package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.operator;

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
public class Oracle2MySQLBinaryOperatorTest {

    protected static SQLTransformConfig config = new SQLTransformConfig();
    static {
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
    }


    @Test
    public void test_0() {
        String sql = "SELECT 1 || 2 FROM DUAL";
        String format = OracleUtils.format(sql);

        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CONCAT(1, 2)\n" +
                "FROM DUAL", result.targetSql);
    }



}
