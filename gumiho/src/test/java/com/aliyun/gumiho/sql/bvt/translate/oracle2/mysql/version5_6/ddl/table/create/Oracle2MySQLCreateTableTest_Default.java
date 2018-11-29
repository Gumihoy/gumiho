package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.ddl.table.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCreateTableTest_Default {


    @Test
    public void test_0() {
        String sql = " CREATE TABLE \"ZJXFTYPT\".\"U3C_MG_BRANCHUPLOG\" \n" +
                "   (\t\"ID\" NUMBER(11,0) NOT NULL ENABLE, \n" +
                "\t\"FTPID\" NUMBER(11,0), \n" +
                "\t\"PRODUCTNAME\" VARCHAR2(128), \n" +
                "\t\"VERSIONNUM\" VARCHAR2(128), \n" +
                "\t\"FILENAME\" VARCHAR2(512), \n" +
                "\t\"TEMPLATENAME\" VARCHAR2(512), \n" +
                "\t\"OPERATEDATE\" VARCHAR2(20) DEFAULT SYSDATE, \n" +
                "\t\"ACTIONFLAG\" VARCHAR2(1)\n" +
                "   ) ;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(" CREATE TABLE \"ZJXFTYPT\".\"U3C_MG_BRANCHUPLOG\" \n" +
                "   (\t\"ID\" NUMBER(11,0) NOT NULL ENABLE, \n" +
                "\t\"FTPID\" NUMBER(11,0), \n" +
                "\t\"PRODUCTNAME\" VARCHAR2(128), \n" +
                "\t\"VERSIONNUM\" VARCHAR2(128), \n" +
                "\t\"FILENAME\" VARCHAR2(512), \n" +
                "\t\"TEMPLATENAME\" VARCHAR2(512), \n" +
                "\t\"OPERATEDATE\" VARCHAR2(20) DEFAULT SYSDATE, \n" +
                "\t\"ACTIONFLAG\" VARCHAR2(1)\n" +
                "   ) ;\n", result.targetSql);

    }

    @Test
    public void test_1() {
        String sql = "CREATE TABLE \"GLS\".\"T_CIRCAS_AGT_CODE\" \n" +
                "   (\t\"AGT_CODE\" VARCHAR2(20), \n" +
                "\t\"AGT_NAME\" VARCHAR2(60), \n" +
                "\t\"AGT_ADDRESS\" VARCHAR2(100), \n" +
                "\t\"AGT_ORG_TYPE\" VARCHAR2(2), \n" +
                "\t\"AGT_BUSI_NUM\" VARCHAR2(20), \n" +
                "\t\"STARTDATE\" DATE, \n" +
                "\t\"ENDDATE\" DATE DEFAULT date '9999-01-01', \n" +
                "\t\"SIGNDATE\" DATE, \n" +
                "\t\"QUITDATE\" DATE DEFAULT date '9999-01-01', \n" +
                "\t\"ISULQULIFD\" CHAR(1)\n" +
                "   )";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `GLS`.`T_CIRCAS_AGT_CODE` (\n" +
                "\t`AGT_CODE` VARCHAR(20),\n" +
                "\t`AGT_NAME` VARCHAR(60),\n" +
                "\t`AGT_ADDRESS` VARCHAR(100),\n" +
                "\t`AGT_ORG_TYPE` VARCHAR(2),\n" +
                "\t`AGT_BUSI_NUM` VARCHAR(20),\n" +
                "\t`STARTDATE` DATE,\n" +
                "\t`ENDDATE` DATE,\n" +
                "\t`SIGNDATE` DATE,\n" +
                "\t`QUITDATE` DATE,\n" +
                "\t`ISULQULIFD` CHAR(1)\n" +
                ");\n" +
                "CREATE TRIGGER `before_insert_T_CIRCAS_AGT_CODE`\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON `T_CIRCAS_AGT_CODE`\n" +
                "\tBEGIN\n" +
                "\t\tIF NEW.`QUITDATE` IS NULL THEN\n" +
                "\t\t\tSET NEW.`QUITDATE` = DATE '9999-01-01';\n" +
                "\t\tEND IF\n" +
                "\t\tIF NEW.`ENDDATE` IS NULL THEN\n" +
                "\t\t\tSET NEW.`ENDDATE` = DATE '9999-01-01';\n" +
                "\t\tEND IF\n" +
                "\tEND", result.targetSql);

    }
}
