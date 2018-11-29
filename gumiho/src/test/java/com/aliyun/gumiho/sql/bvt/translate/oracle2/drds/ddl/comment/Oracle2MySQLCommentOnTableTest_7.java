package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.comment;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCommentOnTableTest_7 {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE \"ZBGL\".\"ASSIGNQUOTA\"\n" +
                "(\n" +
                "    \"FILEID\"                       NUMBER(19,0) NOT NULL,\n" +
                "    \"BUDGETCATEGORYGUID\"           NUMBER(19,0),\n" +
                "    \"BUDGETCATEGORYNAME\"           VARCHAR2(255),\n" +
                "    \"CHILDRENNUM\"                  NUMBER(19,0),\n" +
                "    \"DELIVERDATE\"                  DATE,\n" +
                "    \"DIVISIONGUID\"                 NUMBER(19,0),\n" +
                "    \"DIVISIONNAME\"                 VARCHAR2(255),\n" +
                "    \"FILENO\"                       VARCHAR2(255),\n" +
                "    \"FILETYPE\"                     NUMBER(10,0),\n" +
                "    \"FLOWID\"                       NUMBER(10,0),\n" +
                "    \"MODIFYDATE\"                   DATE,\n" +
                "    \"MONEY\"                        NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY1\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY10\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY2\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY3\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY4\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY5\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY6\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY7\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY8\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY9\"                       NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEYJC1\"                     NUMBER(16,2),\n" +
                "    \"MONEYJC2\"                     NUMBER(16,2),\n" +
                "    \"MONEYJC3\"                     NUMBER(16,2),\n" +
                "    \"OLDDELIVERDATE\"               DATE,\n" +
                "    \"OLDFILENO\"                    VARCHAR2(255),\n" +
                "    \"OPERATORGUID\"                 NUMBER(19,0),\n" +
                "    \"OPERATORGUID1\"                NUMBER(19,0),\n" +
                "    \"OPERATORNAME\"                 VARCHAR2(255),\n" +
                "    \"OPERATORNAME1\"                VARCHAR2(255),\n" +
                "    \"STATUS\"                       NUMBER(10,0),\n" +
                "    \"SUMMARY\"                      VARCHAR2(255),\n" +
                "    \"YEAR\"                         NUMBER(10,0),\n" +
                "    \"CHOICEFLAG\"                   NUMBER(2,0),\n" +
                "    \"CAVFLAG\"                      NUMBER(2,0),\n" +
                "    \"STATEFLAG\"                    NUMBER(2,0),\n" +
                "    \"CSDW\"                         VARCHAR2(255),\n" +
                "    \"EXPLAIN\"                      VARCHAR2(255),\n" +
                "    \"ISPRINT\"                      CHAR(1) DEFAULT '0',\n" +
                "    \"MONEY11\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY12\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY13\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY14\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY15\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY16\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY17\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY18\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY19\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"MONEY20\"                      NUMBER(16,2) DEFAULT 0,\n" +
                "    \"DATASOURCE\"                   CHAR(1) DEFAULT 0,\n" +
                "    \"HJTYPE\"                       CHAR(1),\n" +
                "    \"YSTYPE\"                       CHAR(1),\n" +
                "    \"BUDGETYEAR\"                   NUMBER(4,0),\n" +
                "    \"SXJFWJXZ\"                     CHAR(1),\n" +
                "    \"RZTIME\"                       DATE,\n" +
                "    \"RZID\"                         NUMBER(19,0),\n" +
                "    \"ZXZJ\"                         CHAR(1) DEFAULT 0,\n" +
                "    \"ISXPE\"                        CHAR(1) DEFAULT 0,\n" +
                "    \"CFILEID\"                      NUMBER(19,0),\n" +
                "    \"DISPFLAG\"                     NUMBER(1,0) DEFAULT 0,\n" +
                "    \"BATCHID\"                      VARCHAR2(200),\n" +
                "    \"ZYZFHDFLAG\"                   VARCHAR2(1) DEFAULT 0,\n" +
                "    CONSTRAINT \"SYS_C0032949\" PRIMARY KEY (\"FILEID\") USING INDEX\n" +
                "        ENABLE\n" +
                ")\n" +
                "/\n" +
                "COMMENT ON TABLE \"ZBGL\".\"ASSIGNQUOTA\" IS '分配总表'";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);
    }
}
