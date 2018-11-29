package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.index.create;

import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2PPASCreateIndexTest_0_BITMAP {


    @Test
    public void test() {
        String sql = "CREATE BITMAP INDEX ord_customer_ix ON orders (customer_id);";
        String format = OracleUtils.format(sql);

        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.PPAS_VERSION_9_6;
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE BITMAP INDEX ord_customer_ix ON orders (customer_id);", result.targetSql);

        Assert.assertEquals(1, result.errors.size());
    }

}
