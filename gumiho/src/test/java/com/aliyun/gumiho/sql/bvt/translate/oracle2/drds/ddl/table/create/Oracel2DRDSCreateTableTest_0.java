package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.table.create;

import com.aliyun.gumiho.sql.config.DRDSConfig;
import com.aliyun.gumiho.sql.dialect.drds.ast.enums.DRDSSQLDBPartitionType;
import com.aliyun.gumiho.sql.dialect.drds.ast.enums.DRDSSQLTBPartitionType;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracel2DRDSCreateTableTest_0 {

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
        SQLTransformResult result = SQLTransformUtils.oracleToDRDS(sql);
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
        String sql = "CREATE TABLE \"WEB_WSSB\".\"SB_BZ\" (\n" +
                "            \"PZXH\" NUMBER(20, 0) NOT NULL ENABLE,\n" +
                "\t\"NSRSBH\" VARCHAR2(40) NOT NULL ENABLE,\n" +
                "\t\"NSRDZDAH\" NUMBER(20, 0) NOT NULL ENABLE,\n" +
                "\t\"SSSQ_Q\" DATE NOT NULL ENABLE,\n" +
                "\t\"SSSQ_Z\" DATE NOT NULL ENABLE,\n" +
                "\t\"BZ\" CHAR(1) DEFAULT '0' NOT NULL ENABLE,\n" +
                "            \"ZSXM_DM\" VARCHAR2(10) NOT NULL ENABLE,\n" +
                "\t\"SBRQ\" DATE NOT NULL ENABLE,\n" +
                "\t\"PZZL_DM\" VARCHAR2(18) NOT NULL ENABLE,\n" +
                "\t\"JYBZ\" CHAR(1) DEFAULT '0',\n" +
                "            \"SE\" NUMBER(16, 2),\n" +
                "\t\"KKBZ\" VARCHAR2(8) DEFAULT '0',\n" +
                "            \"KKZG\" VARCHAR2(2) DEFAULT '0',\n" +
                "            \"DR_MSG\" VARCHAR2(4000),\n" +
                "\t\"YZPZXH\" NUMBER(20, 0),\n" +
                "\t\"KKDR_BZ\" VARCHAR2(6),\n" +
                "\t\"RES_1\" VARCHAR2(400),\n" +
                "\t\"KKDR_MSG\" VARCHAR2(4000),\n" +
                "\t\"NSR_SWJG_DM\" VARCHAR2(22),\n" +
                "\t\"YHZL_DM\" VARCHAR2(10),\n" +
                "\t\"YH_DM\" VARCHAR2(26),\n" +
                "\t\"YHZH\" VARCHAR2(100),\n" +
                "\t\"SKGK_DM\" VARCHAR2(22),\n" +
                "\t\"KKRQ\" DATE,\n" +
                "            \"DZJG\" VARCHAR2(4),\n" +
                "\t\"DRRQ\" DATE,\n" +
                "            \"LXBZ\" VARCHAR2(8) DEFAULT '0' NOT NULL ENABLE,\n" +
                "            \"SHBZ\" CHAR(3) DEFAULT '000',\n" +
                "            \"SHRQ4\" DATE,\n" +
                "            \"SHRQ3\" DATE,\n" +
                "            \"SHRQ2\" DATE,\n" +
                "            \"SHRQ1\" DATE,\n" +
                "            \"SBRQ4\" DATE,\n" +
                "            \"SBRQ3\" DATE,\n" +
                "            \"SBRQ2\" DATE,\n" +
                "            \"SBRQ1\" DATE,\n" +
                "            \"SMYY\" VARCHAR2(2000),\n" +
                "\t\"SF_DJSZ\" CHAR(1),\n" +
                "\t\"SBQX\" DATE,\n" +
                "            \"GZSB\" CHAR(1) DEFAULT '0',\n" +
                "            \"YQSB\" CHAR(1) DEFAULT '0',\n" +
                "            \"CBSB\" CHAR(1) DEFAULT '0',\n" +
                "            \"ZFSJ\" DATE,\n" +
                "            \"ZFRY\" VARCHAR2(200),\n" +
                "\t\"WCJYBH\" VARCHAR2(200),\n" +
                "\t\"JCYWBZ\" CHAR(1) DEFAULT NULL,\n" +
                "\t\"PBBDJG\" CHAR(1),\n" +
                "\t\"DSDJXH\" NUMBER(20, 0),\n" +
                "\t\"SCRQ\" DATE DEFAULT SYSDATE,\n" +
                "            \"KQYBZ\" CHAR(1),\n" +
                "\t\"GSDJXH\" NUMBER(20, 0),\n" +
                "\t\"WSID\" VARCHAR2(64)\n" +
                ");\n";

        SQLTransformConfig config = new SQLTransformConfig();
        SQLTransformConfig.TableMapping tableMapping = new SQLTransformConfig.TableMapping("WEB_WSSB.SB_BZ", "WEB_WSSB.SB_BZ");
        DRDSConfig drdsConfig = new DRDSConfig();
        drdsConfig.dbPartition = new DRDSConfig.DRDSDBPartition(DRDSSQLDBPartitionType.RANGE_HASH, "PZXH");
        drdsConfig.tbPartition = new DRDSConfig.DRDSTBPartition(DRDSSQLTBPartitionType.RANGE_HASH, "PZXH");

        tableMapping.drdsConfig = drdsConfig;

        config.addTableMapping(tableMapping);

        SQLTransformResult result = SQLTransformUtils.oracleToDRDS(sql, config);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `WEB_WSSB.SB_BZ` (\n" +
                "\t`PZXH` DECIMAL(20, 0) NOT NULL,\n" +
                "\t`NSRSBH` VARCHAR(40) NOT NULL,\n" +
                "\t`NSRDZDAH` DECIMAL(20, 0) NOT NULL,\n" +
                "\t`SSSQ_Q` DATE NOT NULL,\n" +
                "\t`SSSQ_Z` DATE NOT NULL,\n" +
                "\t`BZ` CHAR(1) NOT NULL DEFAULT '0',\n" +
                "\t`ZSXM_DM` VARCHAR(10) NOT NULL,\n" +
                "\t`SBRQ` DATE NOT NULL,\n" +
                "\t`PZZL_DM` VARCHAR(18) NOT NULL,\n" +
                "\t`JYBZ` CHAR(1) DEFAULT '0',\n" +
                "\t`SE` DECIMAL(16, 2),\n" +
                "\t`KKBZ` VARCHAR(8) DEFAULT '0',\n" +
                "\t`KKZG` VARCHAR(2) DEFAULT '0',\n" +
                "\t`DR_MSG` TEXT,\n" +
                "\t`YZPZXH` DECIMAL(20, 0),\n" +
                "\t`KKDR_BZ` VARCHAR(6),\n" +
                "\t`RES_1` VARCHAR(400),\n" +
                "\t`KKDR_MSG` TEXT,\n" +
                "\t`NSR_SWJG_DM` VARCHAR(22),\n" +
                "\t`YHZL_DM` VARCHAR(10),\n" +
                "\t`YH_DM` VARCHAR(26),\n" +
                "\t`YHZH` VARCHAR(100),\n" +
                "\t`SKGK_DM` VARCHAR(22),\n" +
                "\t`KKRQ` DATE,\n" +
                "\t`DZJG` VARCHAR(4),\n" +
                "\t`DRRQ` DATE,\n" +
                "\t`LXBZ` VARCHAR(8) NOT NULL DEFAULT '0',\n" +
                "\t`SHBZ` CHAR(3) DEFAULT '000',\n" +
                "\t`SHRQ4` DATE,\n" +
                "\t`SHRQ3` DATE,\n" +
                "\t`SHRQ2` DATE,\n" +
                "\t`SHRQ1` DATE,\n" +
                "\t`SBRQ4` DATE,\n" +
                "\t`SBRQ3` DATE,\n" +
                "\t`SBRQ2` DATE,\n" +
                "\t`SBRQ1` DATE,\n" +
                "\t`SMYY` VARCHAR(2000),\n" +
                "\t`SF_DJSZ` CHAR(1),\n" +
                "\t`SBQX` DATE,\n" +
                "\t`GZSB` CHAR(1) DEFAULT '0',\n" +
                "\t`YQSB` CHAR(1) DEFAULT '0',\n" +
                "\t`CBSB` CHAR(1) DEFAULT '0',\n" +
                "\t`ZFSJ` DATE,\n" +
                "\t`ZFRY` VARCHAR(200),\n" +
                "\t`WCJYBH` VARCHAR(200),\n" +
                "\t`JCYWBZ` CHAR(1) DEFAULT NULL,\n" +
                "\t`PBBDJG` CHAR(1),\n" +
                "\t`DSDJXH` DECIMAL(20, 0),\n" +
                "\t`SCRQ` DATE,\n" +
                "\t`KQYBZ` CHAR(1),\n" +
                "\t`GSDJXH` DECIMAL(20, 0),\n" +
                "\t`WSID` VARCHAR(64)\n" +
                ")\n" +
                "DBPARTITION BY RANG_HASH (`PZXH`)\n" +
                "\tTBPARTITION BY RANG_HASH (`PZXH`);\n" +
                "CREATE TRIGGER `before_insert_WEB_WSSB.SB_BZ`\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON `WEB_WSSB.SB_BZ`\n" +
                "\tBEGIN\n" +
                "\t\tIF NEW.`SCRQ` IS NULL THEN\n" +
                "\t\t\tSET NEW.`SCRQ` = SYSDATE();\n" +
                "\t\tEND IF\n" +
                "\tEND", result.targetSql);

    }


}
