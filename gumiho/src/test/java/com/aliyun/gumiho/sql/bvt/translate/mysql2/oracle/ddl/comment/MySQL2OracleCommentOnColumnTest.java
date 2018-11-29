package com.aliyun.gumiho.sql.bvt.translate.mysql2.oracle.ddl.comment;

import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/13.
 */
public class MySQL2OracleCommentOnColumnTest {

    @Test
    public void test_0() {
        String sql = "CREATE TEMPORARY TABLE `TEST`.`SXE_TEST` (\n" +
                "\t`ID` DECIMAL(20) NOT NULL COMMENT '主键',\n" +
                "\t`NAME` VARCHAR(20) NOT NULL,\n" +
                "\t`EMAIL` VARCHAR(30) NOT NULL,\n" +
                "\t`PHONE` VARCHAR(15) NOT NULL,\n" +
                "\t`ADDRESS` VARCHAR(50) NOT NULL,\n" +
                "\tCONSTRAINT \"SXE_TEST_PK\" PRIMARY KEY (`ID`)\n" +
                ");";
        SQLTransformConfig config = new SQLTransformConfig();
        SQLTransformResult result = SQLTransformUtils.mysqlToOracle(sql);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(result.targetSql);

        Assert.assertEquals(sql, result.targetSql);
    }

}
