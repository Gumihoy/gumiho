package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.comment;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCommentOnColumnTest_1 {

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
                "COMMENT ON TABLE \"ZBGL\".\"ASSIGNQUOTA\" IS '分配总表'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"FILEID\" IS '分配总序号'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"BUDGETCATEGORYGUID\" IS '指标类型id'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"BUDGETCATEGORYNAME\" IS '指标类型名称'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"CHILDRENNUM\" IS '项目明细的记录数'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"DELIVERDATE\" IS '发文日期'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"DIVISIONGUID\" IS '归口id'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"DIVISIONNAME\" IS '归口名称'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"FILENO\" IS '文号'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"FILETYPE\" IS '文件类型(1正常,2核减,3分配调剂)'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"FLOWID\" IS '流程id'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"MODIFYDATE\" IS '修改日期'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"MONEY\" IS '分配金额'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"MONEYJC1\" IS '省级金额'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"MONEYJC2\" IS '市县金额'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"MONEYJC3\" IS '单列金额'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OLDDELIVERDATE\" IS '原发文日期'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OLDFILENO\" IS '原文号'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OPERATORGUID\" IS '操作员id'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OPERATORGUID1\" IS '撤销的操作员id'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OPERATORNAME\" IS '操作员名称'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"OPERATORNAME1\" IS '撤销的操作员名称'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"STATUS\" IS '状态'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"SUMMARY\" IS '摘要'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"YEAR\" IS '年度'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"CHOICEFLAG\" IS '选择标志'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"CAVFLAG\" IS '8核销完全标志,6未核销标志，7核销未完标志'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"STATEFLAG\" IS '状态标志'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"CSDW\" IS '抄送单位'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"EXPLAIN\" IS '说明'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"ISPRINT\" IS '是否打印标志(省级指标通知单),1为已经打印'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"DATASOURCE\" IS '数据来源(''0'',默认指标生成,''1'',政府采购生成,''2''政府采购净结余/项目资金结余生成,''3''预算外核减''4''指标订正生成'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"HJTYPE\" IS '核减数据类型（‘1’特殊标志的核减数据，无需进行采购的余额判断）'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"YSTYPE\" IS '预算类型1年初预算2追加预算'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"BUDGETYEAR\" IS '指标年度'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"SXJFWJXZ\" IS '市县经费文件性质(从option表取值)'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"RZTIME\" IS '入账时间'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"RZID\" IS '入账序号'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"ZXZJ\" IS '是否专项资金'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"CFILEID\" IS '采购调整正文件对应的负文件fileid'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"DISPFLAG\" IS '以后年度不再发文标识'\n" +
                "/\n" +
                "COMMENT ON COLUMN \"ZBGL\".\"ASSIGNQUOTA\".\"ZYZFHDFLAG\" IS '转移支付核定标识'\n" +
                "/\n";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `ASSIGNQUOTA` (\n" +
                "\t`FILEID` DECIMAL(19) NOT NULL COMMENT '分配总序号',\n" +
                "\t`BUDGETCATEGORYGUID` DECIMAL(19) COMMENT '指标类型id',\n" +
                "\t`BUDGETCATEGORYNAME` VARCHAR(255) COMMENT '指标类型名称',\n" +
                "\t`CHILDRENNUM` DECIMAL(19) COMMENT '项目明细的记录数',\n" +
                "\t`DELIVERDATE` DATETIME COMMENT '发文日期',\n" +
                "\t`DIVISIONGUID` DECIMAL(19) COMMENT '归口id',\n" +
                "\t`DIVISIONNAME` VARCHAR(255) COMMENT '归口名称',\n" +
                "\t`FILENO` VARCHAR(255) COMMENT '文号',\n" +
                "\t`FILETYPE` BIGINT COMMENT '文件类型(1正常,2核减,3分配调剂)',\n" +
                "\t`FLOWID` BIGINT COMMENT '流程id',\n" +
                "\t`MODIFYDATE` DATETIME COMMENT '修改日期',\n" +
                "\t`MONEY` DECIMAL(16, 2) DEFAULT 0 COMMENT '分配金额',\n" +
                "\t`MONEY1` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY10` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY2` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY3` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY4` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY5` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY6` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY7` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY8` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY9` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEYJC1` DECIMAL(16, 2) COMMENT '省级金额',\n" +
                "\t`MONEYJC2` DECIMAL(16, 2) COMMENT '市县金额',\n" +
                "\t`MONEYJC3` DECIMAL(16, 2) COMMENT '单列金额',\n" +
                "\t`OLDDELIVERDATE` DATETIME COMMENT '原发文日期',\n" +
                "\t`OLDFILENO` VARCHAR(255) COMMENT '原文号',\n" +
                "\t`OPERATORGUID` DECIMAL(19) COMMENT '操作员id',\n" +
                "\t`OPERATORGUID1` DECIMAL(19) COMMENT '撤销的操作员id',\n" +
                "\t`OPERATORNAME` VARCHAR(255) COMMENT '操作员名称',\n" +
                "\t`OPERATORNAME1` VARCHAR(255) COMMENT '撤销的操作员名称',\n" +
                "\t`STATUS` BIGINT COMMENT '状态',\n" +
                "\t`SUMMARY` VARCHAR(255) COMMENT '摘要',\n" +
                "\t`YEAR` BIGINT COMMENT '年度',\n" +
                "\t`CHOICEFLAG` TINYINT COMMENT '选择标志',\n" +
                "\t`CAVFLAG` TINYINT COMMENT '8核销完全标志,6未核销标志，7核销未完标志',\n" +
                "\t`STATEFLAG` TINYINT COMMENT '状态标志',\n" +
                "\t`CSDW` VARCHAR(255) COMMENT '抄送单位',\n" +
                "\t`EXPLAIN` VARCHAR(255) COMMENT '说明',\n" +
                "\t`ISPRINT` CHAR(1) DEFAULT '0' COMMENT '是否打印标志(省级指标通知单),1为已经打印',\n" +
                "\t`MONEY11` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY12` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY13` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY14` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY15` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY16` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY17` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY18` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY19` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY20` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`DATASOURCE` CHAR(1) DEFAULT 0 COMMENT '数据来源(\\'0\\',默认指标生成,\\'1\\',政府采购生成,\\'2\\'政府采购净结余/项目资金结余生成,\\'3\\'预算外核减\\'4\\'指标订正生成',\n" +
                "\t`HJTYPE` CHAR(1) COMMENT '核减数据类型（‘1’特殊标志的核减数据，无需进行采购的余额判断）',\n" +
                "\t`YSTYPE` CHAR(1) COMMENT '预算类型1年初预算2追加预算',\n" +
                "\t`BUDGETYEAR` SMALLINT COMMENT '指标年度',\n" +
                "\t`SXJFWJXZ` CHAR(1) COMMENT '市县经费文件性质(从option表取值)',\n" +
                "\t`RZTIME` DATETIME COMMENT '入账时间',\n" +
                "\t`RZID` DECIMAL(19) COMMENT '入账序号',\n" +
                "\t`ZXZJ` CHAR(1) DEFAULT 0 COMMENT '是否专项资金',\n" +
                "\t`ISXPE` CHAR(1) DEFAULT 0,\n" +
                "\t`CFILEID` DECIMAL(19) COMMENT '采购调整正文件对应的负文件fileid',\n" +
                "\t`DISPFLAG` TINYINT DEFAULT 0 COMMENT '以后年度不再发文标识',\n" +
                "\t`BATCHID` VARCHAR(200),\n" +
                "\t`ZYZFHDFLAG` VARCHAR(1) DEFAULT 0 COMMENT '转移支付核定标识',\n" +
                "\tCONSTRAINT `SYS_C0032949` PRIMARY KEY (`FILEID`)\n" +
                ") COMMENT '分配总表';", result.targetSql);
    }
}
