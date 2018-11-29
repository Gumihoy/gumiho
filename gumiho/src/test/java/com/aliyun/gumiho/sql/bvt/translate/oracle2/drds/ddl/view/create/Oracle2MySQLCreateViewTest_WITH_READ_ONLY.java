package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.view.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang
 */
public class Oracle2MySQLCreateViewTest_WITH_READ_ONLY {


    @Test
    public void test_0() {
        String sql = " CREATE VIEW ed_orders_view (o_id, o_date, o_status)\n" +
                "  AS SELECT order_id, order_date, order_status FROM orders\n" +
                "  WITH READ ONLY; ";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(" CREATE VIEW `ed_orders_view` (\n" +
                "\t`o_id`,\n" +
                "\t`o_date`,\n" +
                "\t`o_status`\n" +
                ")\n" +
                "AS\n" +
                "\tSELECT `order_id`, `order_date`, `order_status`\n" +
                "\tFROM `orders`;", result.targetSql);

    }


}
