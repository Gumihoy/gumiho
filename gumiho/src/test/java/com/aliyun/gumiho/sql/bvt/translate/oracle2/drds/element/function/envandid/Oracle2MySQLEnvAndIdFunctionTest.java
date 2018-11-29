package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.envandid;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLEnvAndIdFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT CON_DBID_TO_ID(2256797992)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(2256797992)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_2() {
        String sql = "SELECT CON_GUID_TO_ID(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }

    @Test
    public void test_3() {
        String sql = "SELECT CON_NAME_TO_ID(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_4() {
        String sql = "SELECT CON_UID_TO_ID(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_5() {
        String sql = "SELECT ORA_INVOKING_USER(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_6() {
        String sql = "SELECT ORA_INVOKING_USERID()" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_7() {
        String sql = "SELECT SYS_CONTEXT ('USERENV', 'SESSION_USER') " +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT SYS_CONTEXT('USERENV', 'SESSION_USER')\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_8() {
        String sql = "SELECT SYS_GUID()" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT REPLACE(UUID(), '-', '')\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_9() {
        String sql = "SELECT SYS_TYPEID(0.9, 1, 5)" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT CON_DBID_TO_ID(0.9, 1, 5)\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_10() {
        String sql = "SELECT UID" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT UID\n" +
                "FROM DUAL", result.targetSql);
    }
    @Test
    public void test_11() {
        String sql = "SELECT USER" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT USER()\n" +
                "FROM DUAL", result.targetSql);
    }

    @Test
    public void test_12() {
        String sql = "SELECT USERENV('CLIENT_INFO'), USERENV('ENTRYID'), USERENV('ISDBA'), " +
                " USERENV('LANG'), USERENV('LANGUAGE'), USERENV('SESSIONID'), " +
                " USERENV('SID'), USERENV('TERMINAL') " +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT USERENV('CLIENT_INFO'), USERENV('ENTRYID'), USERENV('ISDBA'),\n" +
                "\tUSERENV('LANG'), USERENV('LANGUAGE'), USERENV('SESSIONID'),\n" +
                "\tUSERENV('SID'), USERENV('TERMINAL')\n" +
                "FROM DUAL", result.targetSql);
    }
}
