package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.ddl.index.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCreateIndexTest_3_Column {


    @Test
    public void test_0() {
        String sql = "CREATE INDEX \"BMS\".\"IDX_EFAPD_AP_BILL_NO\" ON \"BMS\".\"EF_AP_DETAIL\" (\"AP_BILL_NO\", 0, 1)";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE INDEX `ord_customer_ix` ON `orders` (\n" +
                "\t`customer_id`\n" +
                ");", result.targetSql);
    }

}
