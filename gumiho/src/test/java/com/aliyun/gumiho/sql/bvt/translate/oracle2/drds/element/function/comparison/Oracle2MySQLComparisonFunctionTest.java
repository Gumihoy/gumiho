package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.comparison;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLComparisonFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT GREATEST('HARRY', 'HARRIOT', 'HAROLD') \"Greatest\"\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }

    @Test
    public void test_2() {
        String sql = "SELECT LEAST('HARRY', 'HARRIOT', 'HAROLD') \"Greatest\"\n" +
                "  FROM DUAL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
}
