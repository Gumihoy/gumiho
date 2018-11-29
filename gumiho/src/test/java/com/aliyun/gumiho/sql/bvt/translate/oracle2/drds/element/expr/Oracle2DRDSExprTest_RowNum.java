package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.expr;

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
public class Oracle2DRDSExprTest_RowNum {


    @Test
    public void test_0() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE ROWNUM < 11;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE LIMIT 10;", result.targetSql);
    }

    @Test
    public void test_1() {
        String sql = "SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE ROWNUM = 1;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "  FROM employees\n" +
                "  WHERE LIMIT 1;", result.targetSql);
    }

    @Test
    public void test_2() {
        String sql = "SELECT XX.*, ROWNUM AS RN\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM t\n" +
                "\tORDER BY id\n" +
                ") XX\n" +
                "WHERE RN < 10";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT XX.*, ROWNUM AS RN\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM t\n" +
                "\tORDER BY id\n" +
                ") XX\n" +
                "WHERE ROWNUM < 10", result.targetSql);

    }

    @Test
    public void test_3() {
        String sql = "SELECT *\n" +
                "FROM (SELECT XX.*, ROWNUM AS RN\n" +
                "\tFROM (SELECT id, name, salary\n" +
                "\t\tFROM t\n" +
                "\t\tORDER BY id, name\n" +
                "\t\t) XX\n" +
                "\tWHERE ROWNUM <= 30\n" +
                "\t) XXX\n" +
                "WHERE RN >= 20";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM (SELECT XX.*, ROWNUM AS RN\n" +
                "\tFROM (SELECT id, name, salary\n" +
                "\t\tFROM t\n" +
                "\t\tORDER BY id, name\n" +
                "\t\t) XX\n" +
                "\tWHERE ROWNUM <= 30\n" +
                "\t) XXX\n" +
                "WHERE RN > 20\n" +
                "SELECT *\n" +
                "FROM (\n" +
                "\tSELECT XX.*, ROWNUM AS RN\n" +
                "\tFROM (\n" +
                "\t\tSELECT id, name, salary\n" +
                "\t\tFROM t\n" +
                "\t\tORDER BY id, name\n" +
                "\t) XX\n" +
                "\tWHERE ROWNUM <= 30\n" +
                ") XXX\n" +
                "WHERE RN > 20", result.targetSql);

    }

    @Test
    public void test_4() {
        String sql = "SELECT *\n" +
                "FROM (SELECT rownum AS numrow, c.*\n" +
                "\tFROM (select * from t ORDER BY t1.hfbz) c\n" +
                "\t)\n" +
                "WHERE numrow >= ?\n" +
                "\tAND numrow <= ?;\n" +
                "SELECT *\n" +
                "FROM (\n" +
                "\tSELECT rownum AS numrow, c.*\n" +
                "\tFROM (\n" +
                "\t\tSELECT *\n" +
                "\t\tFROM t\n" +
                "\t\tORDER BY t1.hfbz\n" +
                "\t) c\n" +
                ")\n" +
                "WHERE numrow >= ?\n" +
                "\tAND numrow <= ?;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `t`\n" +
                "ORDER BY t1.hfbz\n" +
                "LIMIT ? - 1, ? - (? - 1);", result.targetSql);

    }

    @Test
    public void test_5() {
        String sql = "SELECT STOREID\n" +
                "FROM (\n" +
                "\tSELECT T.STOREID\n" +
                "\tFROM TAB1010204 T\n" +
                "\tWHERE NVL(T.ISOLD, ?) != ?\n" +
                "\t\tAND T.RELATEDDOCSTOREID = :B1\n" +
                "\tORDER BY T.BLSJ DESC\n" +
                ") GET_LAST204ID\n" +
                "WHERE ROWNUM = ?;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT T.STOREID\n" +
                "FROM `TAB1010204` T\n" +
                "WHERE IFNULL(T.ISOLD, ?) != ?\n" +
                "\tAND T.RELATEDDOCSTOREID = ?\n" +
                "ORDER BY T.BLSJ DESC\n" +
                "LIMIT ? - 1, 1;", result.targetSql);

    }

    @Test
    public void test_6() {
        String sql = "SELECT *\n" +
                "FROM T\n" +
                "WHERE ROWNUM > 10\n" +
                "\tAND ROWNUM <= 20";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `T`\n" +
                "LIMIT 10, 10;", result.targetSql);

    }
}
