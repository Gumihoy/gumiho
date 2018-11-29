package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.ddl.index.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformError;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCreateIndexTest_2_CLUSTER_INDEX {


    @Test
    public void test() {
        String sql = "CREATE INDEX idx_personnel ON CLUSTER personnel; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE INDEX `idx_personnel` ON CLUSTER `personnel`;", result.targetSql);

        Assert.assertEquals(1, result.errors.size());

        for (SQLTransformError error : result.errors) {

        }
    }

}
