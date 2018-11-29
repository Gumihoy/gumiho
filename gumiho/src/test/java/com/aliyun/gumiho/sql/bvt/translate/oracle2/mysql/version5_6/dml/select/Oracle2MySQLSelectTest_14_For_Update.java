package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.dml.select;

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
public class Oracle2MySQLSelectTest_14_For_Update {


    @Test
    public void test_0() {
        String sql = "SELECT employee_id FROM (SELECT * FROM employees)\n" +
                "   FOR UPDATE OF employee_id;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM `employees`\n" +
                ")\n" +
                "FOR UPDATE;", result.targetSql);

    }

    @Test
    public void test_1() {
        String sql = "SELECT employee_id FROM (SELECT * FROM employees)\n" +
                "   FOR UPDATE OF employee_id NOWAIT;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM `employees`\n" +
                ")\n" +
                "FOR UPDATE;", result.targetSql);

    }

    @Test
    public void test_2() {
        String sql = "SELECT employee_id FROM (SELECT * FROM employees)\n" +
                "   FOR UPDATE OF employee_id WAIT 1;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM `employees`\n" +
                ")\n" +
                "FOR UPDATE;", result.targetSql);

    }

    @Test
    public void test_3() {
        String sql = "SELECT employee_id FROM (SELECT * FROM employees)\n" +
                "   FOR UPDATE OF employee_id SKIP LOCKED\n;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM `employees`\n" +
                ")\n" +
                "FOR UPDATE;", result.targetSql);

    }
}
